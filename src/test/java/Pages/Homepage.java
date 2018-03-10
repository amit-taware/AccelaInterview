package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends DriverConfig {

    @FindBy(how = How.CSS, using = "#menu > ul > li.nav-adventure.submenu > a")
    private WebElement adventureMenu;

    @FindBy(how = How.CSS, using = "div.menu-panel.container > div.menu-inner.container > div.row.menu-inner-row > ul.categories > li.nav-mid-adventure-for-two > a")
    private WebElement adventureForTwoSubmenu;

    @FindBy(how = How.CSS, using = "#productlist-results > a:nth-of-type(1) > img.productlist-productimage")
    private WebElement myProduct;

    @FindBy(how = How.CSS, using = "button.btn.btn-transactional.top")
    private WebElement buyNowButton;

    @FindBy(how = How.CSS, using = "textarea.form-control")
    private WebElement personalisedMessageBox;

    @FindBy(how = How.CSS, using = "div.form-group.packaging_options.additional_details_panel > div:nth-of-type(2) > label > input")
    private WebElement eVoucharRedioButton;

    @FindBy(how = How.CSS, using = "button.btn.dropdown-toggle.buynow.pay-secure-now-top")
    private WebElement paySecurlyNowButton;

    @FindBy(how = How.CSS, using = "div.ajax_loader > img")
    private WebElement ajaxloader;

    @FindBy(how = How.CSS, using = "#account_email_field")
    private WebElement accountEmailField;

    @FindBy(how = How.CSS, using = "#checkout_capture > div:nth-of-type(5) > button.btn.login_guest.chk_btns")
    private WebElement loginasGuest;

    @FindBy(how = How.CSS, using = "#titlefield")
    private WebElement titleField;

    @FindBy(how = How.CSS, using = "#firstnamefield")
    private WebElement firstName;

    @FindBy(how = How.CSS, using = "#lastnamefield")
    private WebElement lastName;

    @FindBy(how = How.CSS, using = "#telephonenumberfield")
    private WebElement tele;

    @FindBy(how = How.CSS, using = "button.btn.login_continue.chk_btns.pull-right")
    private WebElement firstContinueButton;

    @FindBy(how = How.XPATH, using = "//ui-view[@id='postCodeSearchBilling']/div//input[@name='PostCode']")
    private WebElement postalcode;

    @FindBy(how = How.XPATH, using = "//ui-view[@id='postCodeSearchBilling']/div//button[@type='button']")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//section[@id='chk_steps']/div[2]/section[@class='delivery_details ng-scope']/div[2]/div[4]/button[@type='button']")
    private WebElement secondContinueButton;

    @FindBy(how = How.CSS, using = "#cardholdername")
    private WebElement cardHolderName;

    @FindBy(how = How.CSS, using = "#cardnumber")
    private WebElement cardNumber;

    @FindBy(how = How.CSS, using = "#expirymonth")
    private WebElement expiryMonth;

    @FindBy(how = How.CSS, using = "#expiryyear")
    private WebElement expiryYear;

    @FindBy(how = How.CSS, using = "#startmonth")
    private WebElement startMonth;

    @FindBy(how = How.CSS, using = "#startyear")
    private WebElement startYear;

    @FindBy(how = How.CSS, using = "#cvvnumber")
    private WebElement cvvnumber;

    @FindBy(how = How.CSS, using = ".billingpayment_details .chk_placeorder button")
    private WebElement placeOrderButton;

    @FindBy(how = How.XPATH, using = "/html//div[@id='product-price-current']")
    private WebElement priceOfProduct;

    @FindBy(how = How.XPATH, using = "/html//section[@id='basket_contents']/div[@class='ng-scope']/form[@class='form-inline ng-pristine ng-valid ng-valid-maxlines']/div//a[@href='']")
    private WebElement productinBasket;

    @FindBy(how = How.CSS, using = "div.delivery_totals > span.cost_price")
    private WebElement deliveryTotal;

    @FindBy(how = How.CSS, using = "span.prd_price")
    private WebElement basketProductPrice;

    @FindBy(how = How.CSS, using = ".checkout_summary_inner h3")
    private WebElement checkoutSummaryText;

    @FindBy(how = How.CSS, using = "section.billingpayment_details > div:nth-of-type(1) > span.error")
    private WebElement paymentError;


    public Homepage() {

        PageFactory.initElements(driver, this);
    }

    public void initElements() {

        PageFactory.initElements(driver, this);
    }

    public Homepage navigateTo(String baseUrl) {
        System.out.println("Navigating to  " + baseUrl);
        driver.get(baseUrl);
        return this;
    }

    public void selectProduct() {

        Actions action = new Actions(driver);
        action.moveToElement(adventureMenu).perform();
        adventureForTwoSubmenu.click();
        myProduct.click();
    }


    public void clickBuyNowButton() {

        untilJqueryIsDone(driver, 10);
        if (isClickable(buyNowButton, driver)) {

            buyNowButton.click();
        }
    }

    public void writeMessage() {

        personalisedMessageBox.sendKeys("This is my gift to you");
    }

    public void selectDeliveryMethodEVoucher() {

        eVoucharRedioButton.click();
    }

    public void clickPaySecurlyNowButton() {

        waituntilAjaxCallEnds(ajaxloader, driver);

        paySecurlyNowButton.click();

        if (isAlertPresent()) {

            driver.switchTo().alert();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }


    public void inputEmail() {

        accountEmailField.sendKeys("accelainterciew@accel.com");
    }

    public void clickContinueAsGuest() {

        loginasGuest.click();
        waituntilAjaxCallEnds(ajaxloader, driver);

    }

    public void fillUserDetails() {

        titleField.sendKeys("Mr.");
        firstName.sendKeys("Amit");
        lastName.sendKeys("T");
        tele.sendKeys("1234324");
        firstContinueButton.click();
        waituntilAjaxCallEnds(ajaxloader, driver);

    }

    public void addBillingAddress() {

        if (isClickable(postalcode, driver)) {
            postalcode.sendKeys("WC2N 5DU");
        }
        searchButton.sendKeys(Keys.TAB);
        searchButton.sendKeys(Keys.ENTER);
        waituntilAjaxCallEnds(ajaxloader, driver);
    }

    public void enterCCDetails() {
        cardHolderName.sendKeys("Amit T");
        cardNumber.sendKeys("1234564354631245");
        expiryMonth.sendKeys("1");
        expiryYear.sendKeys("2020");
        startMonth.sendKeys("1");
        startYear.sendKeys("2015");
        cvvnumber.sendKeys("272");
        placeOrderButton.sendKeys(Keys.TAB);
        placeOrderButton.sendKeys(Keys.TAB);
        placeOrderButton.sendKeys(Keys.ENTER);


    }

    public boolean isPriceDisplayed() {
        return isElementDisplayed(priceOfProduct);
    }

    public boolean isProductAddedinBasket() {

        return isElementDisplayed(productinBasket);

    }

    public boolean areAdditionalPriceApplied() {
        return deliveryTotal.getText() != "£0.00";
    }

    public boolean IsPriceCorrectInBasket() {
        return basketProductPrice.getText() != "£39.99";
    }

    public boolean isCheckoutHappened() {
        return isElementDisplayed(checkoutSummaryText);

    }

    public boolean isPaymentErrorDisplayed() {
        return isElementDisplayed(paymentError);

    }
}
