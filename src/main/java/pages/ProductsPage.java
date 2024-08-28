package pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.GlobalParams;
import utilities.TestUtils;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage{
	
	TestUtils logger = new TestUtils();		
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
	public WebElement ProductsLabel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
	public WebElement productTitle;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[1]")
	public WebElement addBackPackProductToCart;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
	public WebElement CartIcon;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
	public WebElement CheckOutButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
	public WebElement FirstName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
	public WebElement LastName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
	public WebElement ZipCode;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
	public WebElement ContinueButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
	public WebElement Finish;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
	public WebElement SuccessMessage;
			
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='PRODUCTS']")
	private WebElement titleTxt;


		public String getTitle() {
			return getText(titleTxt, "product page title is - ");
		}

		public String getProductTitle(String title) throws Exception {
			switch(new GlobalParams().getPlatformName()){
				case "Android":
					return getText(andScrollToElementUsingUiScrollable("text", title), "product title is: " + title);
				default:
					throw new Exception("Invalid platform name");
			}
		}

		public By defProductPrice(String title) throws Exception {
			switch(new GlobalParams().getPlatformName()){
				case "Android":
					return By.xpath("//*[@text='" + title + "']/following-sibling::*[@content-desc='test-Price']");
				default:
					throw new Exception("Invalid platform name");
			}
		}
		
		public ProductDetailsPage pressProductTitle(String title) throws Exception {
			switch(new GlobalParams().getPlatformName()){
				case "Android":
					click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
					return new ProductDetailsPage();
				default:
					throw new Exception("Invalid platform name");
			}
		}
	}


