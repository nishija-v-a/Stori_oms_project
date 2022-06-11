package OMSPages;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OMSFindOrdersPage {

	WebDriver driver;
	WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(OMSFindOrdersPage.class);

	@FindBy(xpath = "//*[text()='Manage Orders ']")
	WebElement manageOrdersTab;

	@FindBy(xpath = "//*[text()='Filters']")
	WebElement filters;

	@FindBy(xpath = "//*[@id=\"displayNames\"]")
	WebElement orderDisplayName;

	@FindBy(xpath = "//*[@id=\"custRef\"]")
	WebElement customerReference;

	@FindBy(xpath = "//*[text()='Select Order Type']")
	WebElement orderType;
	@FindBy(xpath = "//div[contains(text(),'Default')]")
	WebElement defaultOption;
	@FindBy(xpath = "//div[contains(text(),'Type1')]")
	WebElement type1;
	@FindBy(xpath = "//div[contains(text(),'Type2')]")
	WebElement type2;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div[2]/div/div/div/form/div[1]/div[4]/div/ng-multiselect-dropdown")
	WebElement orderStatus;
	@FindBy(xpath = "//div[contains(text(),'Not Confirmed')]")
	WebElement notConfirmed;
	@FindBy(xpath = "//div[contains(text(),'Confirmed')]")
	WebElement confirmed;
	@FindBy(xpath = "//div[contains(text(),'Processed')]")
	WebElement processed;
	@FindBy(xpath = "//div[contains(text(),'Shipped')]")
	WebElement shipped;
	@FindBy(xpath = "//div[contains(text(),'Delivered')]")
	WebElement delivered;
	@FindBy(xpath = "//div[contains(text(),'Delivery Postponed')]")
	WebElement deliveryPostponed;
	@FindBy(xpath = "//div[contains(text(),'Delivery Failed')]")
	WebElement deliveryFailed;
	@FindBy(xpath = "//div[contains(text(),'Cancelled')]")
	WebElement cancelled;

	@FindBy(xpath = "//*[text()='Select Groups']")
	WebElement orderGroups;
	@FindBy(xpath = "//div[contains(text(),'Group1')]")
	WebElement group1;
	@FindBy(xpath = "//div[contains(text(),'Group_New_789')]")
	WebElement GroupNew789;
	@FindBy(xpath = "//div[contains(text(),'Courtyard Farms')]")
	WebElement courtyardFarms;
	@FindBy(xpath = "//div[contains(text(),'Highland')]")
	WebElement highland;
	@FindBy(xpath = "//div[contains(text(),'Others')]")
	WebElement others;

	@FindBy(xpath = "//*[text()='Select Labels']")
	WebElement orderLabels;
	@FindBy(xpath = "//div[contains(text(),'Label 3')]")
	WebElement label3;
	@FindBy(xpath = "//div[contains(text(),'Label_123_Edit')]")
	WebElement label123Edit;
	@FindBy(xpath = "//div[contains(text(),'MADA')]")
	WebElement mada;
	@FindBy(xpath = "//div[contains(text(),'NOT-SCANNED')]")
	WebElement notScanned;
	@FindBy(xpath = "//div[contains(text(),'Note Missing')]")
	WebElement noteMissing;
	@FindBy(xpath = "//div[contains(text(),'QC Failed')]")
	WebElement qcFailed;
	@FindBy(xpath = "//div[contains(text(),'QC Passed')]")
	WebElement qcPassed;
	@FindBy(xpath = "//div[contains(text(),'Test LAbel')]")
	WebElement testLAbel;
	@FindBy(xpath = "//div[contains(text(),'amended')]")
	WebElement amended;
	@FindBy(xpath = "//div[contains(text(),'bank-transfer-order')]")
	WebElement banktransferorder;
	@FindBy(xpath = "//div[contains(text(),'label')]")
	WebElement label;
	@FindBy(xpath = "//div[contains(text(),'not-paid')]")
	WebElement notpaid;
	@FindBy(xpath = "//div[contains(text(),'samples-only')]")
	WebElement samplesonly;
	@FindBy(xpath = "//div[contains(text(),'test')]")
	WebElement test;
	@FindBy(xpath = "//div[contains(text(),'testE')]")
	WebElement testE;
	@FindBy(xpath = "//div[contains(text(),'tyhyhjgjhgjhgjhkghkjh,khkhjkhvjghjghcjyjhjjyuyttr7w54675ue6udyu')]")
	WebElement ty;

	@FindBy(xpath = "//*[text()='Select Sales Channels']")
	WebElement salesChannel;
	@FindBy(xpath = "//div[contains(text(),'NewSales')]")
	WebElement newSales;
	@FindBy(xpath = "//div[contains(text(),'Storicart E-Commerce_SIT')]")
	WebElement storicart;
	@FindBy(xpath = "//div[contains(text(),'SHOPIFY')]")
	WebElement shopify;
	@FindBy(xpath = "//div[contains(text(),'AMAZON')]")
	WebElement amazon;

	@FindBy(xpath = "//*[text()='Select Delivery Channels']")
	WebElement deliveryChannel;
	@FindBy(xpath = "//div[contains(text(),'DOMESTIC')]")
	WebElement domestic;
	@FindBy(xpath = "//div[contains(text(),'ALMA EXPRESS')]")
	WebElement almaExpress;
	@FindBy(xpath = "//div[contains(text(),'NAQEL')]")
	WebElement naqel;
	@FindBy(xpath = "//div[contains(text(),'Customer Pickup')]")
	WebElement customerPickup;
	@FindBy(xpath = "//div[contains(text(),'Hyperlocal Delivery')]")
	WebElement hyperlocalDelivery;
	@FindBy(xpath = "//div[contains(text(),'Self Delivery')]")
	WebElement selfDelivery;
	@FindBy(xpath = "//div[contains(text(),'Courier')]")
	WebElement courier;
	@FindBy(xpath = "//div[contains(text(),'UnAssigned')]")
	WebElement unAssigned;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div[2]/div/div/div/form/div[3]/div[1]/input")
	WebElement dispatchDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container")
	WebElement datePickerDispatchDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")
	WebElement fromMonthDispatchDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span")
	WebElement fromYearDispatchDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[1]")
	WebElement previousButtonDis;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")
	WebElement toMonthDispatchDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span")
	WebElement toYearDispatchDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]")
	WebElement nextButtonDis;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div[2]/div/div/div/form/div[3]/div[2]/div/input")
	WebElement deliveryDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container")
	WebElement datePickerDeliveryDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")
	WebElement fromMonthDeliveryDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span")
	WebElement fromYearDeliveryDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[1]")
	WebElement previousButtonDel;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")
	WebElement toMonthDeliveryDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span")
	WebElement toYearDeliveryDate;
	@FindBy(xpath = "/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]")
	WebElement nextButtonDel;

	@FindBy(xpath = "//*[text()='Select Assignee']")
	WebElement orderEntityAssigneeNames;
	@FindBy(xpath = "//div[contains(text(),'faseela.tc@storilabs.com')]")
	WebElement assignee;

	@FindBy(xpath = "//*[text()='Select Payment status']")
	WebElement orderPaymentStatus;
	@FindBy(xpath = "//div[contains(text(),'PENDING')]")
	WebElement pending;
	@FindBy(xpath = "//div[contains(text(),'PARTIALLY_PAID')]")
	WebElement partiallyPaid;
	@FindBy(xpath = "//div[contains(text(),'PAID')]")
	WebElement paid;

	@FindBy(xpath = "//*[@id=\"additionalInfo\"]")
	WebElement orderTag;

	@FindBy(xpath = "//*[text()='Select Fulfillment Center']")
	WebElement orderFulfillmentCenter;
	@FindBy(xpath = "//div[contains(text(),'Chennai')]")
	WebElement fulfillmentCenter;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div[2]/div/div/div/form/div[5]/div[2]/button")
	WebElement searchButton;

	@FindBy(id = "orderTable")
	WebElement orderList;

	@FindBy(xpath = "//*[text()='No Orders Found ']")
	WebElement noOrderMessage;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div[2]/div/div/div/form/div[5]/div[3]/button")
	WebElement excelGenerateButton;

	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	WebElement excelGenerateMessage;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div[2]/div/div/div/form/div[5]/div[3]/button[2]")
	WebElement excelDownloadButton;

	@FindBy(xpath = "//*[@id=\"orderTable\"]/tbody[1]/tr[1]/td[11]/div/span[1]")
	WebElement orderEditIcon;

	@FindBy(xpath = "//*[text()='Update Order']")
	WebElement orderEditPageTitle;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/ul")
	WebElement orderEditPageTabs;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[1]/div[1]")
	WebElement orderItemsTabData;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div[3]/strong")
	WebElement orderCreateDate;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div[2]")
	WebElement orderItemsTabOrderStatus;

	@FindBy(xpath = "//*[@id=\"order-details\"]/div/div[1]/button")
	WebElement orderItemsTabEditButton;

	@FindBy(xpath = "//*[@id=\"order-details\"]/div/div[2]/div[1]/div/table/tbody")
	WebElement orderItemsTabItemsTable;

	@FindBy(xpath = "//*[@id=\"order-details\"]/div/div[2]/div[2]/div/div/div/table")
	WebElement orderItemsTabTotal;

	@FindBy(xpath = "//*[text()='Order Details']")
	WebElement orderDetailsTab;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/div/tab[2]/div/div/div[1]/div/strong/text()")
	WebElement orderDetailsTaborderTags;

	@FindBy(xpath = "//*[@id=\"inputState\"]")
	WebElement orderDetailsTabGroup;

	@FindBy(xpath = "//*[@formcontrolname=\"orderFulFillmentCenter\"]")
	WebElement orderDetailsTabFulfillmentCenter;

	@FindBy(xpath = "//*[@id=\"ordervendor\"]")
	WebElement orderDetailsTabVendor;

	@FindBy(xpath = "//*[@id=\"orderDispatchDate\"]")
	WebElement orderDetailsTabDispatchDate;

	@FindBy(xpath = "//*[@id=\"orderDeliveryDate\"]")
	WebElement orderDetailsTabDeliveryDate;

	@FindBy(xpath = "//*[@formcontrolname=\"orderDeliveryChannel\"]")
	WebElement orderDetailsTabDeliveryChannel;

	@FindBy(xpath = "//*[@id=\"financialStatus\"]")
	WebElement orderDetailsTabFinancialStatus;

	@FindBy(xpath = "//*[@placeholder=\"Enter Label Keywords\"]")
	WebElement orderDetailsTabOrderLabels;

	@FindBy(xpath = "(//*[text()='Notes'])[2]")
	WebElement orderNotesTab;

	@FindBy(xpath = "//*[@id=\"customerNote\"]")
	WebElement orderNotesTabCustomerNote;

	@FindBy(xpath = "//*[@id=\"orderNote\"]")
	WebElement orderNotesTabAddYourNote;

	@FindBy(xpath = "//*[text()='Shipping Address']")
	WebElement shippingAddressTab;

	@FindBy(xpath = "//*[@id=\"addressTitle\"]")
	WebElement shippingAddressTabTitle;

	@FindBy(xpath = "//*[@id=\"addressName\"]")
	WebElement shippingAddressTabName;

	@FindBy(xpath = "//*[@id=\"addressPhone\"]")
	WebElement shippingAddressTabPhone;

	@FindBy(xpath = "//*[@id=\"addressField1\"]")
	WebElement shippingAddressTabAddressField1;

	@FindBy(xpath = "//*[@id=\"addressField2\"]")
	WebElement shippingAddressTabAddressField2;

	@FindBy(xpath = "//*[@id=\"addressCity\"]")
	WebElement shippingAddressTabCity;

	@FindBy(xpath = "//*[@id=\"addressProvince\"]")
	WebElement shippingAddressTabState;

	@FindBy(xpath = "//*[@id=\"addressZip\"]")
	WebElement shippingAddressTabZipCode;

	@FindBy(xpath = "//*[@id=\"addressCountry\"]")
	WebElement shippingAddressTabCountry;

	@FindBy(xpath = "//*[@id=\"orderLatitude\"]")
	WebElement shippingAddressTabLattitude;

	@FindBy(xpath = "//*[@id=\"orderLongitude\"]")
	WebElement shippingAddressTabLongitude;

	@FindBy(xpath = "//*[text()='Delivery Details']")
	WebElement deliveryDetailsTab;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/div/tab[5]/div/div[1]/div/div")
	WebElement deliveryDetailsTabData;

	@FindBy(xpath = "//*[text()='Order Entities']")
	WebElement orderEntitiesTab;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/div/tab[7]/div[1]/div/div/div/div/div[1]/div/div/select")
	WebElement orderEntitiesTabOrderEntityRoleDropdown;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/div/tab[7]/div[1]/div/div/div/div/div[2]/div/div/select")
	WebElement orderEntitiesTabOrderEntityDropdown;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/div/tab[7]/div[1]/div/div/div/div/div[3]/div/div/select")
	WebElement orderEntitiesTabEntityStatusDropdown;

	@FindBy(xpath = "//*[text()='Add']")
	WebElement orderEntitiesTabAddButton;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/div/tab[7]/div[2]/div[2]/table")
	WebElement orderEntitiesTabOrderEntityList;

	@FindBy(xpath = "//*[text()='Timeline']")
	WebElement timelineTab;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[2]/div/tabset/div/tab[8]/div/div/div/div/table/tbody")
	WebElement timelineTabTimeline;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-order-update/div/div/div[2]/form/div[1]/div[2]/div/div[2]/span/input")
	WebElement overrideSystemDefaults;

	@FindBy(xpath = "//*[text()=' Update Order ']")
	WebElement updateOrderButton;

	@FindBy(xpath = "//*[text()='Sales Orders ']")
	WebElement salesOrderTab;

	public OMSFindOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void manageOrdersTabDisplay() {
		log.info("Entering to Manage Orders Tab");
		String expectedTab = "Manage Orders";
		String actualTab = manageOrdersTab.getText();
		Assert.assertEquals(expectedTab, actualTab);
		System.out.println("User landed on Manage Orders Tab");
		System.out.println("===============================================================");
	}

	public void findOrdersTabDisplay() {
		log.info("By default to Find Orders Tab");
		String expectedPage = "https://staging.oms.bytetale.com/manage-orders/search";
		String actualPage = driver.getCurrentUrl();
		Assert.assertEquals(expectedPage, actualPage);
		System.out.println("Find Orders Page is displayed");
		System.out.println("===============================================================");
	}

	public void filtersDisplay() {
		filters.click();
		System.out.println("Clicked on Filters");
		System.out.println("===============================================================");

		Assert.assertEquals(true, orderDisplayName.isDisplayed());
		System.out.println("Order Display Field is displayed");

		Assert.assertEquals(true, customerReference.isDisplayed());
		System.out.println("Customer Reference Field is displayed");

		Assert.assertEquals(true, orderType.isDisplayed());
		System.out.println("Order Type Dropdown is displayed");

		Assert.assertEquals(true, orderStatus.isDisplayed());
		System.out.println("Order Status Dropdown is displayed");
		System.out.println(orderStatus.getText());
		System.out.println(
				"Orders are populated with Processed,Confirmed,Not confirmed,Approved in the Order Status field by default");

		Assert.assertEquals(true, orderGroups.isDisplayed());
		System.out.println("Order Groups Dropdown is displayed");

		Assert.assertEquals(true, orderLabels.isDisplayed());
		System.out.println("Order Labels Dropdown is displayed");

		Assert.assertEquals(true, salesChannel.isDisplayed());
		System.out.println("Sales Channel Dropdown is displayed");

		Assert.assertEquals(true, deliveryChannel.isDisplayed());
		System.out.println("Delivery Channel Dropdown is displayed");

		Assert.assertEquals(true, dispatchDate.isDisplayed());
		System.out.println("Dispatch Date Field is displayed");

		Assert.assertEquals(true, deliveryDate.isDisplayed());
		System.out.println("Delivery Date Field is displayed");

		Assert.assertEquals(true, orderEntityAssigneeNames.isDisplayed());
		System.out.println("Order Entity Assignee Names Dropdown is displayed");

		Assert.assertEquals(true, orderPaymentStatus.isDisplayed());
		System.out.println("Order Payment Status Dropdown is displayed");

		Assert.assertEquals(true, orderTag.isDisplayed());
		System.out.println("Order Tag Field is displayed");

		Assert.assertEquals(true, orderFulfillmentCenter.isDisplayed());
		System.out.println("Order Fulfillment Center Dropdown is displayed");
		System.out.println("===============================================================");
	}

	public void OrderdisplayNameField() {
		orderDisplayName.sendKeys("#11");
	}

	public void CustomerReferenceField() {
		customerReference.sendKeys("aishwarya");
	}

	public void OrderTypeDropdown() {
		orderType.click();
		defaultOption.click();
	}

	public void OrderStatusDropdown() {
		orderStatus.click();
		processed.click();
		shipped.click();
	}

	public void OrderGroupsDropdown() {
		orderGroups.click();
		group1.click();
	}

	public void OrderLabelsDropdown() {
		orderLabels.click();
		label3.click();
	}

	public void SalesChannelDropdown() {
		salesChannel.click();
		amazon.click();
	}

	public void DeliveryChannelDropdown() {
		deliveryChannel.click();
		selfDelivery.click();
	}

	public void DispacthDatePicker() {
		dispatchDate.click();
		Assert.assertEquals(true, datePickerDispatchDate.isDisplayed());
		System.out.println("Date Picker for Dispatch date is displayed");

		String fromMonthDispatch = "March";
		String fromYearDispatch = "2022";
		String fromDispatchDate = "1";

		while (true) {
			String fromMonthDis = fromMonthDispatchDate.getText();
			String fromYearDis = fromYearDispatchDate.getText();

			if (fromMonthDis.equals(fromMonthDispatch) && fromYearDis.equals(fromYearDispatch)) {
				break;
			}

			else {
				previousButtonDis.click();
			}
		}

		List<WebElement> fromDisDate = driver.findElements(By.xpath(
				"/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]//table//*[@class='ng-star-inserted']//span[not(@class='is-other-month')]"));

		for (int i = 0; i < fromDisDate.size(); i++) {
			String actualfromDisDate = fromDisDate.get(i).getText();
			if (actualfromDisDate.equals(fromDispatchDate)) {
				fromDisDate.get(i).click();
				break;
			}
		}

		String toMonthDispatch = "May";
		String toYearDispatch = "2022";
		String toDispatchDate = "31";

		while (true) {
			String toMonthDis = toMonthDispatchDate.getText();
			String toYearDis = toYearDispatchDate.getText();

			if (toMonthDis.equals(toMonthDispatch) && toYearDis.equals(toYearDispatch)) {
				break;
			}

			else {
				nextButtonDis.click();
			}
		}

		List<WebElement> toDisDate = driver.findElements(By.xpath(
				"/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]//table//*[@class='ng-star-inserted']//span[not(@class='is-other-month')]"));

		for (int i = 0; i < toDisDate.size(); i++) {
			String actualtoDisDate = toDisDate.get(i).getText();
			if (actualtoDisDate.equals(toDispatchDate)) {
				toDisDate.get(i).click();
				break;
			}
		}
	}

	public void DeliveryDatePicker() {
		deliveryDate.click();
		Assert.assertEquals(true, datePickerDeliveryDate.isDisplayed());
		System.out.println("Date Picker for Delivery date is displayed");

		String fromMonthDelivery = "March";
		String fromYearDelivery = "2022";
		String fromDeliveryDate = "1";

		while (true) {
			String fromMonthDel = fromMonthDeliveryDate.getText();
			String fromYearDel = fromYearDeliveryDate.getText();

			if (fromMonthDel.equals(fromMonthDelivery) && fromYearDel.equals(fromYearDelivery)) {
				break;
			}

			else {
				previousButtonDel.click();
			}
		}

		List<WebElement> fromDelDate = driver.findElements(By.xpath(
				"/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[1]//table//*[@class='ng-star-inserted']//span[not(@class='is-other-month')]"));

		for (int i = 0; i < fromDelDate.size(); i++) {
			String actualfromDelDate = fromDelDate.get(i).getText();
			if (actualfromDelDate.equals(fromDeliveryDate)) {
				fromDelDate.get(i).click();
				break;
			}
		}

		String toMonthDelivery = "May";
		String toYearDelivery = "2022";
		String toDeliveryDate = "31";

		while (true) {
			String toMonthDel = toMonthDeliveryDate.getText();
			String toYearDel = toYearDeliveryDate.getText();

			if (toMonthDel.equals(toMonthDelivery) && toYearDel.equals(toYearDelivery)) {
				break;
			}

			else {
				nextButtonDel.click();
			}
		}
		List<WebElement> toDelDate = driver.findElements(By.xpath(
				"/html/body/bs-daterangepicker-container/div/div/div/div/bs-days-calendar-view[2]//table//*[@class='ng-star-inserted']//span[not(@class='is-other-month')]"));

		for (int i = 0; i < toDelDate.size(); i++) {
			String actualtoDelDate = toDelDate.get(i).getText();
			if (actualtoDelDate.equals(toDeliveryDate)) {
				toDelDate.get(i).click();
				break;
			}
		}
	}

	public void OrderEntityAssigneeNamesDropdown() {
		orderEntityAssigneeNames.click();
		assignee.click();
	}

	public void OrderPaymentStatusDropdown() {
		orderPaymentStatus.click();
		paid.click();
	}

	public void OrderTagField() {
		orderTag.sendKeys("tag");
	}

	public void OrderFulfillmentCenterDropdown() {
		orderFulfillmentCenter.click();
		fulfillmentCenter.click();
		System.out.println("===============================================================");
	}

	public void search() {
		log.info("Searching the Order");
		Assert.assertEquals(true, searchButton.isDisplayed());
		System.out.println("Search Button is displayed");
		System.out.println("===============================================================");

		long startTime = System.currentTimeMillis();

		searchButton.click();

		try {
			System.out.println(orderList.getText());
		}

		catch (Exception e) {
			System.out.println(noOrderMessage.getText());
		}
		System.out.println("===============================================================");
		long finishTime = System.currentTimeMillis();
		long totalTime = finishTime - startTime;
		System.out.println("Total Time for page load = " + totalTime);
		if (totalTime <= 5000) {
			System.out.println("The data is fetched in " + totalTime
					+ " milli seconds which is less than or equal to 5 seconds(5000 milli seconds)");
		} else {
			System.out.println("The data is fetched in " + totalTime
					+ "milli seconds which is greater than 5 seconds(5000 milli seconds)");
		}
		System.out.println("===============================================================");
	}

	public void excel() {
		log.info("Generating the Excel");
		Assert.assertEquals(true, excelGenerateButton.isDisplayed());
		System.out.println("Excel Generation Button is displayed");
		excelGenerateButton.click();

		try {
			System.out.println(excelGenerateMessage.getText());
			excelDownloadButton.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("===============================================================");
	}

	public void orderEditAction() {
		log.info("Editing the Order");
		try {
			if (orderEditIcon.isDisplayed()) {
				orderEditIcon.click();

				System.out.println(orderEditPageTitle.getAttribute("innerText"));
				System.out.println("Order Edit Page is displayed");
				System.out.println("===============================================================");

				System.out.println(orderEditPageTabs.getAttribute("innerText"));
				System.out.println("===============================================================");

				System.out.println(orderItemsTabData.getAttribute("innerText"));
				System.out.println("===============================================================");

				String orderItemsTabOrderstatus = orderItemsTabOrderStatus.getAttribute("innerText");
				System.out.println(orderItemsTabOrderstatus);
				System.out.println("===============================================================");

				if (orderItemsTabOrderstatus.contains("Confirmed")) {
					try {
						if (orderItemsTabEditButton.isDisplayed()) {
							System.out.println("Edit Button in Order Items Tab is displayed");
						}
					} catch (Exception e) {
						System.out.println("Edit Button is not displayed when order is in Confirmed status");
					}

				}
				System.out.println("===============================================================");

				System.out.println(orderItemsTabItemsTable.getAttribute("innerText"));
				System.out.println("===============================================================");

				System.out.println(orderItemsTabTotal.getAttribute("innerText"));
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTab.isDisplayed());
				System.out.println("Order Details Tab is displayed");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", orderDetailsTab);
				System.out.println("===============================================================");

				try {
					if (orderDetailsTaborderTags.isDisplayed()) {
						System.out.println("Order Tags in Order Details Tab is displayed");
					}
				} catch (Exception e) {

					System.out.println("Order Tags in Order Details Tab is not displayed");
				}
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabGroup.isDisplayed());
				System.out.println("Group dropdown in Order Details Tab is displayed");
				Select selectGroup = new Select(orderDetailsTabGroup);
				System.out.println(selectGroup.getFirstSelectedOption().getText());
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabFulfillmentCenter.isDisplayed());
				System.out.println("Fulfillment Center dropdown in Order Details Tab is displayed");
				Select selectFulFillmentCenter = new Select(orderDetailsTabFulfillmentCenter);
				System.out.println(selectFulFillmentCenter.getFirstSelectedOption().getText());
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabVendor.isDisplayed());
				System.out.println("Vendor Field in Order Details Tab is displayed");
				System.out.println(orderDetailsTabVendor.getAttribute("placeholder"));
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabDispatchDate.isDisplayed());
				System.out.println("Dispatch Date in Order Details Tab is displayed");
				String orderDetailsTabDispatchdate = orderDetailsTabDispatchDate.getAttribute("value");
				System.out.println(orderDetailsTabDispatchdate);
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabDeliveryDate.isDisplayed());
				System.out.println("Delivery Date in Order Details Tab is displayed");
				String orderDetailsTabDeliverydate = orderDetailsTabDeliveryDate.getAttribute("value");
				System.out.println(orderDetailsTabDeliverydate);
				System.out.println("===============================================================");

				String orderCreatedate = orderCreateDate.getText();
				System.out.println(orderCreatedate);
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabDeliveryChannel.isDisplayed());
				System.out.println("Delivery Channel dropdown in Order Details Tab is displayed");
				System.out.println("===============================================================");

				Select selectDeliveryChannel = new Select(orderDetailsTabDeliveryChannel);
				String actualDeliveryChannel = selectDeliveryChannel.getFirstSelectedOption().getText();
				System.out.println(actualDeliveryChannel);
				System.out.println("===============================================================");

				if (actualDeliveryChannel.contains("Self Delivery")) {
					System.out.println("The order is assigned as Self Delivery channel by default");
					if (orderDetailsTabDispatchdate.equalsIgnoreCase(orderDetailsTabDeliverydate)) {
						System.out.println("For Self Delivery channel,dispatch date is equal to delivery date");
					} else {
						System.out.println("For Self Delivery channel,dispatch date is not equal to delivery date");
					}

				}

				else if (actualDeliveryChannel.contains("Hyperlocal Delivery")) {
					if (orderDetailsTabDispatchdate.equalsIgnoreCase(orderDetailsTabDeliverydate)) {
						System.out.println("For Hyperlocal Delivery channel,dispatch date is equal to delivery date");
					} else {
						System.out
								.println("For Hyperlocal Delivery channel,dispatch date is not equal to delivery date");
					}
				}

				else if (actualDeliveryChannel.contains("Customer Pickup")) {
					if (orderDetailsTabDispatchdate.equalsIgnoreCase(orderDetailsTabDeliverydate)) {
						System.out.println("For Customer Pickup channel,dispatch date is equal to delivery date");
					} else {
						System.out.println("For Customer Pickup channel,dispatch date is not equal to delivery date");
					}
				}

				else if (actualDeliveryChannel.contains("Courier")) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					try {
						cal.setTime(dateFormat.parse(orderDetailsTabDeliverydate));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					cal.add(Calendar.DATE, -2);
					String convertedDispatchDateCourier = dateFormat.format(cal.getTime());
					System.out.println(convertedDispatchDateCourier);

					if (orderDetailsTabDispatchdate.equalsIgnoreCase(convertedDispatchDateCourier)) {
						System.out.println("For Courier channel,dispatch date is equal to delivery date - 2 ");
					} else {
						System.out.println("For Courier channel,dispatch date is not equal to delivery date - 2 ");
					}
				}

				else {
					System.out.println("Other Channels selected");
				}
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabFinancialStatus.isDisplayed());
				System.out.println("Financial Status dropdown in Order Details Tab is displayed");
				Select selectFinancialStatus = new Select(orderDetailsTabFinancialStatus);
				System.out.println(selectFinancialStatus.getFirstSelectedOption().getText());
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderDetailsTabOrderLabels.isDisplayed());
				System.out.println("Order Labels Field in Order Details Tab is displayed");
				System.out.println(orderDetailsTabOrderLabels.getAttribute("placeholder"));
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderNotesTab.isDisplayed());
				System.out.println("Order Notes Tab is displayed");
				orderNotesTab.click();

				Assert.assertEquals(true, orderNotesTabCustomerNote.isDisplayed());
				System.out.println("Customer Note field in the Order Notes Tab is displayed");
				orderNotesTabCustomerNote.click();
				String orderNotesTabCustomerNoteData = orderNotesTabCustomerNote.getAttribute("value");
				if (orderNotesTabCustomerNoteData.isEmpty()) {
					System.out.println(orderNotesTabCustomerNote.getAttribute("placeholder"));
				} else {
					System.out.println(orderNotesTabCustomerNoteData);
				}
				String editingOrderNotesTabCustomerNote = "Editing!";
				orderNotesTabCustomerNote.sendKeys(editingOrderNotesTabCustomerNote);
				System.out.println(orderNotesTabCustomerNote.getAttribute("value"));
				if (orderItemsTabOrderstatus.contains("Confirmed")) {
					if (orderNotesTabCustomerNote.getAttribute("value").contains(editingOrderNotesTabCustomerNote)) {
						System.out.println("Customer Note field is editable");
					} else {
						System.out.println("Customer Note field is not editable");
					}
				} else {
					System.out.println("Customer Note field is editable in all other order status");
				}
				System.out.println("===============================================================");

				Assert.assertEquals(true, shippingAddressTab.isDisplayed());
				System.out.println("Shipping Address Tab is displayed");
				shippingAddressTab.click();

				Assert.assertEquals(true, shippingAddressTabTitle.isDisplayed());
				System.out.println("Title field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabTitle.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabName.isDisplayed());
				System.out.println("Name field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabName.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabPhone.isDisplayed());
				System.out.println("Phone field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabPhone.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabAddressField1.isDisplayed());
				System.out.println("Address field 1 in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabAddressField1.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabAddressField2.isDisplayed());
				System.out.println("Address field 2 in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabAddressField2.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabCity.isDisplayed());
				System.out.println("City field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabCity.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabState.isDisplayed());
				System.out.println("State field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabState.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabZipCode.isDisplayed());
				System.out.println("Zip Code field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabZipCode.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabCountry.isDisplayed());
				System.out.println("Country field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabCountry.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabLattitude.isDisplayed());
				System.out.println("Latittude field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabLattitude.getAttribute("value"));

				Assert.assertEquals(true, shippingAddressTabLongitude.isDisplayed());
				System.out.println("Longitude field in the Shipping Address Tab is displayed");
				System.out.println(shippingAddressTabLongitude.getAttribute("value"));
				System.out.println("===============================================================");

				Assert.assertEquals(true, deliveryDetailsTab.isDisplayed());
				System.out.println("Delivery Details Tab is displayed");
				deliveryDetailsTab.click();
				System.out.println(deliveryDetailsTabData.getAttribute("innerText"));
				System.out.println("===============================================================");

				Assert.assertEquals(true, orderEntitiesTab.isDisplayed());
				System.out.println("Order Entities Tab is displayed");
				orderEntitiesTab.click();

				Assert.assertEquals(true, orderEntitiesTabOrderEntityRoleDropdown.isDisplayed());
				System.out.println("Order Entity Role dropdown in the Order Entities Tab is displayed");

				Assert.assertEquals(true, orderEntitiesTabOrderEntityDropdown.isDisplayed());
				System.out.println("Order Entity dropdown in the Order Entities Tab is displayed");

				Assert.assertEquals(true, orderEntitiesTabEntityStatusDropdown.isDisplayed());
				System.out.println("Entity Status dropdown in the Order Entities Tab is displayed");

				Assert.assertEquals(true, orderEntitiesTabAddButton.isDisplayed());
				System.out.println("Add button in the Order Entities Tab is displayed");

				System.out.println(orderEntitiesTabOrderEntityList.getAttribute("innerText"));
				System.out.println("===============================================================");

				Assert.assertEquals(true, timelineTab.isDisplayed());
				System.out.println("Timeline Tab is displayed");
				timelineTab.click();
				System.out.println(timelineTabTimeline.getAttribute("innerText"));
				System.out.println("===============================================================");

				Assert.assertEquals(true, overrideSystemDefaults.isDisplayed());
				System.out.println("Override System Defaults checkbox is displayed");

				Assert.assertEquals(true, updateOrderButton.isDisplayed());
				System.out.println("Update Order button is displayed");

				overrideSystemDefaults.click();
				updateOrderButton.click();
			}
		} catch (Exception e) {
			System.out.println("Order Edit icon is not displayed");
		}
		System.out.println("===============================================================");
	}

	public void orderCancelAction() {
		log.info("Canceling the Order");
		wait = new WebDriverWait(driver, 20);
		orderDisplayName.clear();
		orderDisplayName.sendKeys("#test65");
		WebElement searchbutton = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Search ']"))));
		searchbutton.click();

		WebElement orderCancelIcon = wait.until((ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTable\"]/tbody[1]/tr[1]/td[11]/div/span[2]"))));
		orderCancelIcon.click();

		WebElement orderCancelIconAlertYesButton = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Yes']"))));
		orderCancelIconAlertYesButton.click();
		System.out.println("===============================================================");
	}

	public void orderRejectAction() {
		log.info("Rejecting the Order");
		wait = new WebDriverWait(driver, 20);
		orderDisplayName.clear();
		orderDisplayName.sendKeys("#Test01");
		WebElement searchbutton = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Search ']"))));
		searchbutton.click();

		WebElement orderRejectIcon = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-reflect-tooltip='REJECT']"))));
		orderRejectIcon.click();

		WebElement orderCancelIconAlertYesButton = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Yes']"))));
		orderCancelIconAlertYesButton.click();
		System.out.println("===============================================================");
	}

	public void orderStatusAction() {
		log.info("Checking the Order Status action");
		wait = new WebDriverWait(driver, 20);
		orderDisplayName.clear();
		orderDisplayName.sendKeys("#test39");
		WebElement searchbutton = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Search ']"))));
		searchbutton.click();
		WebElement orderConfirmIcon = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-reflect-tooltip='CONFIRM']"))));
		orderConfirmIcon.click();
		System.out.println(
				"While clicking on Confirm icon, it changed to Process icon.Confirm icon is not displayed and can't be reversed");
		WebElement orderProcessIcon = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-reflect-tooltip='Process']"))));
		orderProcessIcon.click();
		System.out.println(
				"While clicking on Process icon, it changed to Shiped icon.Process icon is not displayed and can't be reversed");
		WebElement orderShippedIcon = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-reflect-tooltip='SHIP']"))));
		orderShippedIcon.click();
		System.out.println(
				"While clicking on Shipped icon, it changed to Deliver icon.Shipped icon is not displayed and can't be reversed");
		System.out.println("===============================================================");
	}

	public void navigatetoSalesOrdersPage() {
		log.info("Navigating to Sales Orders Tab");
		Actions actions = new Actions(driver);
		actions.click(manageOrdersTab).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", salesOrderTab);
		System.out.println("===============================================================");
	}
}