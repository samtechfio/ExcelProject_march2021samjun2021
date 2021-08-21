package page;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='account']") WebElement FULL_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")	   WebElement COMPANY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")   WebElement EMAIL_FIELD;
    @FindBy(how = How.XPATH, using = "//input[@id='phone']")   WebElement	PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")    WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")   WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")	   WebElement ZIP_CODE_FIELD;
	@FindBy(how = How.XPATH, using =  "//select[@id='country']") WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='tags']") 	 WebElement TAGS_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")   WebElement SAVE_BUTTON_ON_ADD_CONTACT;
	@FindBy(how = How.XPATH, using = "//select[@id='currency']") WebElement CURRENCY_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='group']")    WebElement GROUP_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")  WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='cpassword']") WebElement CONFIRM_PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]") WebElement YES_BUTTON_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_BUTTON_ON_SUMMARY_PAGE;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']") WebElement YES_BUTTON_TO_DELETE;
	
	String enteredName;
	public void enterFullName(String fullName) {
		 enteredName = fullName + generateNumber(999);
		FULL_NAME_FIELD.sendKeys(enteredName);
	}
	public void enterCompany(String company) {

		selectDropdown(COMPANY_FIELD, company);
	}	
	public void enterEmail(String email) {

		EMAIL_FIELD.sendKeys(generateNumber(999) + email);
	}
	public void enterPhone(String phone) {
		
		PHONE_FIELD.sendKeys(phone + generateNumber(999));
    }
	public void enterAdress(String add) {
		ADDRESS_FIELD.sendKeys(add);
	}
	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}
	public void enterState(String states) {
		STATE_FIELD.sendKeys(states);
	}
	public void enterZipcode(String zcode) {
		ZIP_CODE_FIELD.sendKeys(zcode);
	}
	public void enterCountry(String county) {
		COUNTRY_FIELD.sendKeys(county);
		
	}
	public void enterTagsName(String tag) {
		TAGS_FIELD.sendKeys(tag);
	}
	public void clickSaveButtonOnAddContact() {
		SAVE_BUTTON_ON_ADD_CONTACT.click();
	}
	public void enterCurrency(String currensy) {
		selectDropdown(CURRENCY_FIELD,currensy);
	}
	public void enterGroup(String group) {
		selectDropdown(GROUP_FIELD,group);
	}
	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}
	public void enterConfirmpassword(String passw) {
		CONFIRM_PASSWORD_FIELD.sendKeys(passw);
	}
	public void clickYesbutton() {
		YES_BUTTON_FIELD.click();
	}
	public void verifySummaryPage() {
	
		waitForElement(driver, 5, SUMMARY_BUTTON_ON_SUMMARY_PAGE);
		Assert.assertEquals(SUMMARY_BUTTON_ON_SUMMARY_PAGE.getText(), "Summary", "Wrong Page!!!");
	}
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	
	public void verifyEnteredNameAndDelete() {
		
		String before_xpath = "	//tbody/tr[";
		String after_xpath = "]/td[3]";
	
		for(int i=1; i<=10;i++) {
		String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
	/*	System.out.println(name);
		Assert.assertEquals(name, enteredName, "Enter name doesn't exist");		
		break;*/
		
		if(name.contains(enteredName)) {
			System.out.println("Entered name exist.");
			driver.findElement(By.xpath(before_xpath + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
}
		
}
	
}
	public void clickYesToDeleteButton() {
		YES_BUTTON_TO_DELETE.click();
		
	}
			
		
}


