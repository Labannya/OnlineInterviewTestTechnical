package Library;

/*This class is used for creating all the actions sued for the test case steps
* */

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import sun.nio.ch.IOUtil;

import java.io.*;

public class Locator {

    public WebDriver driver ;
    /* This action method is used for to click any clickable element
    * Webelement address is clicked by the driver regarding the mentioned type */

    public void buttonAction(String address,String type){
        if(type.equalsIgnoreCase("XPath")) {
            driver.findElement(By.xpath(address)).click();
        }
        else if(type.equalsIgnoreCase("ID")){
            driver.findElement(By.id(address)).click();
        }
        else if(type.equalsIgnoreCase("Name")){
            driver.findElement(By.name(address)).click();
        }

    }

    /* Webelement address is hovered by the driver regarding the mentioned type */
    public void mousehover(String address, String type){
        Actions action = new Actions(driver);
        WebElement element=null;
        if(type.equalsIgnoreCase("Xpath")){
            element = driver.findElement(By.xpath(address));
        }

        else if(type.equalsIgnoreCase("Id")){
            element = driver.findElement(By.id(address));
        }

        if(type.equalsIgnoreCase("Name")){
            element = driver.findElement(By.id(address));
        }
        action.moveToElement(element).build().perform();

    }

    /* Webelement address is hovered and clicked by the driver regarding the mentioned type */
    public void mousehovertoClick(String address, String type){
        Actions action = new Actions(driver);
        WebElement element=null;
        if(type.equalsIgnoreCase("Xpath")){
            element = driver.findElement(By.xpath(address));
        }

        else if(type.equalsIgnoreCase("Id")){
            element = driver.findElement(By.id(address));
        }

        if(type.equalsIgnoreCase("Name")){
            element = driver.findElement(By.id(address));
        }
        System.out.println(element.getText());
        action.moveToElement(element).click();


    }



   /* Webelement address is verified by the driver regarding the mentioned type */
    public void verifyElement(String elementAddress,String type) {
        if (type.equalsIgnoreCase("XPath")) {
            driver.findElement(By.xpath(elementAddress)).isDisplayed();

        } else if (type.equalsIgnoreCase("ID")) {
            driver.findElement(By.id(elementAddress)).isDisplayed();
        } else if (type.equalsIgnoreCase("Name")) {
            driver.findElement(By.name(elementAddress)).isDisplayed();
        }
    }

    /* Webelement address is input by the testdata by the driver regarding the mentioned type */
    public void textbox(String elementAddress, String type, String input){
        if (type.equalsIgnoreCase("XPath")) {
            driver.findElement(By.xpath(elementAddress)).clear();
            driver.findElement(By.xpath(elementAddress)).sendKeys(input);
        } else if (type.equalsIgnoreCase("ID")) {
            driver.findElement(By.id(elementAddress)).clear();
            driver.findElement(By.id(elementAddress)).sendKeys(input);
        } else if (type.equalsIgnoreCase("Name")) {
            driver.findElement(By.name(elementAddress)).clear();
            driver.findElement(By.name(elementAddress)).sendKeys(input);
        }
    }
    /* To get the chromedriver*/
    public void getChromeDriver(){
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*To set the url*/
    public void setURL(String url){
        driver.get(url);
    }

    /* Webelement address geets data by the driver regarding the mentioned type */
    public String getData(String address,String type){
        String locatorText=null;
        if(type.equalsIgnoreCase("XPath")) {
            locatorText = driver.findElement(By.xpath(address)).getText();
        }

        else if(type.equalsIgnoreCase("Id")) {
            locatorText = driver.findElement(By.id(address)).getText();
        }
        if(type.equalsIgnoreCase("Name")) {
            locatorText = driver.findElement(By.name(address)).getText();
        }

        return locatorText;
    }


    /* Webelement address is clicked by the driver regarding the mentioned type */
    public void storeData(String address,String type) throws IOException {
        String data = getData(address,type);
        File file = new File("src\\test\\store\\saveData.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        else{
            file.delete();
            file.createNewFile();
        }

        FileWriter output = new FileWriter(file);
        output.write(data);
        output.close();
    }

    /* Webelement address gets partial by the driver regarding the mentioned type and store it in the store package in saveData.txt file*/
    public void storePartialData(String address,String type) throws IOException {
        String data = getData(address,type);
        File file = new File("src\\test\\store\\saveData.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        else{
            file.delete();
            file.createNewFile();
        }

        FileWriter output = new FileWriter(file);
        output.write(data);
    }

    /* Read the stored data*/
    public String readData() throws IOException {
        File readFile = new File("src\\test\\store\\saveData.txt");
        FileInputStream input = new FileInputStream(readFile);

        String expectedText = IOUtils.toString(input);
        return expectedText;
    }

    /*Verify the actual text comparing to the stored expected text*/
    public void verifyActualTextComparingStoresdata(String address,String type) throws IOException {
        String actualText=null;
      if(type.equalsIgnoreCase("XPath")){
         actualText=driver.findElement(By.xpath(address)).getText();
      }
      else if(type.equalsIgnoreCase("Id")){
            actualText=driver.findElement(By.id(address)).getText();
        }

      else if(type.equalsIgnoreCase("name")){
          actualText=driver.findElement(By.name(address)).getText();
      }
      String expectedText = readData();

          Assert.assertTrue(expectedText.contains(actualText));


    }
    /*Verify and compare the expected and actual text*/
    public void verifyActualText(String address,String type,String expectedText){
        String actualText = null;
        if (type.equalsIgnoreCase("XPath")) {
            actualText = driver.findElement(By.xpath(address)).getText();
        } else if (type.equalsIgnoreCase("Id")) {
            actualText = driver.findElement(By.id(address)).getText();
        } else if (type.equalsIgnoreCase("name")) {
            actualText = driver.findElement(By.name(address)).getText();
        }
         Assert.assertEquals(expectedText,actualText);
    }

    /*Retrive data from the stored text*/
    public String retriveData(String address,String type,int beginReduce,int endREduce){
        String locatorText=null;
        if(type.equalsIgnoreCase("XPath")) {
            locatorText = driver.findElement(By.xpath(address)).getText();
        }

        else if(type.equalsIgnoreCase("Id")) {
            locatorText = driver.findElement(By.id(address)).getText();
        }
        if(type.equalsIgnoreCase("Name")) {
            locatorText = driver.findElement(By.name(address)).getText();
        }
        locatorText = locatorText.substring(beginReduce);
        locatorText= locatorText.replace(locatorText.substring(locatorText.length()-endREduce),"");
        return locatorText;
    }

    /*To refresh the browser*/
    public void refreshBrowser(){
        driver.navigate().refresh();
    }

    /*To close the browser*/
    public void closeBrowser(){
        if(driver !=null){
            driver.quit();
        }
    }

    /*To save the screenshot as proof*/
    public void screenshot(String screenName) throws IOException {
        File file = new File("src\\test\\java\\screenshot");
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File savedFile = new File(file+"//"+screenName+".png");
        if(savedFile.exists()){
            savedFile.delete();
            savedFile.createNewFile();
        }
        else{
            savedFile.createNewFile();
        }
        FileUtils.copyFile(imageFile,savedFile);
    }

}





