package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductPage {
    private WebDriver driver;

    @FindBy(css = "div[data-component-type='s-search-result']")
    private List<WebElement> searchResults;

    @FindBy(id = "productTitle")
    private WebElement productTitleDetail;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void applyFilter(String filterName) {
        WebElement filter = Base.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'a-size-base') and text()='" + filterName + "']/preceding-sibling::div//label/i | //span[text()='" + filterName + "']/preceding-sibling::div//input[@type='checkbox']")));
        filter.click();
        
        // Wait for page to refresh by checking staleness of current results or simply sleep
        try { Thread.sleep(2000); } catch(InterruptedException ignored) {}
    }

    public List<Map<String, String>> getProductListNamesAndPrices() {
        Base.wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        List<Map<String, String>> products = new ArrayList<>();

        for (int i = 0; i < Math.min(searchResults.size(), 5); i++) { // Extract top 5 for demo
            WebElement result = searchResults.get(i);
            try {
                String name = result.findElement(By.cssSelector("h2 a span")).getText();
                String price = "Not Found";
                try {
                    price = result.findElement(By.cssSelector("span.a-price-whole")).getText();
                } catch(Exception ignored){}
                
                Map<String, String> prodData = new HashMap<>();
                prodData.put("Name", name);
                prodData.put("Price", price);
                products.add(prodData);
            } catch (Exception e) {
                // Ignore missing sub-elements
            }
        }
        return products;
    }

    public void clickProductByIndex(int index) {
        Base.wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        searchResults.get(index).findElement(By.cssSelector("h2 a")).click();
    }

    // Handles the new tab switching functionality required for Product Details
    public void switchToNewTabAndCaptureDetails() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Base.wait.until(ExpectedConditions.visibilityOf(productTitleDetail));
        String name = productTitleDetail.getText();
        String price = "Not Available";
        try {
            WebElement productPriceDetail = driver.findElement(By.xpath("//span[contains(@class,'priceToPay')]//span[@class='a-price-whole'] | //span[@id='priceblock_ourprice']"));
            price = productPriceDetail.getText();
        } catch (Exception e) {
            // Price might be missing on detail page
        }
        
        System.out.println("Detailed Target Name: " + name);
        System.out.println("Detailed Target Price: " + price);

        // Close new tab and switch back to main list
        driver.close();
        driver.switchTo().window(currentWindow);
    }
}
