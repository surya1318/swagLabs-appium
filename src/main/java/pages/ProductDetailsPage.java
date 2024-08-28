package pages;

import utilities.GlobalParams;
import utilities.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage{
	TestUtils logger = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]") 
	private WebElement title;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[2]") 
	private WebElement desc;

	@AndroidFindBy (accessibility = "test-BACK TO PRODUCTS") 
	private WebElement backToProductsBtn;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[1]")
	private WebElement addToCartBtn;

public String getTitle() {
	return getText(title, "title is: ");
}

public String getDesc() {
	return getText(desc, "description is: ");
}

public String getPrice() throws Exception {
	switch(new GlobalParams().getPlatformName()){
		case "Android":
			return getText(andScrollToElementUsingUiScrollable("description", "test-Price"), "price is: ");
		default:
			throw new Exception("Invalid platform name");
	}
}

public Boolean isAddToCartBtnDisplayed() {
	return addToCartBtn.isDisplayed();
}

public ProductsPage pressBackToProductsBtn() {
	click(backToProductsBtn, "navigate back to products page");
	return new ProductsPage();
}

}
