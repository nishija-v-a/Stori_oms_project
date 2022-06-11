package OMS_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import OMS_Test.OMS_STORI_Test;

public class OMS_Findorderpage {
	WebDriver driver;
	WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(OMS_STORI_Test.class);
	
	@FindBy(xpath = "//*[@id=\"button-basic\"]")
	WebElement Adminportal;

	@FindBy(xpath = "//*[@id=\"dropdown-basic\"]/li/a")
	WebElement logoutbbutton;
	
	@FindBy(xpath = "//*[@id=\"topnav-menu-content\"]/ul/li[1]/a")
	WebElement manageorder;
	
	@FindBy(xpath = "//*[@id=\"topnav-menu-content\"]/ul/li[1]/div/div[2]/a")
	WebElement createorder;
	
   public OMS_Findorderpage(WebDriver driver) 
   {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		Adminportal.click();
		logoutbbutton.click();
		System.out.println("*********user logged out successfully from OMS and restored back to login page when clicks on logout button ");
		log.info("user logged out successfully from OMS and restored back to login page when clicks on logout button");
	}
	
	public void manageordermenu()
	{
		manageorder.click();
		createorder.click();
	}
}
