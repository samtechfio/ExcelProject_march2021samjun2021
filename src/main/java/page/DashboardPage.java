package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	
	
	WebDriver driver;
	
public DashboardPage(WebDriver driver) {
	this.driver = driver;
	
}
	//Element library
	
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]") WebElement DASHBOARD_HEADR_FIELD;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]") WebElement CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]") WebElement ADD_CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_FIELD;
	
	
public void verifyDashboardPage() {
		
	Assert.assertEquals(DASHBOARD_HEADR_FIELD.getText(), "Dashboard", "Wrong Page!");
	}
public void clickCustomersButton() {
	
	CUSTOMER_FIELD.click();
}
public void clickAddCustomersButton() {
	
	ADD_CUSTOMER_FIELD.click();
}
public void clickListCustomersButton() {
	LIST_CUSTOMER_FIELD.click();
	
}

}
