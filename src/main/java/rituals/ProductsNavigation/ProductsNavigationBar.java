package rituals.ProductsNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsNavigationBar {
    private WebDriver driver;
    private By productsNavigationBar = By.xpath("//*[@id=\"wrapper\"]/header/div[2]/nav/div/div[2]/ul/li[1]/button");

    public ProductsNavigationBar(WebDriver driver) {
        this.driver = driver;
    }


}
