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


public class LinkedlnImage {
    
    public WebDriver driver;
    public LinkedlnImage() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");

        EdgeOptions edgeOptions = new EdgeOptions();
        // Add any desired options here

        // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // WebDriverWait wait = new WebDriverWait(driver, 10, null, null, null);
      
    }


    public void endTest() {
        System.out.println("End Test: LinkedlnImage");
        driver.quit();
    }


    public  void testCase6() throws InterruptedException{

        


        System.out.println("Start Test case: testCase");
        // visit the wepage
        driver.get("https://in.linkedin.com/");
        
        Thread.sleep(3000);
        //enter username
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("cofirow849@ipnuc.com");

        //enter password
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("Aeiou@123");

        //click on sign in
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        
          // click on start a post
         driver.findElement(By.xpath("//button[starts-with(@class, 'artdeco-button')]//span[@class = 'display-flex align-items-center']")).click();
        Thread.sleep(500);
         //click on post to anyone btn
         driver.findElement(By.xpath("//button[starts-with(@class, 'share-unified')]")).click();
        Thread.sleep(500);
         //click on connections only button
         driver.findElement(By.xpath("//button[@id = 'CONNECTIONS_ONLY']")).click();
        Thread.sleep(500);
         //click on done btn
         driver.findElement(By.xpath("//button[starts-with(@class, 'share-box-footer')]")).click();
        Thread.sleep(500);
         //start writing on the space
         driver.findElement(By.xpath("//div[starts-with(@class,'ql-editor')]")).sendKeys("a post new");
        Thread.sleep(2000);
        //  //CLICK on post btn 
        //  WebElement postBtn= driver.findElement(By.xpath("//button[starts-with(@class , 'share-actions__primary-action')]"));
        //     postBtn.click();

          //click on Image btn
            driver.findElement(By.xpath("//button[@aria-label='Add media']//span[starts-with(@class, 'share-promoted')]")).click();  
        Thread.sleep(3000);
        
        WebElement uploadImage = driver.findElement(By.xpath("//input[@type = 'file']"));
        uploadImage.sendKeys("C:\\Users\\Admin\\Pictures\\0.png");

        //click on next btn
        driver.findElement(By.xpath("//span[text() = 'Next']")).click();

        //click on post btn 
        driver.findElement(By.xpath("//span[text() = 'Post']")).click();
        Thread.sleep(2000);



      
        // // Find the element using the provided XPath expression
        // WebElement onlyConnection = driver.findElement(By.xpath("//li-icon[@type='people' and @size='small']"));

        // // Check if the  only connectiones element is present
        // if (onlyConnection != null) {
        //     System.out.println("the post was shared with with connections only. Test Passed!");
        // } else {
        //     System.out.println("the post was not shared with with connections only. Test not Passed!!!!");
        // }

        
    }

    
}
