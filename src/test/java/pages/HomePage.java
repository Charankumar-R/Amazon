package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Base;

public class HomePage {
    private WebDriver driver;

    // Locators
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement submitSearchBox;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement allMenuHamburger;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void navigateToAmazon() {
        driver.get("https://www.amazon.in");
    }

    public void searchForProduct(String productKeyword) {
        Base.wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(productKeyword);
        submitSearchBox.click();
    }

    public void clickHamburgerMenu() {
        Base.wait.until(ExpectedConditions.elementToBeClickable(allMenuHamburger)).click();
    }
}
