// package demo;

// import java.util.concurrent.TimeUnit;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.edge.EdgeOptions;

// import java.util.concurrent.TimeUnit;
// import io.github.bonigarcia.wdm.WebDriverManager;
// //Selenium Imports
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.Select;
// ///


// public class TestCases {
//     WebDriver driver;
//     public TestCases()
//     {
//         System.out.println("Constructor: TestCases");
//         WebDriverManager.chromedriver().timeout(30).setup();
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//     }

//     public void endTest()
//     {
//         System.out.println("End Test: TestCases");
//         driver.close();
//         driver.quit();

//     }

    
//     public  void testCase01(){
//         System.out.println("Start Test case: testCase01");
//         driver.get("https://www.google.com");
//         System.out.println("end Test case: testCase02");
//     }


// }
