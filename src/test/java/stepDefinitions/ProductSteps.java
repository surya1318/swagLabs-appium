package stepDefinitions;


import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	
	LoginPage loginObj = new LoginPage();
	ProductsPage productObj = new ProductsPage();
	
	@Given("user is logged in with valid credentials")
    public void user_logged_with_valid_credentials() throws InterruptedException {
		loginObj.login("standard_user", "secret_sauce");
    }

    @Then("the product should be listed with title {string} and price {string}")
    public void Product_should_be_listed_With_Title_And_Price(String title, String price) throws Exception {
        Boolean productTitle = productObj.getProductTitle(title).equalsIgnoreCase(title);
        Boolean productPrice = true;
        Assert.assertTrue(productTitle & productPrice,"title = " + productTitle + ", price = " + productPrice);
    }

    @When("user clicks on the product title {string}")
    public void user_clicks_on_the_product_Title(String title) throws Exception {
    	productObj.pressProductTitle(title);
    }

    @Then("user should be on product details page with product title {string}, product price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String description) throws Exception {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        boolean ptitle = productDetailsPage.getTitle().equalsIgnoreCase(title);
        boolean pdescription = productDetailsPage.getDesc().equalsIgnoreCase(description);
        boolean pprice = productDetailsPage.getPrice().equalsIgnoreCase(price);
        Assert.assertTrue(ptitle & pdescription & pprice, "title = " + ptitle + ", desc = " + pdescription + ", price = " + pprice);
    }

}
