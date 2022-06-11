package OMSPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OMSLoginPage {

	WebDriver driver;

	private static final Logger log = LogManager.getLogger(OMSLoginPage.class);

	@FindBy(xpath = "//*[@id=\"emailaddress\"]")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement password;

	@FindBy(xpath = "//*[text()=' Log In ']")
	WebElement login;

	public OMSLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		login.click();
	}

	public OMSFindOrdersPage login(String username, String password) {
		log.info("Logging with username - " + username + "  and password - " + password);
		setUsername(username);
		setPassword(password);
		clickLoginButton();
		return new OMSFindOrdersPage(driver);
	}

}
