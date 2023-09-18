package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;

public class Amazon {
    private WebDriver driver; // Declare WebDriver as an instance variable

    public Amazon() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");

        EdgeOptions edgeOptions = new EdgeOptions();
        // Add any desired options here

        // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: Amazon");
        driver.quit();
    }


    public  void testCase1() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        Thread.sleep(3000);
    //         go to google.com  
// search "Amazon" in the search box Using Locator "XPath" //div[contains(@class ,'RNNXgb')] | Amazon
// click on 'google search Using Locator "XPath" //input[@value='Google Search'] .click
// verify that amazon.in was able come up in the search Using Locator "XPath" //input[@value='Google Search'] .click
         WebElement search = driver.findElement(By.xpath("//textarea[contains(@class ,'gLFyf')]"));
         search.sendKeys("Amazon");
         WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Google Search']"));
         searchBtn.click();
         Thread.sleep(3000);

          // Find and print the first search result 
     WebElement firstResult = driver.findElement(By.className("BYM4Nd"));
     String firstResultText = firstResult.getText();
     System.out.println("First search result: " + firstResultText);

     //Check if "amazon.in" or "amazon.com" is present in the first search result
     if (firstResultText.contains("amazon.in") || firstResultText.contains("amazon.com")) {
         System.out.println("The search results contain 'amazon.in' or 'amazon.com'. Test passed!");
     } else {
         System.out.println("The search results do not contain 'amazon.in' or 'amazon.com'. Test failed.");
     }

}
}
