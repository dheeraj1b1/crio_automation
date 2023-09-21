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


public class BookMyShow {
    public WebDriver driver;
    public WebDriverWait wait;

    public BookMyShow(){

        //set the drive
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
       // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
      }


      public void endTest() {
        System.out.println("End Test4: BookMyShowLinks");
        driver.quit();
    }


    public void testCase2() throws InterruptedException {
        System.out.println("Start Test case: testCase4");

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //wait until recomended movies are visible 
        //WebElement recommendedImageTxt = 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text() = 'Recommended Movies']")));
        // click on see all
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[substring(@href, string-length(@href) - string-length('/movies-chennai') + 1) = '/movies-chennai']//div[text() = 'See All ›']")).click();

        // Find all image elements matching the all movies 
        java.util.List<WebElement> imageElements = driver.findElements(By.xpath("//div[@class='sc-1ljcxl3-0 iGFUdZ']//img"));

        // Print the image URLs
        for (WebElement element : imageElements) {
            String imageUrl = element.getAttribute("src");
            System.out.println("Image URL: " + imageUrl);
        }

        //navigate to main page
        driver.navigate().back();

        //click on see all for premiere movies
        driver.findElement(By.xpath("//a[substring(@href, string-length(@href) - string-length('of-the-week') + 1) = 'of-the-week']//div[text() = 'See All ›']")).click();


         // Find all the premiere elements using XPath
         java.util.List<WebElement> premiereElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='sc-1ljcxl3-0 iGFUdZ']")));
            
         // Traverse and find the 2nd element
         if (premiereElements.size() >= 2) {
             WebElement secondPremiere = premiereElements.get(1);
             
             // Find the movie name and language within the 2nd element
             WebElement movieNameElement = secondPremiere.findElement(By.xpath(".//h3"));
             WebElement movieLanguageElement = secondPremiere.findElement(By.xpath("//div[@class='sc-7o7nez-0 veMGd']"));
             
             String movieName = movieNameElement.getText();
             String movieLanguage = movieLanguageElement.getText();
             
             System.out.println("Second Premiere Movie Name: " + movieName);
             System.out.println("Second Premiere Movie Language: " + movieLanguage);
         } else {
             System.out.println("There are not enough premiere elements to find the second one.");
         }
        

    }
    
}
