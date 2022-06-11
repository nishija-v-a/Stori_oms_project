package OMS_Pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OMS_Loginpage {
	WebDriver driver;

	private static final Logger log = LogManager.getLogger(OMS_Loginpage.class);

	@FindBy(xpath = "//*[@id=\"emailaddress\"]")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement password;

	@FindBy(xpath = "/html/body/app-root/div/app-sign-in/div/div/div/div/div/div[2]/form/div[4]/button")
	WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"password-field-icon\"]/i")
	WebElement eye;
	
	

	public OMS_Loginpage(WebDriver driver) {
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
		loginButton.click();
	}

	public OMS_Findorderpage login(String username, String password) {
		log.info("Logging with username - " + username + "  and password - " + password);
		setUsername(username);
		setPassword(password);
		clickLoginButton();
		return new OMS_Findorderpage(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void show_password() {
		System.out.println("****************************************************************************");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(true, eye.isDisplayed());
		System.out.println("Show password eye icon displayed");
		log.info("Show password eye icon validated successfully");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement eye_display = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password-field-icon\"]/i"))));
		eye_display.click();
		System.out.println("Password show from hidden mode when click on eye icon");

		WebElement eye1_display = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password-field-icon\"]/i"))));
		eye1_display.click();
		System.out.println("Password hide from visible mode when again click on eye icon");
		System.out.println("************Show password feature verification passed");
		System.out.println("*****************************************************************************");

	}
}
