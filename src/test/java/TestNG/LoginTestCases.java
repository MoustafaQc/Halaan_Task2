package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestCases {
    public static WebDriver driver;

    @BeforeMethod
    public void openBroeser(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.testyou.in/Login.aspx");
    }

    @Test
    public void inValidLogin(){
        driver.findElement(By.cssSelector("input[id=\"ctl00_CPHContainer_txtUserLogin\"]")).sendKeys("correct email");
        driver.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys("wrong pass");
        driver.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();
        WebElement text = driver.findElement((By.id("ctl00_CPHContainer_lblOutput")));
        // Assert.assertEquals(text.getText(),"User Id or Password did Not Match!!");
        Assert.assertEquals(text.getText(),"Userid or Password did Not Match !!");
    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
