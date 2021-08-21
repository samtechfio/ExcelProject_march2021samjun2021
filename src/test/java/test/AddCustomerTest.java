package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;


@Test
public class AddCustomerTest {
	
	WebDriver driver;
	ExcelReader   exlread = new ExcelReader("src\\main\\java\\data\\LoginInfo.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "password", 2);
	String fullName = exlread.getCellData("AddcustomerInfo", "FullName", 2);
	String companyName = exlread.getCellData("AddcustomerInfo", "CompanyName", 2);
	String email = exlread.getCellData("AddcustomerInfo", "Email", 2);
	String phone = exlread.getCellData("AddcustomerInfo", "Phone", 2);
	String address = exlread.getCellData("AddcustomerInfo", "Address", 2);
	String city = exlread.getCellData("AddcustomerInfo", "City", 2);
	String country = exlread.getCellData("AddcustomerInfo", "Country", 2);
	String state= exlread.getCellData("AddcustomerInfo", "State", 2);
	String zip = exlread.getCellData("AddcustomerInfo", "Zip", 2);
	
	
	
	public void validUserShouldBeAbleToCreateCustomer() {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);  //create an object using PageFactory keyword
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.ClicksigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAdress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZipcode(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddContact();
		
		addCustomerPage.verifySummaryPage();
		dashboardPage.clickListCustomersButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		addCustomerPage.clickYesToDeleteButton();
		


		
		
		
			
		
		
		
	}
	
}
	


