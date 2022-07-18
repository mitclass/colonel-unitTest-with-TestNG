package UnitTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFunctionalityTest {
    WebDriver driver;

    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://boisterous-squirrel-08cbc5.netlify.app/#/login");
        driver.manage().window().maximize();
        System.out.println("Opens browser!");
    }

    @Test
    void testLogin(){
        driver.findElement(By.id("email")).sendKeys("thereamsglobal@gmail.com");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/button")).click();

        Assert.assertEquals("User cannot login with even correct credentials", "User can login with correct credentials");
        System.out.println("User can't register as the click button is not functioning well!");
    }


    @AfterTest
    void tearDown(){

        //driver.close();
        //driver.quit();


        System.out.println("User cannot login");
    }

}

