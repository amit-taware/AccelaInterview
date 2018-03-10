package Steps;

import Pages.Homepage;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import reports.ReadFromPropertiesFile;

public class Steps {

    private static String exeEnvironment = "uat";

    private static String getExeEnvironment() {
        return exeEnvironment;
    }

    public static ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile(getExeEnvironment());

    private Homepage homepage;

    @Before()
    public void beforeScenario(Scenario scenario) throws Exception {

        homepage = new Homepage();
        homepage.prepare(scenario);
        homepage.initElements();
    }

    @After()
    public void afterScenario(Scenario scenario) throws Throwable {
        homepage.cleanUp(scenario);
    }

    @When("^I got to APP URL$")
    public void i_got_to_APP_URL() throws Throwable {
        String baseUrl = readFromPropertiesFile.readPropertiesFile("appURL");
        homepage.navigateTo(baseUrl);
    }

    @Then("^I verify home page is opened$")
    public void i_verify_home_page_is_opened() throws Throwable {
    }

    @Then("^I hover on menu 'Adventure'$")
    public void i_hover_on_menu_Adventure() throws Throwable {
        homepage.selectProduct();
    }

    @Then("^I click on link 'Adventure For Two'$")
    public void i_click_on_link_Adventure_For_Two() throws Throwable {
    }

    @When("^I select my product$")
    public void i_select_my_product() throws Throwable {
    }

    @Then("^I verify that correct price is displayed on the page$")
    public void i_verify_that_correct_price_is_displayed_on_the_page() throws Throwable {
        Assert.assertTrue("Price is not displayed on screen", homepage.isPriceDisplayed());
    }

    @When("^I click on 'Buy Now' button$")
    public void i_click_on_Buy_Now_button() throws Throwable {

        homepage.clickBuyNowButton();
    }

    @Then("^I verify that product is being added into basket$")
    public void i_verify_that_product_is_being_added_into_basket() throws Throwable {

        Assert.assertTrue("Product is not being added to basket", homepage.isProductAddedinBasket());
    }

    @Then("^I add personalised message$")
    public void i_add_personalised_message() throws Throwable {
        homepage.writeMessage();
    }

    @Then("^I select 'E-Voucher' delivery method$")
    public void i_select_E_Voucher_delivery_method() throws Throwable {
        homepage.selectDeliveryMethodEVoucher();
    }

    @Then("^I verify that No additional delivery charge is added when E-Voucher is selected$")
    public void i_verify_that_No_additional_delivery_charge_is_added_when_E_Voucher_is_selected() throws Throwable {
        Assert.assertTrue("Additional delivery charge is added when E-Voucher is selected", homepage.areAdditionalPriceApplied());
    }

    @Then("^I verify that correct product price is displayed in the users basket$")
    public void i_verify_that_correct_product_price_is_displayed_in_the_users_basket() throws Throwable {
        Assert.assertTrue("correct product price is not displayed in the basket", homepage.IsPriceCorrectInBasket());

    }

    @When("^I click on 'Pay Securely Now' button$")
    public void i_click_on_Pay_Securely_Now_button() throws Throwable {
        homepage.clickPaySecurlyNowButton();
    }

    @Then("^I verify that checkout page is opened$")
    public void i_verify_that_checkout_page_is_opened() throws Throwable {
        Assert.assertTrue("checkout page is not opened", homepage.isCheckoutHappened());

    }

    @Then("^I enter email$")
    public void i_enter_email() throws Throwable {
        homepage.inputEmail();
    }

    @Then("^I click on 'Continue as a Guest' Button$")
    public void i_click_on_Continue_as_a_Guest_Button() throws Throwable {
        homepage.clickContinueAsGuest();
    }

    @Then("^I  add  Title, First Name, Last Name, Telephone Number$")
    public void i_add_Title_First_Name_Last_Name_Telephone_Number() throws Throwable {

        homepage.fillUserDetails();
    }

    @Then("^I add my billing address$")
    public void i_add_my_billing_address() throws Throwable {

        homepage.addBillingAddress();
    }

    @When("^I enters a fake credit card number and proceeds$")
    public void i_enters_a_fake_credit_card_number_and_proceeds() throws Throwable {

        homepage.enterCCDetails();
    }

    @Then("^An error message is displayed$")
    public void an_error_message_is_displayed() throws Throwable {

        Assert.assertTrue("An error message is displayed", homepage.isPaymentErrorDisplayed());

    }


}
