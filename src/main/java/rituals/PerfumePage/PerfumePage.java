package rituals.PerfumePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class PerfumePage {

    private WebDriver driver;
    private By filterBox = By.xpath("//*[@id=\"search-result-items\"]/li[1]/div[1]");

    public PerfumePage(WebDriver driver) {
        this.driver = driver;

    }

    public void selectFromBox(String option) {
        findFilterBoxElement().selectByVisibleText(option);
    }

    private Select findFilterBoxElement() {
        return new Select(driver.findElement(filterBox));
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findFilterBoxElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}
