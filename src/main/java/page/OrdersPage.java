package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {

	WebDriver driver;

	// Constructor
	public OrdersPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library:
	@FindBy(how = How.XPATH, using = "//input[@name='price']")
	WebElement Price;

	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement submitOrder;

	public void placeOrder(String $) {

		Select productDrop = new Select(driver.findElement(By.xpath("//*[@id=\"pid\"]")));
		productDrop.selectByVisibleText("Wheels");

		Select customerInfo = new Select(driver.findElement(By.xpath("//*[@id=\"cid\"]")));
		customerInfo.selectByVisibleText("shaz - shaz.ali@gmail.com");

		Select status = new Select(driver.findElement(By.xpath("//*[@id=\"status\"]")));
		status.selectByVisibleText("Active");

		Price.sendKeys($);

		submitOrder.click();

	}

}
