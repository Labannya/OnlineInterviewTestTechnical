package Interview;

import Library.Locator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;




public class EditProfileTest {
    public WebDriver driver=null;
    Locator element1 = new Locator();

    @Given("^I have navigated to the online shopping page$")
    public void openBrowser(){
        element1.getChromeDriver();
        element1.setURL("http://automationpractice.com");
    }

    @Given("^I login to my account to change my account details$")
    public void accountLogin(){
        element1.buttonAction("//a[contains(text(),'Sign in')]","xpath");
        element1.textbox("//input[@id='email']","xpath","frameworkbuild@gmail.com");
        element1.textbox("//input[@id='passwd']","xpath","Framework1!");
        element1.buttonAction("SubmitLogin","id");
    }

    @Given("^I have navigated to the my profile page$")
    public void navigateProfile() throws InterruptedException {


        element1.buttonAction("//a[@title='Information']", "xpath");


    }

    @When("^I change my account forename$")
    public void changeDetails() {
        element1.textbox("firstname", "Id", "Second");
        element1.textbox("old_passwd", "Id", "Framework1!");
        element1.textbox("passwd", "Id", "Framework1!");
        element1.textbox("confirmation", "Id", "Framework1!");
        element1.buttonAction("//span[contains(text(),'Save')]", "XPath");

    }



    @Then("^the success message should to be appeared$")
    public void verifySuccessMessage(){

        element1.verifyElement("//p[@class='alert alert-success']","xpath");
    }

    @Then("^I should  see that profile is updated$")
    public void profileUpdate() throws InterruptedException, IOException {
        element1.refreshBrowser();
        Thread.sleep(5000);
        element1.verifyActualText("//span[contains(text(),'Second')]","xpath","Second Test");
        element1.screenshot("TestCase_2");
        element1.closeBrowser();
    }
}
