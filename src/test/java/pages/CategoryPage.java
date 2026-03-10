package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Base;

public class CategoryPage {
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Dynamic selection of categories from side menu like 'Mobiles, Computers' or 'TV, Appliances, Electronics'
    public void selectCategory(String categoryName) {
        WebElement categoryLink = Base.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='hmenu-content']//a[contains(text(),'" + categoryName + "')] | //a[@data-menu-id and contains(text(), '" + categoryName + "')]")));
        categoryLink.click();
    }
}
