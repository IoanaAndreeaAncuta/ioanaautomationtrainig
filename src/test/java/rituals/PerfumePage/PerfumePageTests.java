package rituals.PerfumePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import rituals.baseTests.BaseTests;


public class PerfumePageTests extends BaseTests {
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void TestPerfumePageIsOpen() {
        clickProductsButton();
        var perfumePage = homePage.clickPerfume();
        String option = "Women";
        perfumePage.selectFromBox(option);
        var selectedOption = perfumePage.getSelectedOptions();
        softAssert.assertTrue(selectedOption.contains(option), "Men");
    }
}
