package end2endTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class End2EndTest {

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
    @Test(priority = 1, groups = { "regression"})
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
    @Test(priority = 3, groups = {"regression"})
    void homaPageTitle(){
        String actual_title = driver.getTitle();
        //System.out.println("The title of the application is: "+ actual_title);
        Assert.assertEquals(actual_title, "Colonel Kernel's Farmers Market", "Title not matched");
    }

    @Test(priority = 2, groups = {"regression"})
    void testLogin(){
        driver.findElement(By.id("email")).sendKeys("thereamsglobal@gmail.com");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/button")).click();

        Assert.assertEquals("User cannot login with even correct credentials", "User can login with correct credentials");
        System.out.println("User can't register as the click button is not functioning well!");
    }

    @Test(priority = 4, groups = {"sanity", "regression"}, enabled = false)
    void testLogout(){

        System.out.println("Successfully logout!");
    }

    @Test(priority = 5, groups = {"sanity", "regression"})
    void logoTest(){
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div[1]/div[1]/img"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on the home page");
        System.out.println("The logo is present!!!");
    }

    @AfterTest
    void tearDown(){

        driver.close();
        driver.quit();


        System.out.println("The feature is not stable as click/ register button is not clickable yet!");
    }
}
