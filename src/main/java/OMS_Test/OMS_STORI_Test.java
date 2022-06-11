package OMS_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OMS_Basetest.OMS_Testbase;
import OMS_Pages.OMS_CreateordersPage;
import OMS_Pages.OMS_Findorderpage;
import OMS_Pages.OMS_Loginpage;

public class OMS_STORI_Test extends OMS_Testbase {
	OMS_Loginpage loginPage;
	OMS_Findorderpage homepage;
	OMS_CreateordersPage createorder;
	WebDriverWait wait;

	private static final Logger log = LogManager.getLogger(OMS_STORI_Test.class);

	@Test(priority = 1)
	public void loginTest() {

		loginPage = new OMS_Loginpage(driver);
		log.info("Verifying successful login.");
		loginPage.show_password();
	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() {
		return new Object[][] {

				{ "vt@testvox.com", "  ", "Please fill out the field" },
				{ " ", "vt@testvox.com", "Please fill out the field" }, { "  ", "  ", "Please fill out the field" },
				{ "vt@testvox.com", "abc", "*Incorrect Credentials! Try again" },
				{ "abc", "vt@testvox.com", "*Incorrect Credentials! Try again" },
				{ "abc", "def", "*Incorrect Credentials! Try again" }, { "vt@testvox.com", "vt@testvox.com", " " }, };
	};

	@Test(dataProvider = "loginCredentials")
	public void loginfunction(String UserName, String Password, String Errormessage) {
		wait = new WebDriverWait(driver, 20);

		WebElement username = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"emailaddress\"]")));
		username.sendKeys(Keys.CONTROL + "t");
		username.clear();
		username.sendKeys(UserName);

		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		password.sendKeys(Keys.CONTROL + "t");
		password.clear();
		password.sendKeys(Password);

		WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/div/app-sign-in/div/div/div/div/div/div[2]/form/div[4]/button")));
		loginButton.sendKeys(Keys.CONTROL + "t");
		loginButton.sendKeys(Keys.ENTER);
	}

	@Test(priority = 2)
	public void LogoutTest() {
		homepage = new OMS_Findorderpage(driver);
        homepage.manageordermenu();
	}

	@Test(priority = 3)
	public void Createorder_Test() {
		createorder = new OMS_CreateordersPage(driver);
		homepage = new OMS_Findorderpage(driver);
		createorder.customer_details();
		createorder.order_shipping_details();
		createorder.line_items();
		createorder.payment_details();
		createorder.order_summery();
		createorder.order_status();
		createorder.search_order();
		homepage.manageordermenu();
		createorder.existing_customer();
		homepage.logout();
	}

}
