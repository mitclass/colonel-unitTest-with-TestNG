package IntegrationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FunctionalityTest {

    WebDriver driver;
    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://boisterous-squirrel-08cbc5.netlify.app/#/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("Opens browser!");
    }
    @Test
    void testRegister() throws InterruptedException {
        driver.findElement(By.id("firstName")).sendKeys("Richard");
        driver.findElement(By.name("lastName")).sendKeys("Blake");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("thedreamsglobal@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("admin123");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/button")).click();

        Assert.assertEquals("Register button not clickable", "button should be clickable");
        System.out.println("User can't register as the click button is not functioning well!");
    }
    @Test
    void printTitle(){
        String actual_title = driver.getTitle();
        System.out.println("The title of the application is: "+ actual_title);

        Assert.assertEquals(actual_title, "Colonel Kernel's Farmers Market");
    }

    @AfterTest
    void tearDown(){

        driver.close();
        driver.quit();


        System.out.println("The feature is not stable as click/ register button is not clickable yet!");
    }
}
