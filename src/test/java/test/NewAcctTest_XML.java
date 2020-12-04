package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import junit.framework.Assert;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import page.DashboardPage;
import page.LoginPage;
import page.OrdersPage;
import util.BrowserFactory;


public class NewAcctTest_XML {
	WebDriver driver;

	@Test
	public static void login() {
		try {
			File readXML = new File(".\\Data\\test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(readXML);
		    
		    doc.getDocumentElement().normalize();
		    
		    NodeList nList = doc.getElementsByTagName("test");
		    
		    for (int temp = 0; temp < nList.getLength(); temp++) {

		        Node nNode = nList.item(temp);
		                
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) nNode;
		            String LoginEmail = eElement.getElementsByTagName("login").item(0)
		                    .getTextContent();
		            String Passcode = eElement.getElementsByTagName("password").item(0)
		                    .getTextContent();
		            String Price = eElement.getElementsByTagName("price").item(0)
		                    .getTextContent();
		            Placing_Order(LoginEmail,Passcode,Price);
		
		        }
		    }
		            
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Placing_Order(String LoginEmail, String Passcode, String $) {

		WebDriver driver = BrowserFactory.InitBrowser();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.LoginTest(LoginEmail,Passcode);	
		Assert.assertEquals("Dashboard Page Not Found", "Dashboard- iBilling", driver.getTitle());
		System.out.println(driver.getTitle());
		
		DashboardPage dashboardpg = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpg.OrderTab();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Add New Order')]"))));
		
		dashboardpg.AddOrderTab();
		
		Assert.assertEquals("Orders Page not Found", "Orders- iBilling", driver.getTitle());
		System.out.println(driver.getTitle());
		
		OrdersPage orderpg = PageFactory.initElements(driver, OrdersPage.class);
		orderpg.placeOrder($);
		
		
	}
}
