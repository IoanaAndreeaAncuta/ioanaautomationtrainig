package testsIDE;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginSuiteTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void forgotpasswordusingavalidEmail() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("ancuta.ioana@ymail.com");
        driver.findElement(By.cssSelector(".button-medium:nth-child(1) > span")).click();
        driver.findElement(By.cssSelector(".alert")).click();
    }
    @Test
    public void forgotpasswordusinganinvalidEmail() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("abcd.def@yahoo.com");
        driver.findElement(By.cssSelector(".button-medium:nth-child(1) > span")).click();
        driver.findElement(By.cssSelector("ol > li")).click();
        driver.findElement(By.cssSelector(".alert > p")).click();
        driver.findElement(By.cssSelector("li > .btn > span")).click();
    }
    @Test
    public void successfullyLogin() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("ancuta.ioana@ymail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("Ioana23");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }
    @Test
    public void incorrectEmailAddress() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("abcd.def@yahoo.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("Ioana23");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector(".alert > p")).click();
    }
}
