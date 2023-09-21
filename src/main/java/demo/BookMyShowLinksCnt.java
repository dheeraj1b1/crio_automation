package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class BookMyShowLinksCnt {
    public WebDriver driver;
    public WebDriverWait wait;
    
    public BookMyShowLinksCnt() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");

        EdgeOptions edgeOptions = new EdgeOptions();
        // Add any desired options here

        // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 }

    public void endTest() {
        System.out.println("End Test2: BookMyShowLinks");
        driver.quit();
    }

    public void testCase2() {
        System.out.println("Start Test case: testCase2");
        // Visit the webpage
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        
        // Use WebDriverWait to wait for the presence of hyperlinks
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@href]")));
        
        // Find all the hyperlinks on the webpage
        java.util.List<WebElement> allLinks = driver.findElements(By.xpath("//*[@href]"));
            
        // Count and print the number of hyperlinks
        int linkCount = allLinks.size();
        System.out.println("Total number of hyperlinks on the webpage: " + linkCount);
    }
}
