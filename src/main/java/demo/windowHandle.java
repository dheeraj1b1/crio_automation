package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.Set;

    
  public class windowHandle {
    WebDriver driver;
    WebDriverWait wait;


    public windowHandle(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
       // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }

    public void endTest() {
        System.out.println("End Test8: Window handle");
        driver.quit();
    }

    public void testCase8() throws InterruptedException {
        System.out.println("Start Test case: testCase8");


         // go to the site
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        // Switch to the iframe containing the "Try it" button
        driver.switchTo().frame("iframeResult");

        // Find and click the "Try it" button
        WebElement tryItBtn = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryItBtn.click();

        // Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through the handles to find the new window
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);

            // Check if the current window is the new window
            if (!driver.getCurrentUrl().equals("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open")) {
                // Get the URL and Title of the new window
                String newWindowUrl = driver.getCurrentUrl();
                String newWindowTitle = driver.getTitle();

                //   // Take a screenshot
                // TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
                // File source = screenshotDriver.getScreenshotAs(OutputType.FILE);
                // File destination = new File("screenshot.png");

                // try {
                //     Files.copy(source.toPath(), destination.toPath());
                //     System.out.println("Screenshot saved as 'screenshot.png'");
                // } catch (IOException e) {
                //     e.printStackTrace();
                // }

                // Close the new window
                driver.close();

                // Switch back to the original window
                driver.switchTo().window(windowHandles.iterator().next());

                // Print the URL and Title of the new window
                System.out.println("New Window URL: " + newWindowUrl);
                System.out.println("New Window Title: " + newWindowTitle);
                break;
            }
        }

    }

}
