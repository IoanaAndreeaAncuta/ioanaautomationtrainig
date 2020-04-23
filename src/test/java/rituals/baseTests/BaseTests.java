package rituals.baseTests;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import rituals.HomePage.HomePage;
import rituals.ProductsNavigation.ProductsNavigationBar;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\ioanaautomationtrainig\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.rituals.com/eng-ro/home");
        closeCookiesPrompt();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    public void closeCookiesPrompt() {
        clickLink("//*[@id=\"ui-id-1\"]/div[2]/button");

    }

    private void clickLink(String xPath) {
        driver.findElement(new By.ByXPath(xPath)).click();
    }

    public ProductsNavigationBar clickProductsButton() {
        clickLink("//*[@id=\"wrapper\"]/header/div[2]/nav/div/div[2]/ul/li[1]/button");
        return new ProductsNavigationBar(driver);
    }


}
