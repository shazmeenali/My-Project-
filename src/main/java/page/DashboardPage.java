package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

WebDriver driver;
	
	//Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library:
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Orders')]")
	WebElement OrdersTab;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Add New Order')]")
	WebElement AddOrders;
	
	
	public void OrderTab() {
		OrdersTab.click();
	}
	
	public void AddOrderTab() {
		AddOrders.click();
	}
	
	
	
	
	
	
	
	
	
}
