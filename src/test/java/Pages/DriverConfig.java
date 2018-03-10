package Pages;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ReadFromPropertiesFile;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DriverConfig {

    protected static WebDriver driver;
    private static Scenario scenario;

    private static String exeEnvironment = "uat";
    private static ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile(getExeEnvironment());


    private static String getExeEnvironment() {
        return exeEnvironment;
    }


    public DriverConfig() {
        // Empty constructor
    }

    public void prepare(Scenario scenario) throws Exception {

        if (readFromPropertiesFile.readPropertiesFile("executeLocal").equalsIgnoreCase("y")) {
            executeOnLocal();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }

    }

    private void executeOnLocal() {
        try {
            System.out.println("Executing on local system");
            // Code to read scenario and feature name
            if (readFromPropertiesFile.readPropertiesFile("browser").equalsIgnoreCase("chrome")) {
                String chromeDriverPath = readFromPropertiesFile.readPropertiesFile("chromeDriverPath");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverPath);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                System.out.println("Opening browser " + readFromPropertiesFile.readPropertiesFile("browser"));
            }

        } catch (Exception e) {
            System.out.println("Unable to execute on local. Please check the configuration " + e.getMessage());
        }
    }


    public void cleanUp(Scenario scenario) throws InterruptedException, IOException {


        // Add Screen shot for failure
        if (scenario.isFailed() && readFromPropertiesFile.readPropertiesFile("executeLocal").equalsIgnoreCase("y")) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");

            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }


        System.out.println("Closing browser ");
        driver.close();
        driver.quit();
    }


    protected static boolean isClickable(WebElement el, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void waituntilAjaxCallEnds(WebElement el,WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(el));
        wait.until(ExpectedConditions.invisibilityOf(el));
    }

    protected boolean isElementDisplayed(WebElement el) {
        try {
            el.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, int timeoutInSeconds){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try{
            webDriverWait.until(waitCondition);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void untilJqueryIsDone(WebDriver driver, int timeoutInSeconds){
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }

}
