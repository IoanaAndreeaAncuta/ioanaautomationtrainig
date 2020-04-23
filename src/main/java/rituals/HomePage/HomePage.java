package rituals.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HoversPage;
import rituals.PerfumePage.PerfumePage;
import rituals.ProductsNavigation.ProductsNavigationBar;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String xPath) {
        driver.findElement(new By.ByXPath(xPath)).click();
    }


    public PerfumePage clickPerfume() {
        clickLink("//*[@id=\"wrapper\"]/header/div[2]/nav/div/div[2]/ul/li[1]/div/div/div/ul/li[8]/a");
        return new PerfumePage(driver);
    }

    public ProductsNavigationBar clickProductsButton(){
        clickLink("//*[@id=\"wrapper\"]/header/div[2]/nav/div/div[2]/ul/li[1]/button");
        return new ProductsNavigationBar(driver);
    }




}
