package Interview;


import Library.Locator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class OnlineShoppingTest {
    public WebDriver driver;
    Locator element = new Locator();
    @Given("^I have navigated to the online page$")
    public void openBrowser(){
        element.getChromeDriver();
        element.setURL("http://automationpractice.com");
    }

    @Given("^I login to my account$")
    public void accountLogin(){
        element.buttonAction("//a[contains(text(),'Sign in')]","xpath");
        element.textbox("//input[@id='email']","xpath","frameworkbuild@gmail.com");
        element.textbox("//input[@id='passwd']","xpath","Framework1!");
        element.buttonAction("SubmitLogin","id");
    }

    @When("^I order a shirt$")
    public void orderTShirt() throws InterruptedException, IOException {
        //element.alertDismiss();
        element.buttonAction("//*[@id='block_top_menu']//ul[contains(@class,'sf-menu')]//li[3]//a[contains(text(),'T-shirts')]", "xpath");
        element.mousehover("//img[@title='Faded Short Sleeve T-shirts']", "xpath");
        element.buttonAction("//span[contains(text(),'Add to cart')]", "xpath");//add cart


        element.mousehover("//a[@title='Proceed to checkout']/span","xpath");
        Thread.sleep(1000);
        element.buttonAction("//a[@title='Proceed to checkout']/span", "xpath");
        Thread.sleep(1000);
        element.buttonAction("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']/span", "xpath");
        element.buttonAction("processAddress","name");
        element.buttonAction("cgv","id");
        element.buttonAction("//p[@class='cart_navigation clearfix']//button[@name='processCarrier']/span", "xpath");
        element.buttonAction("//a[@title='Pay by check.']","xpath");
        element.buttonAction("//p[@class='cart_navigation clearfix']//button[@type='submit']", "xpath");
        element.storeData("//div[@class='box order-confirmation']","xpath");


    }

    @Then("^I should see that my order is exist in orderhistory$")
    public void verifyOrderExist() throws IOException, InterruptedException {
        element.buttonAction("//a[@title='Back to orders']","xpath");
        element.verifyActualTextComparingStoresdata("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a","xpath");
        Thread.sleep(5000);
        element.screenshot("TestCase_1");
        element.closeBrowser();
    }





}

