package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class ImdbRating {
    WebDriver driver;
    WebDriverWait wait;

    public ImdbRating(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Documents\\Projects\\edgedriver_win64\\msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
       // Initialize the Microsoft Edge WebDriver with the specified options
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }


    public void endTest() {
        System.out.println("End Test7: IMDB Rating");
        driver.quit();
    }

    public void testCase7() throws InterruptedException {
        System.out.println("Start Test case: testCase7");

        //visit the site 
        driver.get("https://www.imdb.com/chart/top/");

        //intiliaze the wait
        wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed

         // Wait for the Imdb is present 
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text() = 'IMDb Charts']")));

        // print the high rated movie 
        List<WebElement> movies = driver.findElements(By.xpath("//h3[@class='ipc-title__text']"));

        // Check if the third element exists (index based)
        if (movies.size() > 2) {
            WebElement thirdElement = movies.get(1); // Index 2 for the third element
            String text = thirdElement.getText();
            System.out.println("The Movie name is " + text);
        } else {
            System.out.println("could not find the movie");
        }


        // print highest user rating of it 
        WebElement rating = driver.findElement(By.xpath("//span[@aria-label='IMDb rating: 9.3']"));
        // // Check if the element exists
        // if (element != null) {
            String ariaLabel = rating.getAttribute("aria-label");
            String imdbRating = ariaLabel.split(":")[1].trim();
            System.out.println("Highest user IMDb Rating: " + imdbRating);
        // } else {
        //     System.out.println("Element not found.");
        // }

        //print the total elements 
        WebElement totalTitles = driver.findElement(By.xpath("//span[@class = 'sc-f98e5d7f-0 gtxTpS']"));
        String totalTitlesTxt = totalTitles.getText();
        System.out.println("Total tiles = " + totalTitlesTxt);


        //click on sort btn
        WebElement sort = driver.findElement(By.xpath("//select[@id = 'sort-by-selector']"));
        sort.click();
        Thread.sleep(500);
         // Create a Select object
         Select select = new Select(sort);
        // Select the option by its value
         select.selectByValue("RELEASE_DATE");
         Thread.sleep(500);

         //print the year of the latest movie
        List<WebElement> years = driver.findElements(By.xpath("//span[starts-with(@class ,'sc-b51a3d33')]"));
        WebElement year = years.get(0); // First element
            String yearTxt = year.getText();
            System.out.println("latest movie year: " + yearTxt);

            Thread.sleep(500);
            //click on swap btn
            WebElement swapBtn = driver.findElement(By.id("swap-sort-order-button"));
            swapBtn.click();
            Thread.sleep(500);

             //print the year of the oldest movie
        List<WebElement> years1 = driver.findElements(By.xpath("//span[starts-with(@class ,'sc-b51a3d33')]"));
        WebElement year1 = years1.get(0); // First element
            String yearTxt1 = year1.getText();
            System.out.println("latest movie year: " + yearTxt1);


        }
    
}
