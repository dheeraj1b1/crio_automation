package demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Frames {
    public WebDriver driver;

     public Frames() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");

        EdgeOptions edgeOptions = new EdgeOptions();
        // Add any desired options here

        // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public void endTest() {
        System.out.println("End Test5: Nested Frames");
        driver.quit();
    }
    

     public  void testCase5() throws InterruptedException{
         
        // Open the URL
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to the top frame
        driver.switchTo().frame("frame-top");

        // Switch to the left frame
        driver.switchTo().frame("frame-left");

        // Find the element in the left frame and print its text
        WebElement leftFrame = driver.findElement(By.tagName("body"));
        System.out.println("Text in left frame: " + leftFrame.getText());

          // Switch back to the top frame
          driver.switchTo().parentFrame();

          // Switch to the middle frame
          driver.switchTo().frame("frame-middle");

        // Find the element in the left frame and print its text
        WebElement middleFrame = driver.findElement(By.tagName("body"));
        System.out.println("Text in left frame: " + middleFrame.getText());

        // Switch back to the top frame
          driver.switchTo().parentFrame();

          // Switch to the middle frame
          driver.switchTo().frame("frame-right");

        // Find the element in the left frame and print its text
        WebElement rightFrame = driver.findElement(By.tagName("body"));
        System.out.println("Text in left frame: " + rightFrame.getText());

        // Switch back to the top frame
          driver.switchTo().parentFrame();
        
        // Switch back to the top frame
        driver.switchTo().defaultContent();

        // Switch to the bottom frame
        driver.switchTo().frame("frame-bottom");

        // Find the element in the left frame and print its text
        WebElement bottomFrame = driver.findElement(By.tagName("body"));
        System.out.println("Text in left frame: " + bottomFrame.getText());

        //driver.close();


  
        //   // Switch to the left frame
        //   driver.switchTo().frame("frame-left");
  
        //   // Find the element in the left frame and print its text
        //   WebElement leftFrameElement = driver.findElement(By.tagName("body"));
        //   System.out.println("Text in left frame: " + leftFrameElement.getText());
  
        
  
        //   // Switch to the right frame
        //   driver.switchTo().frame("frame-right");
  
        //   // Find the element in the right frame and print its text
        //   WebElement rightFrameElement = driver.findElement(By.tagName("body"));
        //   System.out.println("Text in right frame: " + rightFrameElement.getText());
  
        //   // Switch back to the default content (outside of frames)
        //   driver.switchTo().defaultContent();
  
        //   // Find the element in the bottom frame and print its text
        //   WebElement bottomFrameElement = driver.findElement(By.tagName("body"));
        //   System.out.println("Text in bottom frame: " + bottomFrameElement.getText());
     }
}
