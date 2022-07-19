package UnitTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTitle {

    WebDriver driver;
    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://boisterous-squirrel-08cbc5.netlify.app/#/register");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("Opens browser!");
    }

    @Test(groups = {"unit"})
    void homaPageTitle(){
        String actual_title = driver.getTitle();
        //System.out.println("The title of the application is: "+ actual_title);
        Assert.assertEquals(actual_title, "Colonel Kernel's Farmers Market", "Title not matched");
    }

    @AfterTest
    void tearDown(){

        driver.close();
        driver.quit();


        System.out.println("End2End test completed Successfully!");
    }
}
