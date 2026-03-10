package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SubCategoryPage;
import util.Base;

import java.util.List;
import java.util.Map;

public class AmazonSteps {

    // Initialize Pages using instantiated driver
    HomePage homePage;
    CategoryPage categoryPage;
    SubCategoryPage subCategoryPage;
    ProductPage productPage;

    @Given("User launches browser and navigates to Amazon")
    public void user_launches_browser_and_navigates_to_amazon() {
        homePage = new HomePage(Base.driver);
        categoryPage = new CategoryPage(Base.driver);
        subCategoryPage = new SubCategoryPage(Base.driver);
        productPage = new ProductPage(Base.driver);
        
        homePage.navigateToAmazon();
    }

    @When("User navigates to category {string} and subcategory {string}")
    public void user_navigates_to_category_and_subcategory(String category, String subCategory) {
        System.out.println("Navigating to Category: " + category + " -> " + subCategory);
        
        homePage.clickHamburgerMenu();
        categoryPage.selectCategory(category);
        subCategoryPage.selectSubCategory(subCategory);
    }

    @Then("Extract Name and Price for products in subcategory {string}")
    public void extract_name_and_price_for_products_in_subcategory(String subCategory) {
        List<Map<String, String>> products = productPage.getProductListNamesAndPrices();
        System.out.println("Products found for " + subCategory + ": " + products.size());
        for (Map<String, String> prod : products) {
            System.out.println("Name: " + prod.get("Name") + ", Price: " + prod.get("Price"));
            Assert.assertNotNull(prod.get("Name"), "Product Name should not be null");
        }
    }

    @When("User searches for category {string} and captures details")
    public void user_searches_for_category_and_captures_details(String keyword) {
        homePage.searchForProduct(keyword);
    }

    @Then("Validate and capture Product Name and Price")
    public void validate_and_capture_product_name_and_price() {
        List<Map<String, String>> products = productPage.getProductListNamesAndPrices();
        for (Map<String, String> prod : products) {
            System.out.println("Target Name: " + prod.get("Name") + ", Target Price: " + prod.get("Price"));
            Assert.assertNotNull(prod.get("Name"), "Product Name should not be null");
        }
        
        if (!products.isEmpty()) {
            productPage.clickProductByIndex(0);
            productPage.switchToNewTabAndCaptureDetails();
        }
    }

    @When("User applies filter {string} on results")
    public void user_applies_filter_on_results(String filter) {
        productPage.applyFilter(filter);
    }

    @Then("Validate filtered Product Name and Price")
    public void validate_filtered_product_name_and_price() {
        List<Map<String, String>> products = productPage.getProductListNamesAndPrices();
        System.out.println("Filtered Products Count: " + products.size());
        for (Map<String, String> prod : products) {
            System.out.println("Filtered Name: " + prod.get("Name") + ", Filtered Price: " + prod.get("Price"));
            Assert.assertNotNull(prod.get("Name"), "Filtered Product Name should not be null");
        }
    }
}
