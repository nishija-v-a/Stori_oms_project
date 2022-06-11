package OMSPages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OMSSalesOrdersPage {

	WebDriver driver;
	private static final Logger log = LogManager.getLogger(OMSSalesOrdersPage.class);

	@FindBy(xpath = "//*[@formcontrolname=\"orderId\"]")
	WebElement orderTextbox;

	@FindBy(xpath = "(//*[@type=\"date\"])[1]")
	WebElement ordersReceivedDateStartCalendarList;

	@FindBy(xpath = "//*[@id=\"todate\"]")
	WebElement ordersReceivedDateEndCalendarList;

	@FindBy(xpath = "//*[@id=\"filterView\"]/div/div/div/form/div[1]/div[4]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement orderStatusDropdown;
	@FindBy(xpath = "//div[contains(text(),'Created')]")
	WebElement created;
	@FindBy(xpath = "//div[contains(text(),'Create Processed')]")
	WebElement createProcessed;
	@FindBy(xpath = "//div[contains(text(),'Create Failed')]")
	WebElement createFailed;
	@FindBy(xpath = "//div[contains(text(),'Updated')]")
	WebElement updated;
	@FindBy(xpath = "//div[contains(text(),'Update Processed')]")
	WebElement updateProcessed;
	@FindBy(xpath = "//div[contains(text(),'Update Failed')]")
	WebElement updateFailed;
	@FindBy(xpath = "//div[contains(text(),'Cancelled')]")
	WebElement cancelled;
	@FindBy(xpath = "//div[contains(text(),'Cancel Processed')]")
	WebElement cancelProcessed;
	@FindBy(xpath = "//div[contains(text(),'Cancel Failed')]")
	WebElement cancelFailed;

	@FindBy(xpath = "//*[@id=\"filterView\"]/div/div/div/form/div[1]/div[5]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement channels;
	@FindBy(xpath = "//div[contains(text(),'Amazon')]")
	WebElement amazon;
	@FindBy(xpath = "//div[contains(text(),'Shopify')]")
	WebElement shopify;

	@FindBy(xpath = "//*[@id=\"filterView\"]/div/div/div/form/div[2]/button")
	WebElement findOrdersButton;

	@FindBy(xpath = "//*[text()=\"No Orders Found \"]")
	WebElement noOrdersFoundMessage;

	public OMSSalesOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void salesOrdersTabDisplay() {
		log.info("Entering to Sales Orders Tab");
		String expectedPage = "https://staging.oms.bytetale.com/manage-orders/sales-orders";
		String actualPage = driver.getCurrentUrl();
		Assert.assertEquals(expectedPage, actualPage);
		System.out.println("Sales Orders Page is displayed");
		System.out.println("===============================================================");
	}

	public void filterDisplay() {
		Assert.assertEquals(true, orderTextbox.isDisplayed());
		System.out.println("Order Textbox is displayed");

		Assert.assertEquals(true, ordersReceivedDateStartCalendarList.isDisplayed());
		System.out.println("Orders Received Date Start Calendar List is displayed");
		String ordersReceivedDateStart = ordersReceivedDateStartCalendarList.getAttribute("value");
		System.out.println("Order Recieved Start Date:" + ordersReceivedDateStart);

		Assert.assertEquals(true, ordersReceivedDateEndCalendarList.isDisplayed());
		System.out.println("Orders Received Date End Calendar List is displayed");
		String ordersReceivedDateEnd = ordersReceivedDateEndCalendarList.getAttribute("value");
		System.out.println("Order Recieved End Date:" + ordersReceivedDateEnd);

		if (ordersReceivedDateEnd.compareTo(ordersReceivedDateStart) > 0) {
			System.out.println("Order Recieved End Date is greater than Order Recieved Start Date");
		} else {
			System.out.println("Order Recieved End Date is not greater than Order Recieved Start Date");
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String todaysDate = dateFormat.format(date);
		System.out.println("Today's Date:" + todaysDate);

		if (ordersReceivedDateEnd.equals(todaysDate)) {
			System.out.println("By Default,the order received end date is today's date");
		} else {
			System.out.println("By Default,the order received end date is not today's date");
		}

		cal.add(Calendar.DATE, -7);
		String substractedDate = dateFormat.format(cal.getTime());
		System.out.println("Order Recieved Start Date to be after substracting 7 days:" + substractedDate);

		if (ordersReceivedDateStart.equals(substractedDate)) {
			System.out.println("By Default,the order received start date is equal to today's date - 7");
		} else {
			System.out.println("By Default,the order received start date is not equal to today's date - 7");
		}

		Assert.assertEquals(true, orderStatusDropdown.isDisplayed());
		System.out.println("Order Status Dropdown is displayed");

		Assert.assertEquals(true, channels.isDisplayed());
		System.out.println("Channels Dropdown Field is displayed");
		System.out.println("===============================================================");
	}

	public void findOrders() {
		log.info("Finding the sales orders");
		orderTextbox.sendKeys("#13066");

		ordersReceivedDateStartCalendarList.sendKeys("01-01-2022");

		ordersReceivedDateEndCalendarList.sendKeys("31-05-2022");

		orderStatusDropdown.click();
		updateProcessed.click();

		channels.click();
		shopify.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", findOrdersButton);

		if (noOrdersFoundMessage.isDisplayed()) {
			System.out.println(noOrdersFoundMessage.getText());
		} else {
			System.out.println("The data is to be displayed and it is not displayed");

		}
		System.out.println("===============================================================");
	}
}
