package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.concurrent.TimeUnit;

public class BookMyShowLinks {
    public WebDriver driver;
    public BookMyShowLinks() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");

        EdgeOptions edgeOptions = new EdgeOptions();
        // Add any desired options here

        // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public void endTest() {
        System.out.println("End Test2: BookMyShowLinks");
        driver.quit();
    }
    

    public  void testCase2() throws InterruptedException{
        System.out.println("Start Test case: testCase2");
        //visist the webpage
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(1500);
         // Find all the hyperlinks on the webpage
         java.util.List<WebElement> allLinks = driver.findElements(By.xpath("//*[@href]"));
            
         // Count and print the number of hyperlinks
         int linkCount = allLinks.size();
         System.out.println("Total number of hyperlinks on the webpage: " + linkCount);
         
    }
}
