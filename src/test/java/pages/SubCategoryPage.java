package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Base;

public class SubCategoryPage {
    private WebDriver driver;

    public SubCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSubCategory(String subCategoryName) {
        // e.g., 'Smartphones & Basic Mobiles' or 'Lenses'
        WebElement subCatLink = Base.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class,'hmenu-visible')]//a[text()='" + subCategoryName + "'] | //a[contains(text(),'" + subCategoryName + "')]")));
        subCatLink.click();
    }
}
