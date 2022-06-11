package OMS_Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import OMS_Test.OMS_STORI_Test;

public class OMS_CreateordersPage {
	private static final Logger log = LogManager.getLogger(OMS_STORI_Test.class);
	WebDriver driver;
	WebDriverWait wait;
	String NAME;
	String EMAIL;
	String PHONE;

	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement honorific;

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement firstname;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement lastname;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailid;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/form/div[1]/div[1]/div[5]/div[1]/div/div[1]/div/div/div[1]")
	WebElement countrystdcode;

	@FindBy(xpath = "//*[@id=\"iti-0__item-is\"]")
	WebElement selectcountry;

	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement phone;

	@FindBy(xpath = "//*[@id=\"vatNumber\"]")
	WebElement vatnumber;

	@FindBy(xpath = "//*[@id=\"channelAddressId\"]")
	WebElement channeladdressid;

	@FindBy(xpath = "//*[@id=\"company\"]")
	WebElement company;

	@FindBy(xpath = "//*[@id=\"address1\"]")
	WebElement addressline1;

	@FindBy(xpath = "//*[@id=\"address2\"]")
	WebElement addressline2;

	@FindBy(xpath = "//*[@id=\"city\"]")
	WebElement city;

	@FindBy(xpath = "//*[@id=\"province\"]")
	WebElement province;

	@FindBy(xpath = "//*[@id=\"zip\"]")
	WebElement zip;

	@FindBy(xpath = "//*[@id=\"country\"]")
	WebElement country;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/form/div[2]/div[2]/button")
	WebElement nextbutton;

	@FindBy(xpath = "//*[text()=\" First Name is Required \"]")
	WebElement errorfname;
	
	@FindBy(xpath = "//*[text()=\" Last Name is Required \"]")
	WebElement errorfname1;

	@FindBy(xpath = "//*[text()=\" Email is Required \"]")
	WebElement erroremail;

	@FindBy(xpath = "//*[text()=\"Phone is Required\"]")
	WebElement errorphone;

	@FindBy(xpath = "//*[@id=\"channelId\"]")
	WebElement sales_channel;

	@FindBy(xpath = "//*[@id=\"orderType\"]")
	WebElement order_type;

	@FindBy(xpath = "//*[@id=\"orderStatus\"]")
	WebElement order_status;

	@FindBy(xpath = "//*[@id=\"fulfillmentcenter\"]")
	WebElement fullfilement_center;

	@FindBy(xpath = "//*[@id=\"fulfillmentStatus\"]")
	WebElement fullfilement_status;

	@FindBy(xpath = "//*[@id=\"createdTime\"]")
	WebElement ordercreation_date;

	@FindBy(xpath = "//*[@id=\"deliveryDate\"]")
	WebElement delivery_date;

	@FindBy(xpath = "//*[@id=\"orderCurrency\"]")
	WebElement order_currency;

	@FindBy(xpath = "//*[@id=\"shippingCharge\"]")
	WebElement shipping_charge;

	@FindBy(xpath = "//*[text()=\" Require Shipping\"]")
	WebElement require_shipping;

	@FindBy(xpath = "//*[@id=\"requiresShipping\"]")
	WebElement require_shipping_option1;

	@FindBy(xpath = "//*[@value=\"false\"]")
	WebElement require_shipping_option2;

	@FindBy(xpath = "//*[@id=\"sameAddress\"]")
	WebElement billing_address;

	@FindBy(xpath = "")
	WebElement billing_default_address;

	@FindBy(xpath = "")
	WebElement shipping_address;

	@FindBy(xpath = "//*[text()=\"Sales Channel is Required\"]")
	WebElement sales_chanel_error;

	@FindBy(xpath = "//*[text()=\"Fullfilment Center is Required\"]")
	WebElement fullfilment_center_error;

	@FindBy(xpath = "//*[text()=\"Fullfilment Status is Required\"]")
	WebElement fullfilment_status_error;

	@FindBy(xpath = "//*[text()=\"Order Currency is Required\"]")
	WebElement order_currency_error;

	@FindBy(xpath = "//*[@id=\"shipTitle\"]")
	WebElement honorific_shipping;

	@FindBy(xpath = "//*[@id=\"billTitle\"]")
	WebElement honorific_billing;

	@FindBy(xpath = "//*[@id=\"shipName\"]")
	WebElement name_shipping;

	@FindBy(xpath = "//*[@id=\"company\"]")
	WebElement company_shipping;

	@FindBy(xpath = "//*[@id=\"address1\"]")
	WebElement addressline1_shipping;

	@FindBy(xpath = "//*[@id=\"address2\"]")
	WebElement addressline2_shipping;

	@FindBy(xpath = "//*[@id=\"city\"]")
	WebElement city_shipping;

	@FindBy(xpath = "//*[@id=\"zip\"]")
	WebElement zip_shipping;

	@FindBy(xpath = "//*[@id=\"province\"]")
	WebElement province_shipping;

	@FindBy(xpath = "//*[@id=\"country\"]")
	WebElement country_shipping;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[2]/app-order-nshipping-details/div/div/form/div[3]/div[1]/button/span")
	WebElement nextbutton_order_shipping;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[2]/div/table/tbody/tr/td[5]/h3/span")
	WebElement add_lineitem;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[1]/div[2]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement sku;

	@FindBy(xpath = "//*[text()=\"Greek Yogurt Apple Guava (Goat Milk)\"]")
	WebElement sku_option1;

	@FindBy(xpath = "//*[text()=\"Goat Milk Kefir-Classic\"]")
	WebElement sku_option2;

	@FindBy(xpath = "//*[text()=\"Greek Yogurt - Blueberry (Goat Milk)\"]")
	WebElement sku_option3;

	@FindBy(xpath = "//*[@id=\"quantity\"]")
	WebElement quantity;

	@FindBy(xpath = "//*[@id=\"skuId\"]")
	WebElement skuid;

	@FindBy(xpath = "//*[@id=\"longName\"]")
	WebElement longname;

	@FindBy(xpath = "//*[@id=\"shortName\"]")
	WebElement shortname;

	@FindBy(xpath = "//*[@id=\"description\"]")
	WebElement description;

	@FindBy(xpath = "//*[@id=\"unit\"]")
	WebElement unit;

	@FindBy(xpath = "//*[@id=\"unitPrice\"]")
	WebElement price;

	@FindBy(xpath = "//*[@id=\"taxAmount\"]")
	WebElement tax;

	@FindBy(xpath = "//*[@id=\"skuName\"]")
	WebElement skuname;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[3]/div/div[1]/div[3]/span")
	WebElement subtotal;

	@FindBy(id = "total")
	WebElement total;

	@FindBy(xpath = "//*[@id=\"unitOfMeasurement\"]")
	WebElement uom;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[4]/div/button[2]")
	WebElement additem;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[4]/div/button[3]")
	WebElement close;

	@FindBy(id = "//*[@id=\"totalPrice\"]")
	WebElement total_price;

	@FindBy(id = "//*[@id=\"itemDiscoundCode\"]")
	WebElement discountcode;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[2]/div[2]/div/div/p")
	WebElement error_longname;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[2]/div[3]/div/div/p")
	WebElement error_shortname;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[2]/div[5]/div[1]/div/p")
	WebElement error_unit;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[2]/div[5]/div[4]/div/p")
	WebElement error_price;

	@FindBy(id = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[3]/div/div[4]/div[3]/div/p")
	WebElement error_total;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[2]/div[6]/div[1]/div/p")
	WebElement error_quantity;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[2]/div[7]/div[2]/div[1]/div/p")
	WebElement error_skuid;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-line-items/div/div/div[2]/form/div[2]/div[5]/div[2]/div/p")
	WebElement error_uom;

	@FindBy(xpath = "/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[2]/div")
	WebElement itemlist;

	@FindBy(id = "//*[@class=\"float-right\"][@ng-reflect-tooltip=\"Clear Items\"]")
	WebElement clearitem;

	@FindBy(id = "//*[text()=\"Close\"]")
	WebElement close_edit;

	@FindBy(id = "//*[@id=\"total\"]")
	WebElement total_edit;

	@FindBy(id = "//*[@id=\"taxAmount\"]")
	WebElement taxamount_edit;

	@FindBy(id = "//*[@id=\"orderSubTotal\"]")
	WebElement subtotal_linitem;

	public OMS_CreateordersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void customer_details() {

		Select honorifi_option = new Select(honorific);
		honorifi_option.selectByVisibleText("Miss");
		firstname.sendKeys("nishija");
		NAME = firstname.getAttribute("value");

		String last_name = "VA";
		Date date_name = Calendar.getInstance().getTime();
		DateFormat dateFormat_name = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_name = date_name.getTime();
		String strDate_name = dateFormat_name.format(date_name);
		String Name = last_name + strDate_name + timeMilli_name;
		lastname.sendKeys(Name);

		emailid.sendKeys("nishijaaaa@gmail.com");
		EMAIL = emailid.getAttribute("value");
		phone.sendKeys("789065439876");
		PHONE = phone.getAttribute("value");
		countrystdcode.click();
		selectcountry.click();

		vatnumber.sendKeys("657687898");
		channeladdressid.sendKeys("001");

		String user_company = "Testvox";
		Date date_company = Calendar.getInstance().getTime();
		DateFormat dateFormat_company = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_company = date_company.getTime();
		String strDate_company = dateFormat_company.format(date_company);
		String Company = user_company + strDate_company + timeMilli_company;
		company.sendKeys(Company);

		String user_address1 = "Home land city";
		Date date_address1 = Calendar.getInstance().getTime();
		DateFormat dateFormat_address1 = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_address1 = date_address1.getTime();
		String strDate_address1 = dateFormat_address1.format(date_address1);
		String Address1 = user_address1 + strDate_address1 + timeMilli_address1;
		addressline1.sendKeys(Address1);

		String user_address2 = "hape town";
		Date date_address2 = Calendar.getInstance().getTime();
		DateFormat dateFormat_address2 = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_address2 = date_address2.getTime();
		String strDate_address2 = dateFormat_address2.format(date_address2);
		String Address2 = user_address2 + strDate_address2 + timeMilli_address2;
		addressline2.sendKeys(Address2);

		String user_city = "delhi";
		Date date_city = Calendar.getInstance().getTime();
		DateFormat dateFormat_city = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_city = date_city.getTime();
		String strDate_city = dateFormat_city.format(date_city);
		String City = user_city + strDate_city + timeMilli_city;
		city.sendKeys(City);

		String user_province = "India";
		Date date_province = Calendar.getInstance().getTime();
		DateFormat dateFormat_province = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_province = date_province.getTime();
		String strDate_province = dateFormat_province.format(date_province);
		String Province = user_province + strDate_province + timeMilli_province;
		province.sendKeys(Province);

		String user_zip = "6546464";
		Date date_zip = Calendar.getInstance().getTime();
		DateFormat dateFormat_zip = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_zip = date_zip.getTime();
		String strDate_zip = dateFormat_zip.format(date_zip);
		String Zip = user_zip + strDate_zip + timeMilli_zip;
		zip.sendKeys(Zip);

		Select country_option = new Select(country);
		country_option.selectByVisibleText("Iceland");

		if (firstname.getAttribute("value").isEmpty())

		{
			System.out.println(errorfname.getText());
		}

		if (lastname.getAttribute("value").isEmpty()) {
			System.out.println(errorfname1.getText());
		}
		if (emailid.getAttribute("value").isEmpty()) {
			System.out.println(erroremail.getText());
		}

		if (phone.getAttribute("value").isEmpty()) {
			System.out.println(errorphone.getText());
		}

		String color = nextbutton.getCssValue("color");
		String c = Color.fromString(color).asHex();
		if (c.equals("#fa5c7c")) {
			System.out.println("Next button Not active*****verification passed");
			System.out.println("Please fill mandatory fields");
		} else {
			log.info("New Customer registered successfully");
			System.out.println("Next button Active*****verification passed");
			nextbutton.click();
			System.out.println("navigated to collect order & shipping details form ****verification passed");
			log.info("successfully navigated to collect order & shipping details form");
			System.out.println("****************************************************************************");

		}

	}

	public void order_shipping_details() {
		Assert.assertEquals(true, sales_channel.isDisplayed());
		System.out.println("Sales channel field is displayed");
		Select saleschannel_option = new Select(sales_channel);
		saleschannel_option.selectByVisibleText("SHOPIFY");

		Assert.assertEquals(true, order_type.isDisplayed());
		System.out.println("Order type field is displayed");
		Select ordertype_option = new Select(order_type);
		ordertype_option.selectByVisibleText("Type1");

		Assert.assertEquals(true, order_status.isDisplayed());
		System.out.println("Order status field is displayed");
		Select orderstatus_option = new Select(order_status);
		orderstatus_option.selectByVisibleText("Confirmed");

		Assert.assertEquals(true, fullfilement_center.isDisplayed());
		System.out.println("Fullfilement center field is displayed");
		Select fillfilmentercenter_option = new Select(fullfilement_center);
		fillfilmentercenter_option.selectByVisibleText("Chennai");

		Assert.assertEquals(true, fullfilement_status.isDisplayed());
		System.out.println("Fullfilement status field is displayed");
		Select fillfilmentstatus_option = new Select(fullfilement_status);
		fillfilmentstatus_option.selectByVisibleText("FULFILLED");

		Assert.assertEquals(true, ordercreation_date.isDisplayed());
		System.out.println("Order creation date field is displayed");
		ordercreation_date.sendKeys("08-04-2022");

		Assert.assertEquals(true, delivery_date.isDisplayed());
		System.out.println("Delivery date field is displayed");
		delivery_date.sendKeys("28-04-2022");

		Assert.assertEquals(true, order_currency.isDisplayed());
		System.out.println("Order currency field is displayed");
		Select Ordercurrency_option = new Select(order_currency);
		Ordercurrency_option.selectByVisibleText("India Rupees – INR");

		Assert.assertEquals(true, shipping_charge.isDisplayed());
		System.out.println("Shipping charge field is displayed");
		shipping_charge.sendKeys("50");
		System.out.println("****************************************************************");

		WebElement saleschannel = saleschannel_option.getFirstSelectedOption();
		String saleschannel_string = saleschannel.getText();
		if (saleschannel_string.contains("Please select a Sales Channel")) {
			System.out.println("****Please fill mandatory fields");
			System.out.println(sales_chanel_error.getText());
		}

		WebElement fullfilmentcenter_opt = fillfilmentercenter_option.getFirstSelectedOption();
		String fullfilmentcenter_string = fullfilmentcenter_opt.getText();
		if (fullfilmentcenter_string.contains("Fullfilment Center *")) {
			System.out.println(fullfilment_center_error.getText());
		}

		WebElement fullfilmentstatus_opt = fillfilmentstatus_option.getFirstSelectedOption();
		String fullfilmentstatus_string = fullfilmentstatus_opt.getText();
		if (fullfilmentstatus_string.contains("Fullfilment Status *")) {
			System.out.println(fullfilment_status_error.getText());
		}

		WebElement ordercurrency_opt = Ordercurrency_option.getFirstSelectedOption();
		String ordercurrency_string = ordercurrency_opt.getText();
		if (ordercurrency_string.contains("Select Order Currency")) {
			System.out.println(order_currency_error.getText());
		}

		System.out.println("****************************************************************");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);
		Assert.assertEquals(true, require_shipping.isDisplayed());
		System.out.println("requare shipping is displayed");
		require_shipping_option1.click();

		billing_address.click();
		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);

		if (honorific_shipping.isEnabled() && name_shipping.isEnabled() && company_shipping.isEnabled()
				&& addressline1_shipping.isEnabled() && addressline2_shipping.isEnabled() && city_shipping.isEnabled()
				&& zip_shipping.isEnabled() && province_shipping.isEnabled() && country_shipping.isEnabled()) {

			Select select1 = new Select(honorific_billing);
			WebElement honorific_billing_option = select1.getFirstSelectedOption();
			Select select = new Select(honorific_shipping);
			WebElement honorific_shipping_option = select.getFirstSelectedOption();
			String expected_honorific_tittle = honorific_billing_option.getText();
			String actual_honorific_shipping_tittle = honorific_shipping_option.getText();
			Assert.assertEquals(expected_honorific_tittle, actual_honorific_shipping_tittle);

			String expected_name_tittle = firstname.getText() + lastname.getText();
			String actual_name_tittle = name_shipping.getText();
			Assert.assertEquals(expected_name_tittle, actual_name_tittle);

			String expected_company_tittle = company.getText();
			String actual_company_shipping_tittle = company_shipping.getText();
			Assert.assertEquals(expected_company_tittle, actual_company_shipping_tittle);

			String expected_addressline1_tittle = addressline1.getText();
			String actual_addressline1_shipping_tittle = addressline1_shipping.getText();
			Assert.assertEquals(expected_addressline1_tittle, actual_addressline1_shipping_tittle);

			String expected_addressline2_tittle = addressline2.getText();
			String actual_addressline2_shipping_tittle = addressline2_shipping.getText();
			Assert.assertEquals(expected_addressline2_tittle, actual_addressline2_shipping_tittle);

			String expected_city_tittle = city.getText();
			String actual_city_shipping_tittle = city_shipping.getText();
			Assert.assertEquals(expected_city_tittle, actual_city_shipping_tittle);

			String expected_zip_tittle = zip.getText();
			String actual_zip_shipping_tittle = zip_shipping.getText();
			Assert.assertEquals(expected_zip_tittle, actual_zip_shipping_tittle);

			String expected_province_tittle = province.getText();
			String actual_province_shipping_tittle = province_shipping.getText();
			Assert.assertEquals(expected_province_tittle, actual_province_shipping_tittle);

			String expected_country_tittle = country.getText();
			String actual_country_shipping_tittle = country_shipping.getText();
			Assert.assertEquals(expected_country_tittle, actual_country_shipping_tittle);

			System.out.println("Billing address is same as shipping address and it's editable");
		} else {
			System.out.println("Billing address is same as shipping address and it's Not editable");
		}

		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);
		String color_order_shpping = nextbutton_order_shipping.getCssValue("color");
		String c_order_shipping = Color.fromString(color_order_shpping).asHex();

		if (c_order_shipping.equals("#fa5c7c")) {
			System.out.println("Next button Not active");
			System.out.println("Please fill mandatory fields*****verification passed");
		} else {
			log.info("Order and shipping details successfully added");
			System.out.println("Next button Active");
			nextbutton_order_shipping.click();
			System.out.println("navigated to LINE ITEM form ****verification passed");
			log.info("successfully navigated to LINE ITEM form");
			System.out.println("****************************************************************************");

		}

	}

	public void line_items() {
		add_lineitem.click();
		sku.click();
		sku_option1.click();
		String description_data = longname.getAttribute("value");
		System.out.println("Line Item");
		System.out.println("Item name=" + longname.getAttribute("value"));
		description.click();
		description.sendKeys(description_data);
		quantity.sendKeys("150");
		tax.sendKeys("50");
		skuid.click();
		total.click();

		wait = new WebDriverWait(driver, 50);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", total);
		System.out.println("Sub Total=" + subtotal.getText());
		System.out.println("Total=" + total.getAttribute("value"));
		total.click();

		if (longname.getAttribute("value").isEmpty())

		{
			System.out.println(error_longname.getText());
		}
		if (shortname.getAttribute("value").isEmpty())

		{
			System.out.println(error_shortname.getText());
		}
		if (unit.getAttribute("value").isEmpty())

		{
			System.out.println(error_unit.getText());
		}
		if (uom.getAttribute("value").isEmpty())

		{
			System.out.println(error_uom.getText());
		}
		if (price.getAttribute("value").isEmpty())

		{
			System.out.println(error_price.getText());
		}
		if (quantity.getAttribute("value").isEmpty())

		{
			System.out.println(error_quantity.getText());

		}
		if (skuid.getAttribute("value").isEmpty())

		{
			System.out.println(error_skuid.getText());
		}

		additem.click();
		sku.click();
		sku_option2.click();
		String description_data1 = longname.getAttribute("value");
		System.out.println("Line Item");
		System.out.println("Item name=" + longname.getAttribute("value"));
		description.click();
		description.sendKeys(description_data1);
		quantity.sendKeys("250");
		tax.sendKeys("60");
		skuid.click();
		total.click();

		wait = new WebDriverWait(driver, 50);
		js.executeScript("arguments[0].scrollIntoView();", total);
		System.out.println("Sub Total=" + subtotal.getText());
		System.out.println("Total=" + total.getAttribute("value"));
		total.click();

		if (longname.getAttribute("value").isEmpty())

		{
			System.out.println(error_longname.getText());
		}
		if (shortname.getAttribute("value").isEmpty())

		{
			System.out.println(error_shortname.getText());
		}
		if (unit.getAttribute("value").isEmpty())

		{
			System.out.println(error_unit.getText());
		}
		if (uom.getAttribute("value").isEmpty())

		{
			System.out.println(error_uom.getText());
		}
		if (price.getAttribute("value").isEmpty())

		{
			System.out.println(error_price.getText());
		}
		if (quantity.getAttribute("value").isEmpty())

		{
			System.out.println(error_quantity.getText());

		}
		if (skuid.getAttribute("value").isEmpty())

		{
			System.out.println(error_skuid.getText());
		}
		additem.click();
		close.click();
		System.out.println("Item added to item list");
		log.info("line item successfully added to item list");
		System.out.println();
		System.out.println("Total Item List:");
		System.out.println(itemlist.getText());
		log.info(itemlist.getText());
		System.out.println("****************************************************************************");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement edit = wait.until((ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class=\"mdi mdi-pencil-circle-outline mdi-24px text-primary\"]"))));
		edit.click();
		Assert.assertEquals(true, edit.isDisplayed());
		System.out.println("Edit line item option is displayed");
		log.info("line item edit option is displayed");
		WebElement taxamount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"taxAmount\"]"))));
		taxamount.sendKeys("500");

		WebElement total = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"total\"]"))));
		js.executeScript("arguments[0].scrollIntoView();", total);
		total.click();

		WebElement additem_edit = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Add Item\"]"))));
		additem_edit.click();

		WebElement closeitem_edit = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Close\"]"))));
		closeitem_edit.click();
		System.out.println("successfully updated item details");
		log.info("line item details updated successfully");
		System.out.println("****************************************************************************");

		WebElement remove = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[2]/div/table/tbody/tr[1]/td[11]/span/span"))));
		remove.click();
		System.out.println("Item removed from item list");
		log.info("line item removed from item list successfully");
		System.out.println("****************************************************************************");

		WebElement percentage = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderDiscountRate\"]"))));
		percentage.sendKeys("20");

		WebElement edit_orderdetails = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[7]/div/div[1]/div[2]/span"))));
		edit_orderdetails.click();

		WebElement sub_total = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderSubTotal\"]"))));
		js.executeScript("arguments[0].scrollIntoView();", sub_total);
		sub_total.click();
		String subtotal_total = sub_total.getAttribute("value");
		System.out.println("Sub Total=" + subtotal_total);

		WebElement total_discount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTotalDiscount\"]"))));
		String total_discount_total = total_discount.getAttribute("value");
		System.out.println("Total Discount=" + total_discount_total);

		WebElement tax_rate = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTaxRate\"]"))));
		tax_rate.sendKeys("1.3");

		WebElement total_tax = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTaxTotal\"]"))));
		total_tax.click();
		String total_tax_total = total_tax.getAttribute("value");
		System.out.println("Tax Total=" + total_tax_total);

		WebElement shipping_charge = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"float-right mr-2\"]"))));
		String total_shipping_charge = shipping_charge.getText();
		System.out.println("Shipping charge=" + total_shipping_charge);

		System.out.println("Total Amount= Sub Total-Total Discount+Total Tax+Shipping charge");
		System.out.println(
				subtotal_total + "-" + total_discount_total + "+" + total_tax_total + "+" + total_shipping_charge);
		WebElement total_amount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTotal\"]"))));
		total_amount.click();
		String total_amount_total = total_amount.getAttribute("value");
		System.out.println("Total=" + total_amount_total);
		System.out.println();
		WebElement previous_lineitem = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[8]/div[2]/button/span"))));
		previous_lineitem.click();
		nextbutton_order_shipping.click();
		System.out.println("editing data is possible when previous button is clicked");
		js.executeScript("arguments[0].scrollIntoView();", sub_total);
		sub_total.click();
		if (sub_total.isEnabled() && total_discount.isEnabled() && total_tax.isEnabled() && total_amount.isEnabled()) {
			System.out.println("**user able to edit data before creating an order");
			System.out.println("**Total considered as TOTAL AMOUNT OF ORDER");
		} else {
			System.out.println("The fields are not editable");
		}

		WebElement next_button_lineitem = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[8]/div[1]/button"))));
		String color_line_item = next_button_lineitem.getCssValue("color");
		String c_line_item = Color.fromString(color_line_item).asHex();
		if (c_line_item.equals("#fa5c7c")) {
			System.out.println("Next button Not active");
			System.out.println("**********Please add line item");
		} else {
			System.out.println("Next button Active");
			next_button_lineitem.click();
			System.out.println("navigated to PAYMENT DETAILS form ****verification passed");
			log.info("successfully navigated to PAYMENT DETAILS form");
			System.out.println("****************************************************************************");

		}
	}

	public void payment_details() {
		WebElement payment_status = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"financialStatus\"]"))));
		Assert.assertEquals(true, payment_status.isDisplayed());
		System.out.println("Payment status field is displayed");
		Select payment_status_option = new Select(payment_status);
		payment_status_option.selectByVisibleText("PAID");

		WebElement payment_status_dis = payment_status_option.getFirstSelectedOption();
		String payment_status_display = payment_status_dis.getText();
		System.out.println("Payment status  " + payment_status_display + "  selected");

		if (payment_status_option.isMultiple()) {
			payment_status_option.selectByVisibleText("PAID");
			payment_status_option.selectByVisibleText("PARTIALLY_PAID");
			payment_status_option.selectByVisibleText("PENDING");
		}

		else {
			System.out.println("***Multiple selection not possible");
		}

		WebElement payment_method = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentMethod\"]"))));
		Assert.assertEquals(true, payment_method.isDisplayed());
		System.out.println("Payment method field is displayed");
		Select payment_method_option = new Select(payment_method);
		payment_method_option.selectByVisibleText("Check");

		WebElement payment_method_dis = payment_method_option.getFirstSelectedOption();
		String payment_method_display = payment_method_dis.getText();
		System.out.println("Payment method  " + payment_method_display + "  selected");

		if (payment_method_option.isMultiple()) {
			payment_method_option.selectByVisibleText("Check");
			payment_method_option.selectByVisibleText("Cash");
		} else {
			System.out.println("***Multiple selection not possible");
		}

		WebElement method_check = payment_method_option.getFirstSelectedOption();
		String pay_method_check = method_check.getText();
		if (pay_method_check.contains("Check")) {
			System.out.println("cheque payment method selected");
			log.info(" payment method selected by cheque");
			System.out.println("***There are no options to enter future payment details");
			log.error("There are no options to enter future payment details");
		}

		WebElement method_card = payment_method_option.getFirstSelectedOption();
		String pay_method_card = method_card.getText();
		if (pay_method_card.contains("Credit/ Debit card")) {
			System.out.println("Credit/ Debit card payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement method_googlepay = payment_method_option.getFirstSelectedOption();
		String pay_method_googlepay = method_googlepay.getText();
		if (pay_method_googlepay.contains("google pay/phone pay")) {
			System.out.println("google pay/phone pay payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement status_pending = payment_status_option.getFirstSelectedOption();
		String status_pending_notify = status_pending.getText();
		if (status_pending_notify.contains("PENDING")) {
			System.out.println("Payment status PENDING selected");
			System.out.println("***No notification given total amount considered as pending");
		}
		if (status_pending_notify.contains("PARTIALLY_PAID")) {
			WebElement collected_amount = wait
					.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"collectedPayment\"]"))));
			collected_amount.sendKeys("10000");
			System.out.println("Collected amount=" + collected_amount.getAttribute("value"));
			WebElement pending_amount = wait
					.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pendingPayment\"]"))));
			pending_amount.click();
			System.out.println("Pending amount=" + pending_amount.getAttribute("value"));
			System.out.println("***Pending amount auto calculated");

		}

		WebElement next_payment = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[4]/app-payment/div/div/form/div[2]/div[1]/button/span"))));
		next_payment.click();
		System.out.println("navigated to ORDER SUMMARY form ****verification passed");
		log.info("successfully navigated to ORDER SUMMARY form");
		System.out.println("****************************************************************************");
	}

	public void order_summery() {

		WebElement order_creation_date_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[1]/span"))));
		Assert.assertEquals(true, order_creation_date_summery.isDisplayed());
		System.out.println("Order creation date:  " + order_creation_date_summery.getText());

		WebElement currency_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[2]/span"))));
		Assert.assertEquals(true, currency_summery.isDisplayed());
		System.out.println("Currency:  " + currency_summery.getText());

		WebElement sales_channel_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/span"))));
		Assert.assertEquals(true, sales_channel_summery.isDisplayed());
		System.out.println("Sales channel:  " + sales_channel_summery.getText());

		WebElement payment_status_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[3]/span"))));
		Assert.assertEquals(true, payment_status_summery.isDisplayed());
		System.out.println("Payment status:  " + payment_status_summery.getText());

		WebElement line_item_inserted_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[2]/div/div/div[1]/strong"))));
		Assert.assertEquals(true, line_item_inserted_summery.isDisplayed());
		System.out.println("Line item:  " + line_item_inserted_summery.getText());

		WebElement shipping_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[4]"))));
		Assert.assertEquals(true, shipping_total_summery.isDisplayed());
		System.out.println(shipping_total_summery.getText());

		WebElement tax_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[3]"))));
		Assert.assertEquals(true, tax_total_summery.isDisplayed());
		System.out.println(tax_total_summery.getText());

		WebElement subtotal_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[1]/div[3]"))));
		Assert.assertEquals(true, subtotal_summery.isDisplayed());
		System.out.println("Sub Total=:  " + subtotal_summery.getText());

		WebElement order_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[2]/div/div[1]"))));
		Assert.assertEquals(true, order_total_summery.isDisplayed());
		System.out.println(order_total_summery.getText());

		WebElement outstanding = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[2]/div/div[2]"))));
		Assert.assertEquals(true, outstanding.isDisplayed());
		System.out.println(outstanding.getText());

		log.info("Order creation date:  " + order_creation_date_summery.getText(),
				"Currency:  " + currency_summery.getText(), "Sales channel:  " + sales_channel_summery.getText(),
				"Payment status:  " + payment_status_summery.getText(),
				"Line item:  " + line_item_inserted_summery.getText(),
				"Line item:  " + line_item_inserted_summery.getText(), shipping_total_summery.getText(),
				tax_total_summery.getText(), "Sub Total=:  " + subtotal_summery.getText(),
				order_total_summery.getText(), outstanding.getText());
		
		System.out.println("Order creation date field is displayed");
		System.out.println("Currency field is displayed");
		System.out.println("Sales channel field is displayed");
		System.out.println("Payment status is displayed");
		System.out.println("Line item is displayed");
		System.out.println("Shipping total is displayed");
		System.out.println("Total summery is displayed");
		System.out.println("Sub Total is displayed");
		System.out.println("Order total is displayed");

		WebElement create = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[4]/div[2]/button/span"))));
		Assert.assertEquals(true, create.isDisplayed());
		create.click();
		System.out.println("Create button displayed");
		System.out.println("ORDER CREATED *****navigated to ORDER STATUS page");
		log.info("Order created successfully");
		log.info("successfully navigated to ORDER STATUS page");
		System.out.println("****************************************************************************");

	}

	public void order_status() {
		WebElement order_number = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[3]/div/h2"))));
		Assert.assertEquals(true, order_number.isDisplayed());
		System.out.println("order number displayed");
		System.out.println(order_number.getText());
		log.info("Order number:"+order_number.getText());
		WebElement create_new_order = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[5]/div/div/div[1]/button"))));
		Assert.assertEquals(true, create_new_order.isDisplayed());
		System.out.println("create new order button displayed");
		create_new_order.click();
		System.out.println("*****navigated to order creation page");
		log.info("create new order button displayed and successfully navigated to order creation page");

		Select honorifi_option = new Select(honorific);
		honorifi_option.selectByVisibleText("Mr");
		firstname.sendKeys("Asish");

		String last_name = "Babu";
		Date date_name = Calendar.getInstance().getTime();
		DateFormat dateFormat_name = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_name = date_name.getTime();
		String strDate_name = dateFormat_name.format(date_name);
		String Name = last_name + strDate_name + timeMilli_name;
		lastname.sendKeys(Name);

		emailid.sendKeys("asishhhh@gmail.com");
		phone.sendKeys("65745353554");
		vatnumber.sendKeys("656678");
		channeladdressid.sendKeys("002");

		String user_company = "Testhouse";
		Date date_company = Calendar.getInstance().getTime();
		DateFormat dateFormat_company = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_company = date_company.getTime();
		String strDate_company = dateFormat_company.format(date_company);
		String Company = user_company + strDate_company + timeMilli_company;
		company.sendKeys(Company);

		String user_address1 = "Home land city";
		Date date_address1 = Calendar.getInstance().getTime();
		DateFormat dateFormat_address1 = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_address1 = date_address1.getTime();
		String strDate_address1 = dateFormat_address1.format(date_address1);
		String Address1 = user_address1 + strDate_address1 + timeMilli_address1;
		addressline1.sendKeys(Address1);

		String user_address2 = "hape town";
		Date date_address2 = Calendar.getInstance().getTime();
		DateFormat dateFormat_address2 = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_address2 = date_address2.getTime();
		String strDate_address2 = dateFormat_address2.format(date_address2);
		String Address2 = user_address2 + strDate_address2 + timeMilli_address2;
		addressline2.sendKeys(Address2);

		String user_city = "delhi";
		Date date_city = Calendar.getInstance().getTime();
		DateFormat dateFormat_city = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_city = date_city.getTime();
		String strDate_city = dateFormat_city.format(date_city);
		String City = user_city + strDate_city + timeMilli_city;
		city.sendKeys(City);

		String user_province = "India";
		Date date_province = Calendar.getInstance().getTime();
		DateFormat dateFormat_province = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_province = date_province.getTime();
		String strDate_province = dateFormat_province.format(date_province);
		String Province = user_province + strDate_province + timeMilli_province;
		province.sendKeys(Province);

		String user_zip = "6542344";
		Date date_zip = Calendar.getInstance().getTime();
		DateFormat dateFormat_zip = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli_zip = date_zip.getTime();
		String strDate_zip = dateFormat_zip.format(date_zip);
		String Zip = user_zip + strDate_zip + timeMilli_zip;
		zip.sendKeys(Zip);

		Select country_option = new Select(country);
		country_option.selectByVisibleText("India");

		if (firstname.getAttribute("value").isEmpty())

		{
			System.out.println(errorfname.getText());
		}

		if (lastname.getAttribute("value").isEmpty()) {
			System.out.println("Lastname requared warning message is not displayed!!!!!****verification failed");
		}
		if (emailid.getAttribute("value").isEmpty()) {
			System.out.println(erroremail.getText());
		}

		if (phone.getAttribute("value").isEmpty()) {
			System.out.println(errorphone.getText());
		}

		String color = nextbutton.getCssValue("color");
		String c = Color.fromString(color).asHex();
		if (c.equals("#fa5c7c")) {
			System.out.println("Next button Not active*****verification passed");
			System.out.println("Please fill mandatory fields");
		} else {
			System.out.println("Next button Active*****verification passed");
			nextbutton.click();
			System.out.println("navigated to collect order & shipping details form ****verification passed");
			System.out.println("****************************************************************************");

		}

		Assert.assertEquals(true, sales_channel.isDisplayed());
		System.out.println("Sales channel field is displayed");
		Select saleschannel_option = new Select(sales_channel);
		saleschannel_option.selectByVisibleText("Storicart E-Commerce_SIT");

		Assert.assertEquals(true, order_type.isDisplayed());
		System.out.println("Order type field is displayed");
		Select ordertype_option = new Select(order_type);
		ordertype_option.selectByVisibleText("Type2");

		Assert.assertEquals(true, order_status.isDisplayed());
		System.out.println("Order status field is displayed");
		Select orderstatus_option = new Select(order_status);
		orderstatus_option.selectByVisibleText("Packing Process");

		Assert.assertEquals(true, fullfilement_center.isDisplayed());
		System.out.println("Fullfilement center field is displayed");
		Select fillfilmentercenter_option = new Select(fullfilement_center);
		fillfilmentercenter_option.selectByVisibleText("Palakkad");

		Assert.assertEquals(true, fullfilement_status.isDisplayed());
		System.out.println("Fullfilement status field is displayed");
		Select fillfilmentstatus_option = new Select(fullfilement_status);
		fillfilmentstatus_option.selectByVisibleText("UNFULFILLED");

		Assert.assertEquals(true, ordercreation_date.isDisplayed());
		System.out.println("Order creation date field is displayed");
		ordercreation_date.sendKeys("16-04-2022");

		Assert.assertEquals(true, delivery_date.isDisplayed());
		System.out.println("Delivery date field is displayed");
		delivery_date.sendKeys("29-04-2022");

		Assert.assertEquals(true, order_currency.isDisplayed());
		System.out.println("Order currency field is displayed");
		Select Ordercurrency_option = new Select(order_currency);
		Ordercurrency_option.selectByVisibleText("India Rupees – INR");

		Assert.assertEquals(true, shipping_charge.isDisplayed());
		System.out.println("Shipping charge field is displayed");
		shipping_charge.sendKeys("60");
		System.out.println("****************************************************************");

		WebElement saleschannel = saleschannel_option.getFirstSelectedOption();
		String saleschannel_string = saleschannel.getText();
		if (saleschannel_string.contains("Please select a Sales Channel")) {
			System.out.println("****Please fill mandatory fields");
			System.out.println(sales_chanel_error.getText());
		}

		WebElement fullfilmentcenter_opt = fillfilmentercenter_option.getFirstSelectedOption();
		String fullfilmentcenter_string = fullfilmentcenter_opt.getText();
		if (fullfilmentcenter_string.contains("Fullfilment Center *")) {
			System.out.println(fullfilment_center_error.getText());
		}

		WebElement fullfilmentstatus_opt = fillfilmentstatus_option.getFirstSelectedOption();
		String fullfilmentstatus_string = fullfilmentstatus_opt.getText();
		if (fullfilmentstatus_string.contains("Fullfilment Status *")) {
			System.out.println(fullfilment_status_error.getText());
		}

		WebElement ordercurrency_opt = Ordercurrency_option.getFirstSelectedOption();
		String ordercurrency_string = ordercurrency_opt.getText();
		if (ordercurrency_string.contains("Select Order Currency")) {
			System.out.println(order_currency_error.getText());
		}

		System.out.println("****************************************************************");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);
		Assert.assertEquals(true, require_shipping.isDisplayed());
		System.out.println("requare shipping is displayed");
		require_shipping_option1.click();

		billing_address.click();
		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);

		if (honorific_shipping.isEnabled() && name_shipping.isEnabled() && company_shipping.isEnabled()
				&& addressline1_shipping.isEnabled() && addressline2_shipping.isEnabled() && city_shipping.isEnabled()
				&& zip_shipping.isEnabled() && province_shipping.isEnabled() && country_shipping.isEnabled()) {

			Select select1 = new Select(honorific_billing);
			WebElement honorific_billing_option = select1.getFirstSelectedOption();
			Select select = new Select(honorific_shipping);
			WebElement honorific_shipping_option = select.getFirstSelectedOption();
			String expected_honorific_tittle = honorific_billing_option.getText();
			String actual_honorific_shipping_tittle = honorific_shipping_option.getText();
			Assert.assertEquals(expected_honorific_tittle, actual_honorific_shipping_tittle);

			String expected_name_tittle = firstname.getText() + lastname.getText();
			String actual_name_tittle = name_shipping.getText();
			Assert.assertEquals(expected_name_tittle, actual_name_tittle);

			String expected_company_tittle = company.getText();
			String actual_company_shipping_tittle = company_shipping.getText();
			Assert.assertEquals(expected_company_tittle, actual_company_shipping_tittle);

			String expected_addressline1_tittle = addressline1.getText();
			String actual_addressline1_shipping_tittle = addressline1_shipping.getText();
			Assert.assertEquals(expected_addressline1_tittle, actual_addressline1_shipping_tittle);

			String expected_addressline2_tittle = addressline2.getText();
			String actual_addressline2_shipping_tittle = addressline2_shipping.getText();
			Assert.assertEquals(expected_addressline2_tittle, actual_addressline2_shipping_tittle);

			String expected_city_tittle = city.getText();
			String actual_city_shipping_tittle = city_shipping.getText();
			Assert.assertEquals(expected_city_tittle, actual_city_shipping_tittle);

			String expected_zip_tittle = zip.getText();
			String actual_zip_shipping_tittle = zip_shipping.getText();
			Assert.assertEquals(expected_zip_tittle, actual_zip_shipping_tittle);

			String expected_province_tittle = province.getText();
			String actual_province_shipping_tittle = province_shipping.getText();
			Assert.assertEquals(expected_province_tittle, actual_province_shipping_tittle);

			String expected_country_tittle = country.getText();
			String actual_country_shipping_tittle = country_shipping.getText();
			Assert.assertEquals(expected_country_tittle, actual_country_shipping_tittle);

			System.out.println("Billing address is same as shipping address and it's editable");
		} else {
			System.out.println("Billing address is same as shipping address and it's Not editable");
		}

		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);
		String color_order_shpping = nextbutton_order_shipping.getCssValue("color");
		String c_order_shipping = Color.fromString(color_order_shpping).asHex();

		if (c_order_shipping.equals("#fa5c7c")) {
			System.out.println("Next button Not active");
			System.out.println("Please fill mandatory fields*****verification passed");
		} else {
			System.out.println("Next button Active");
			nextbutton_order_shipping.click();
			System.out.println("navigated to LINE ITEM form ****verification passed");
			System.out.println("****************************************************************************");

		}

		add_lineitem.click();
		sku.click();
		sku_option2.click();
		String description_data = longname.getAttribute("value");
		System.out.println("Line Item");
		System.out.println("Item name=" + longname.getAttribute("value"));
		description.click();
		description.sendKeys(description_data);
		quantity.sendKeys("250");
		tax.sendKeys("70");

		skuid.click();
		total.click();

		wait = new WebDriverWait(driver, 50);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", total);
		System.out.println("Sub Total=" + subtotal.getText());
		System.out.println("Total=" + total.getAttribute("value"));
		total.click();

		if (longname.getAttribute("value").isEmpty())

		{
			System.out.println(error_longname.getText());
		}
		if (shortname.getAttribute("value").isEmpty())

		{
			System.out.println(error_shortname.getText());
		}
		if (unit.getAttribute("value").isEmpty())

		{
			System.out.println(error_unit.getText());
		}
		if (uom.getAttribute("value").isEmpty())

		{
			System.out.println(error_uom.getText());
		}
		if (price.getAttribute("value").isEmpty())

		{
			System.out.println(error_price.getText());
		}
		if (quantity.getAttribute("value").isEmpty())

		{
			System.out.println(error_quantity.getText());

		}
		if (skuid.getAttribute("value").isEmpty())

		{
			System.out.println(error_skuid.getText());
		}

		additem.click();
		sku.click();
		sku_option3.click();
		String description_data1 = longname.getAttribute("value");
		System.out.println("Line Item");
		System.out.println("Item name=" + longname.getAttribute("value"));
		description.click();
		description.sendKeys(description_data1);
		quantity.sendKeys("170");
		tax.sendKeys("60");

		skuid.click();
		total.click();

		wait = new WebDriverWait(driver, 50);
		js.executeScript("arguments[0].scrollIntoView();", total);
		System.out.println("Sub Total=" + subtotal.getText());
		System.out.println("Total=" + total.getAttribute("value"));
		total.click();

		if (longname.getAttribute("value").isEmpty())

		{
			System.out.println(error_longname.getText());
		}
		if (shortname.getAttribute("value").isEmpty())

		{
			System.out.println(error_shortname.getText());
		}
		if (unit.getAttribute("value").isEmpty())

		{
			System.out.println(error_unit.getText());
		}
		if (uom.getAttribute("value").isEmpty())

		{
			System.out.println(error_uom.getText());
		}
		if (price.getAttribute("value").isEmpty())

		{
			System.out.println(error_price.getText());
		}
		if (quantity.getAttribute("value").isEmpty())

		{
			System.out.println(error_quantity.getText());

		}
		if (skuid.getAttribute("value").isEmpty())

		{
			System.out.println(error_skuid.getText());
		}
		additem.click();
		close.click();
		System.out.println("Item added to item list");
		System.out.println();
		System.out.println("Total Item List:");
		System.out.println(itemlist.getText());
		System.out.println("****************************************************************************");

		wait = new WebDriverWait(driver, 30);
		WebElement edit = wait.until((ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class=\"mdi mdi-pencil-circle-outline mdi-24px text-primary\"]"))));
		edit.click();
		Assert.assertEquals(true, edit.isDisplayed());
		System.out.println("Edit line item option is displayed");

		WebElement taxamount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"taxAmount\"]"))));
		taxamount.sendKeys("500");

		WebElement total = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"total\"]"))));
		js.executeScript("arguments[0].scrollIntoView();", total);
		total.click();

		WebElement additem_edit = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Add Item\"]"))));
		additem_edit.click();

		WebElement closeitem_edit = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Close\"]"))));
		closeitem_edit.click();
		System.out.println("successfully updated item details");
		System.out.println("****************************************************************************");

		WebElement remove = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[2]/div/table/tbody/tr[1]/td[11]/span/span"))));
		remove.click();
		System.out.println("Item removed from item list");
		System.out.println("****************************************************************************");

		WebElement percentage = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderDiscountRate\"]"))));
		percentage.sendKeys("20");

		WebElement edit_orderdetails = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[7]/div/div[1]/div[2]/span"))));
		edit_orderdetails.click();

		WebElement sub_total = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderSubTotal\"]"))));
		js.executeScript("arguments[0].scrollIntoView();", sub_total);
		sub_total.click();
		String subtotal_total = sub_total.getAttribute("value");
		System.out.println("Sub Total=" + subtotal_total);

		WebElement total_discount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTotalDiscount\"]"))));
		String total_discount_total = total_discount.getAttribute("value");
		System.out.println("Total Discount=" + total_discount_total);

		WebElement tax_rate = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTaxRate\"]"))));
		tax_rate.sendKeys("1.3");

		WebElement total_tax = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTaxTotal\"]"))));
		total_tax.click();
		String total_tax_total = total_tax.getAttribute("value");
		System.out.println("Tax Total=" + total_tax_total);

		WebElement shipping_charge = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"float-right mr-2\"]"))));
		String total_shipping_charge = shipping_charge.getText();
		System.out.println("Shipping charge=" + total_shipping_charge);

		System.out.println("Total Amount= Sub Total-Total Discount+Total Tax+Shipping charge");
		System.out.println(
				subtotal_total + "-" + total_discount_total + "+" + total_tax_total + "+" + total_shipping_charge);
		WebElement total_amount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTotal\"]"))));
		total_amount.click();
		String total_amount_total = total_amount.getAttribute("value");
		System.out.println("Total=" + total_amount_total);
		System.out.println();
		WebElement previous_lineitem = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[8]/div[2]/button/span"))));
		previous_lineitem.click();
		nextbutton_order_shipping.click();
		System.out.println("editing data is possible when previous button is clicked");
		js.executeScript("arguments[0].scrollIntoView();", sub_total);
		sub_total.click();
		if (sub_total.isEnabled() && total_discount.isEnabled() && total_tax.isEnabled() && total_amount.isEnabled()) {
			System.out.println("**user able to edit data before creating an order");
			System.out.println("**Total considered as TOTAL AMOUNT OF ORDER");
		} else {
			System.out.println("The fields are not editable");
		}

		WebElement next_button_lineitem = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[8]/div[1]/button"))));
		String color_line_item = next_button_lineitem.getCssValue("color");
		String c_line_item = Color.fromString(color_line_item).asHex();
		if (c_line_item.equals("#fa5c7c")) {
			System.out.println("Next button Not active");
			System.out.println("**********Please add line item");
		} else {
			System.out.println("Next button Active");
			next_button_lineitem.click();
			System.out.println("navigated to PAYMENT DETAILS form ****verification passed");
			System.out.println("****************************************************************************");

		}
		WebElement payment_status = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"financialStatus\"]"))));
		Assert.assertEquals(true, payment_status.isDisplayed());
		System.out.println("Payment status field is displayed");
		Select payment_status_option = new Select(payment_status);
		payment_status_option.selectByVisibleText("PAID");

		WebElement payment_status_dis = payment_status_option.getFirstSelectedOption();
		String payment_status_display = payment_status_dis.getText();
		System.out.println("Payment status  " + payment_status_display + "  selected");

		if (payment_status_option.isMultiple()) {
			payment_status_option.selectByVisibleText("PAID");
			payment_status_option.selectByVisibleText("PARTIALLY_PAID");
			payment_status_option.selectByVisibleText("PENDING");
		} else {
			System.out.println("***Multiple selection not possible");
		}

		WebElement payment_method = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentMethod\"]"))));
		Assert.assertEquals(true, payment_method.isDisplayed());
		System.out.println("Payment method field is displayed");
		Select payment_method_option = new Select(payment_method);
		payment_method_option.selectByVisibleText("Check");

		WebElement payment_method_dis = payment_method_option.getFirstSelectedOption();
		String payment_method_display = payment_method_dis.getText();
		System.out.println("Payment method  " + payment_method_display + "  selected");

		if (payment_method_option.isMultiple()) {
			payment_method_option.selectByVisibleText("Check");
			payment_method_option.selectByVisibleText("Cash");
		} else {
			System.out.println("***Multiple selection not possible");
		}

		WebElement method_check = payment_method_option.getFirstSelectedOption();
		String pay_method_check = method_check.getText();
		if (pay_method_check.contains("Check")) {
			System.out.println("Check payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement method_card = payment_method_option.getFirstSelectedOption();
		String pay_method_card = method_card.getText();
		if (pay_method_card.contains("Credit/ Debit card")) {
			System.out.println("Credit/ Debit card payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement method_googlepay = payment_method_option.getFirstSelectedOption();
		String pay_method_googlepay = method_googlepay.getText();
		if (pay_method_googlepay.contains("google pay/phone pay")) {
			System.out.println("google pay/phone pay payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement status_pending = payment_status_option.getFirstSelectedOption();
		String status_pending_notify = status_pending.getText();
		if (status_pending_notify.contains("PENDING")) {
			System.out.println("Payment status PENDING selected");
			System.out.println("***No notification given total amount considered as pending");
		}
		if (status_pending_notify.contains("PARTIALLY_PAID")) {
			WebElement collected_amount = wait
					.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"collectedPayment\"]"))));
			collected_amount.sendKeys("20000");
			System.out.println("Collected amount=" + collected_amount.getAttribute("value"));
			WebElement pending_amount = wait
					.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pendingPayment\"]"))));
			pending_amount.click();
			System.out.println("Pending amount=" + pending_amount.getAttribute("value"));
			System.out.println("***Pending amount auto calculated");

		}

		WebElement next_payment = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[4]/app-payment/div/div/form/div[2]/div[1]/button/span"))));
		next_payment.click();
		System.out.println("navigated to ORDER SUMMARY form ****verification passed");
		System.out.println("****************************************************************************");

		WebElement order_creation_date_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[1]/span"))));
		Assert.assertEquals(true, order_creation_date_summery.isDisplayed());
		System.out.println("Order creation date:  " + order_creation_date_summery.getText());

		WebElement currency_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[2]/span"))));
		Assert.assertEquals(true, currency_summery.isDisplayed());
		System.out.println("Currency:  " + currency_summery.getText());

		WebElement sales_channel_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/span"))));
		Assert.assertEquals(true, sales_channel_summery.isDisplayed());
		System.out.println("Sales channel:  " + sales_channel_summery.getText());

		WebElement payment_status_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[3]/span"))));
		Assert.assertEquals(true, payment_status_summery.isDisplayed());
		System.out.println("Payment status:  " + payment_status_summery.getText());

		WebElement line_item_inserted_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[2]/div/div/div[1]/strong"))));
		Assert.assertEquals(true, line_item_inserted_summery.isDisplayed());
		System.out.println("Line item:  " + line_item_inserted_summery.getText());

		WebElement shipping_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[4]"))));
		Assert.assertEquals(true, shipping_total_summery.isDisplayed());
		System.out.println(shipping_total_summery.getText());

		WebElement tax_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[3]"))));
		Assert.assertEquals(true, tax_total_summery.isDisplayed());
		System.out.println(tax_total_summery.getText());

		WebElement subtotal_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[1]/div[3]"))));
		Assert.assertEquals(true, subtotal_summery.isDisplayed());
		System.out.println("Sub Total=:  " + subtotal_summery.getText());

		WebElement order_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[2]/div/div[1]"))));
		Assert.assertEquals(true, order_total_summery.isDisplayed());
		System.out.println(order_total_summery.getText());

		WebElement outstanding = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[2]/div/div[2]"))));
		Assert.assertEquals(true, outstanding.isDisplayed());
		System.out.println(outstanding.getText());

		System.out.println("Order creation date field is displayed");
		System.out.println("Currency field is displayed");
		System.out.println("Sales channel field is displayed");
		System.out.println("Payment status is displayed");
		System.out.println("Line item is displayed");
		System.out.println("Shipping total is displayed");
		System.out.println("Total summery is displayed");
		System.out.println("Sub Total is displayed");
		System.out.println("Order total is displayed");

		WebElement create = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[4]/div[2]/button/span"))));
		Assert.assertEquals(true, create.isDisplayed());
		create.click();
		System.out.println("Create button displayed");
		System.out.println("ORDER CREATED *****navigated to ORDER STATUS page");
		System.out.println("****************************************************************************");

		WebElement order_number1 = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[3]/div/h2"))));
		Assert.assertEquals(true, order_number1.isDisplayed());
		System.out.println("order number displayed");
		System.out.println(order_number1.getText());

		WebElement create_new_order1 = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[5]/div/div/div[1]/button"))));
		Assert.assertEquals(true, create_new_order1.isDisplayed());
		System.out.println("create new order button displayed");

		WebElement close_order = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[5]/div/div/div[2]/button"))));
		Assert.assertEquals(true, close_order.isDisplayed());
		System.out.println("close button displayed");
		close_order.click();
		System.out.println("************Navigated to findorders page");
		log.info("close button displayed and successfully navigated to findorders page");
	}

	public void search_order() {

		WebElement filter = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div/div/h4/span[2]"))));
		filter.click();
		WebElement filter_name = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"custRef\"]"))));
		filter_name.sendKeys(NAME);
		WebElement search = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-search-order/div[1]/div[2]/div/div/div/form/div[5]/div[2]/button"))));
		search.click();
		System.out.println("Order created successfully and created order displayed on order list");
		System.out.println("Searched order by name:" + NAME);
		log.info("Searched order successfully by name");
		log.info("created order displayed on order list");
		WebElement search_table = wait.until((ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTable_wrapper\"]/div[2]/div"))));
		System.out.println(search_table.getText());

	}

	public void existing_customer() {
		System.out.println("Create order for Existing customer");
		WebElement select_existing = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"chooseCustomerT1\"]"))));
		select_existing.click();

		WebElement by_phone = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"custsearchparam_phone\"]"))));
		Assert.assertEquals(true, by_phone.isDisplayed());
		System.out.println("search existing customer by phone is displayed");

		WebElement by_email = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"custsearchparam_email\"]"))));
		Assert.assertEquals(true, by_email.isDisplayed());
		System.out.println("search existing customer by email is displayed");

		WebElement by_name = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"custsearchparam_name\"]"))));
		Assert.assertEquals(true, by_name.isDisplayed());
		System.out.println("search existing customer by name is displayed");
		by_name.click();
		log.info("Searched existing customer by name successfully");

		WebElement inputbox = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customersearch\"]"))));
		Assert.assertEquals(true, inputbox.isDisplayed());
		System.out.println("search existing customer box is displayed");
		System.out.println();

		if (by_phone.isSelected()) {
			inputbox.sendKeys(PHONE);
			String fieldText = inputbox.getAttribute("value");
			System.out.println("Input=" + fieldText);

			if (fieldText.matches("[0-9]+")) {
				System.out.println("**********search by phone field accepting only numbers and spacial characters");
			} else {
				System.out.println(
						"**********search by phone field accepting accepting alpha numeric values and spacial characters ");
			}

			WebElement list_details = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[2]/div[1]/div[1]/strong"))));
			list_details.click();

			WebElement details = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[2]/div[2]"))));
			System.out.println("Customer detailes displayed on right side");
			System.out.println(details.getText());

			WebElement next = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[3]/div[2]/button/span"))));
			String color_line_item = next.getCssValue("color");
			String c_line_item = Color.fromString(color_line_item).asHex();
			if (c_line_item.equals("#fa5c7c")) {
				System.out.println("Next button Not active");
				System.out.println("**********Please select any option");
			} else {
				System.out.println("Next button Active");
				next.click();
				System.out.println("navigated to ORDER & SHIPPING DETAILS form ****verification passed");
				System.out.println("****************************************************************************");

			}

		}
		if (by_email.isSelected()) {
			inputbox.sendKeys(EMAIL);
			String fieldText = inputbox.getAttribute("value");
			if (fieldText.matches("[a-zA-Z0-9]+")) {
				System.out.println("**********search by email field accepting only numbers and spacial characters");
			} else {
				System.out.println(
						"**********search by email field accepting alpha numeric values and spacial characters ");
			}

			WebElement list_details = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[2]/div[1]/div[1]/strong"))));
			list_details.click();

			WebElement details = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[2]/div[2]"))));
			System.out.println(details.getText());

			WebElement next = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[3]/div[2]/button/span"))));
			String color_line_item = next.getCssValue("color");
			String c_line_item = Color.fromString(color_line_item).asHex();
			if (c_line_item.equals("#fa5c7c")) {
				System.out.println("Next button Not active");
				System.out.println("**********Please select any option");
			} else {
				System.out.println("Next button Active");
				next.click();
				System.out.println("navigated to ORDER & SHIPPING DETAILS form ****verification passed");
				System.out.println("****************************************************************************");

			}
		}
		if (by_name.isSelected()) {
			inputbox.sendKeys(NAME);
			String fieldText = inputbox.getAttribute("value");
			if (fieldText.matches("[0-9]+")) {
				System.out.println("**********search by name field accepting only numbers and spacial characters");
			} else {
				System.out.println(
						"**********search by name field accepting alpha numeric values and spacial characters ");
			}

			WebElement list_details = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[2]/div[1]/div[1]/strong"))));
			list_details.click();

			WebElement details = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[2]/div[2]"))));
			System.out.println(details.getText());
			log.info(details.getText());
			WebElement next = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[1]/app-customer-details/div/div/div[2]/div[3]/div[2]/button/span"))));
			String color_line_item = next.getCssValue("color");
			String c_line_item = Color.fromString(color_line_item).asHex();
			if (c_line_item.equals("#fa5c7c")) {
				System.out.println("Next button Not active");
				System.out.println("**********Please select any option");
			} else {
				System.out.println("Next button Active");
				next.click();
				System.out.println("navigated to ORDER & SHIPPING DETAILS form ****verification passed");
				System.out.println("****************************************************************************");

			}
		}
		Assert.assertEquals(true, sales_channel.isDisplayed());
		System.out.println("Sales channel field is displayed");
		Select saleschannel_option = new Select(sales_channel);
		saleschannel_option.selectByVisibleText("Storicart E-Commerce_SIT");

		Assert.assertEquals(true, order_type.isDisplayed());
		System.out.println("Order type field is displayed");
		Select ordertype_option = new Select(order_type);
		ordertype_option.selectByVisibleText("Type2");

		Assert.assertEquals(true, order_status.isDisplayed());
		System.out.println("Order status field is displayed");
		Select orderstatus_option = new Select(order_status);
		orderstatus_option.selectByVisibleText("Packing Process");

		Assert.assertEquals(true, fullfilement_center.isDisplayed());
		System.out.println("Fullfilement center field is displayed");
		Select fillfilmentercenter_option = new Select(fullfilement_center);
		fillfilmentercenter_option.selectByVisibleText("Palakkad");

		Assert.assertEquals(true, fullfilement_status.isDisplayed());
		System.out.println("Fullfilement status field is displayed");
		Select fillfilmentstatus_option = new Select(fullfilement_status);
		fillfilmentstatus_option.selectByVisibleText("UNFULFILLED");

		Assert.assertEquals(true, ordercreation_date.isDisplayed());
		System.out.println("Order creation date field is displayed");
		ordercreation_date.sendKeys("16-04-2022");

		Assert.assertEquals(true, delivery_date.isDisplayed());
		System.out.println("Delivery date field is displayed");
		delivery_date.sendKeys("29-04-2022");

		Assert.assertEquals(true, order_currency.isDisplayed());
		System.out.println("Order currency field is displayed");
		Select Ordercurrency_option = new Select(order_currency);
		Ordercurrency_option.selectByVisibleText("India Rupees – INR");

		Assert.assertEquals(true, shipping_charge.isDisplayed());
		System.out.println("Shipping charge field is displayed");
		shipping_charge.sendKeys("60");
		System.out.println("****************************************************************");

		WebElement saleschannel = saleschannel_option.getFirstSelectedOption();
		String saleschannel_string = saleschannel.getText();
		if (saleschannel_string.contains("Please select a Sales Channel")) {
			System.out.println("****Please fill mandatory fields");
			System.out.println(sales_chanel_error.getText());
		}

		WebElement fullfilmentcenter_opt = fillfilmentercenter_option.getFirstSelectedOption();
		String fullfilmentcenter_string = fullfilmentcenter_opt.getText();
		if (fullfilmentcenter_string.contains("Fullfilment Center *")) {
			System.out.println(fullfilment_center_error.getText());
		}

		WebElement fullfilmentstatus_opt = fillfilmentstatus_option.getFirstSelectedOption();
		String fullfilmentstatus_string = fullfilmentstatus_opt.getText();
		if (fullfilmentstatus_string.contains("Fullfilment Status *")) {
			System.out.println(fullfilment_status_error.getText());
		}

		WebElement ordercurrency_opt = Ordercurrency_option.getFirstSelectedOption();
		String ordercurrency_string = ordercurrency_opt.getText();
		if (ordercurrency_string.contains("Select Order Currency")) {
			System.out.println(order_currency_error.getText());
		}

		System.out.println("****************************************************************");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);
		Assert.assertEquals(true, require_shipping.isDisplayed());
		System.out.println("requare shipping is displayed");
		require_shipping_option1.click();

		billing_address.click();
		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);

		if (honorific_shipping.isEnabled() && name_shipping.isEnabled() && company_shipping.isEnabled()
				&& addressline1_shipping.isEnabled() && addressline2_shipping.isEnabled() && city_shipping.isEnabled()
				&& zip_shipping.isEnabled() && province_shipping.isEnabled() && country_shipping.isEnabled()) {

			Select select1 = new Select(honorific_billing);
			WebElement honorific_billing_option = select1.getFirstSelectedOption();
			Select select = new Select(honorific_shipping);
			WebElement honorific_shipping_option = select.getFirstSelectedOption();
			String expected_honorific_tittle = honorific_billing_option.getText();
			String actual_honorific_shipping_tittle = honorific_shipping_option.getText();
			Assert.assertEquals(expected_honorific_tittle, actual_honorific_shipping_tittle);

			String expected_name_tittle = firstname.getText() + lastname.getText();
			String actual_name_tittle = name_shipping.getText();
			Assert.assertEquals(expected_name_tittle, actual_name_tittle);

			String expected_company_tittle = company.getText();
			String actual_company_shipping_tittle = company_shipping.getText();
			Assert.assertEquals(expected_company_tittle, actual_company_shipping_tittle);

			String expected_addressline1_tittle = addressline1.getText();
			String actual_addressline1_shipping_tittle = addressline1_shipping.getText();
			Assert.assertEquals(expected_addressline1_tittle, actual_addressline1_shipping_tittle);

			String expected_addressline2_tittle = addressline2.getText();
			String actual_addressline2_shipping_tittle = addressline2_shipping.getText();
			Assert.assertEquals(expected_addressline2_tittle, actual_addressline2_shipping_tittle);

			String expected_city_tittle = city.getText();
			String actual_city_shipping_tittle = city_shipping.getText();
			Assert.assertEquals(expected_city_tittle, actual_city_shipping_tittle);

			String expected_zip_tittle = zip.getText();
			String actual_zip_shipping_tittle = zip_shipping.getText();
			Assert.assertEquals(expected_zip_tittle, actual_zip_shipping_tittle);

			String expected_province_tittle = province.getText();
			String actual_province_shipping_tittle = province_shipping.getText();
			Assert.assertEquals(expected_province_tittle, actual_province_shipping_tittle);

			String expected_country_tittle = country.getText();
			String actual_country_shipping_tittle = country_shipping.getText();
			Assert.assertEquals(expected_country_tittle, actual_country_shipping_tittle);

			System.out.println("Billing address is same as shipping address and it's editable");
		} else {
			System.out.println("Billing address is same as shipping address and it's Not editable");
		}

		js.executeScript("window.scrollBy(0,350)");
		wait = new WebDriverWait(driver, 50);
		String color_order_shpping = nextbutton_order_shipping.getCssValue("color");
		String c_order_shipping = Color.fromString(color_order_shpping).asHex();

		if (c_order_shipping.equals("#fa5c7c")) {
			System.out.println("Next button Not active");
			System.out.println("Please fill mandatory fields*****verification passed");
		} else {
			System.out.println("Next button Active");
			nextbutton_order_shipping.click();
			System.out.println("navigated to LINE ITEM form ****verification passed");
			System.out.println("****************************************************************************");

		}

		add_lineitem.click();
		sku.click();
		sku_option2.click();
		String description_data = longname.getAttribute("value");
		System.out.println("Line Item");
		System.out.println("Item name=" + longname.getAttribute("value"));
		description.click();
		description.sendKeys(description_data);
		quantity.sendKeys("250");
		tax.sendKeys("70");

		skuid.click();
		total.click();

		wait = new WebDriverWait(driver, 50);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", total);
		System.out.println("Sub Total=" + subtotal.getText());
		System.out.println("Total=" + total.getAttribute("value"));
		total.click();

		if (longname.getAttribute("value").isEmpty())

		{
			System.out.println(error_longname.getText());
		}
		if (shortname.getAttribute("value").isEmpty())

		{
			System.out.println(error_shortname.getText());
		}
		if (unit.getAttribute("value").isEmpty())

		{
			System.out.println(error_unit.getText());
		}
		if (uom.getAttribute("value").isEmpty())

		{
			System.out.println(error_uom.getText());
		}
		if (price.getAttribute("value").isEmpty())

		{
			System.out.println(error_price.getText());
		}
		if (quantity.getAttribute("value").isEmpty())

		{
			System.out.println(error_quantity.getText());

		}
		if (skuid.getAttribute("value").isEmpty())

		{
			System.out.println(error_skuid.getText());
		}

		additem.click();
		sku.click();
		sku_option3.click();
		String description_data1 = longname.getAttribute("value");
		System.out.println("Line Item");
		System.out.println("Item name=" + longname.getAttribute("value"));
		description.click();
		description.sendKeys(description_data1);
		quantity.sendKeys("170");
		tax.sendKeys("60");
		skuid.click();
		total.click();

		wait = new WebDriverWait(driver, 50);
		js.executeScript("arguments[0].scrollIntoView();", total);
		System.out.println("Sub Total=" + subtotal.getText());
		System.out.println("Total=" + total.getAttribute("value"));
		total.click();

		if (longname.getAttribute("value").isEmpty())

		{
			System.out.println(error_longname.getText());
		}
		if (shortname.getAttribute("value").isEmpty())

		{
			System.out.println(error_shortname.getText());
		}
		if (unit.getAttribute("value").isEmpty())

		{
			System.out.println(error_unit.getText());
		}
		if (uom.getAttribute("value").isEmpty())

		{
			System.out.println(error_uom.getText());
		}
		if (price.getAttribute("value").isEmpty())

		{
			System.out.println(error_price.getText());
		}
		if (quantity.getAttribute("value").isEmpty())

		{
			System.out.println(error_quantity.getText());

		}
		if (skuid.getAttribute("value").isEmpty())

		{
			System.out.println(error_skuid.getText());
		}
		additem.click();
		close.click();
		System.out.println("Item added to item list");
		System.out.println();
		System.out.println("Total Item List:");
		System.out.println(itemlist.getText());
		System.out.println("****************************************************************************");

		wait = new WebDriverWait(driver, 30);
		WebElement edit = wait.until((ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class=\"mdi mdi-pencil-circle-outline mdi-24px text-primary\"]"))));
		edit.click();
		Assert.assertEquals(true, edit.isDisplayed());
		System.out.println("Edit line item option is displayed");

		WebElement taxamount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"taxAmount\"]"))));
		taxamount.sendKeys("500");

		WebElement total = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"total\"]"))));
		js.executeScript("arguments[0].scrollIntoView();", total);
		total.click();

		WebElement additem_edit = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Add Item\"]"))));
		additem_edit.click();

		WebElement closeitem_edit = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Close\"]"))));
		closeitem_edit.click();
		System.out.println("successfully updated item details");
		System.out.println("****************************************************************************");

		WebElement remove = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[2]/div/table/tbody/tr[1]/td[11]/span/span"))));
		remove.click();
		System.out.println("Item removed from item list");
		System.out.println("****************************************************************************");

		WebElement percentage = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderDiscountRate\"]"))));
		percentage.sendKeys("20");

		WebElement edit_orderdetails = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[7]/div/div[1]/div[2]/span"))));
		edit_orderdetails.click();

		WebElement sub_total = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderSubTotal\"]"))));
		js.executeScript("arguments[0].scrollIntoView();", sub_total);
		sub_total.click();
		String subtotal_total = sub_total.getAttribute("value");
		System.out.println("Sub Total=" + subtotal_total);

		WebElement total_discount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTotalDiscount\"]"))));
		String total_discount_total = total_discount.getAttribute("value");
		System.out.println("Total Discount=" + total_discount_total);

		WebElement tax_rate = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTaxRate\"]"))));
		tax_rate.sendKeys("1.3");

		WebElement total_tax = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTaxTotal\"]"))));
		total_tax.click();
		String total_tax_total = total_tax.getAttribute("value");
		System.out.println("Tax Total=" + total_tax_total);

		WebElement shipping_charge = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"float-right mr-2\"]"))));
		String total_shipping_charge = shipping_charge.getText();
		System.out.println("Shipping charge=" + total_shipping_charge);

		System.out.println("Total Amount= Sub Total-Total Discount+Total Tax+Shipping charge");
		System.out.println(
				subtotal_total + "-" + total_discount_total + "+" + total_tax_total + "+" + total_shipping_charge);
		WebElement total_amount = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderTotal\"]"))));
		total_amount.click();
		String total_amount_total = total_amount.getAttribute("value");
		System.out.println("Total=" + total_amount_total);
		System.out.println();
		WebElement previous_lineitem = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[8]/div[2]/button/span"))));
		previous_lineitem.click();
		nextbutton_order_shipping.click();
		System.out.println("editing data is possible when previous button is clicked");
		js.executeScript("arguments[0].scrollIntoView();", sub_total);
		sub_total.click();
		if (sub_total.isEnabled() && total_discount.isEnabled() && total_tax.isEnabled() && total_amount.isEnabled()) {
			System.out.println("**user able to edit data before creating an order");
			System.out.println("**Total considered as TOTAL AMOUNT OF ORDER");
		} else {
			System.out.println("The fields are not editable");
		}

		WebElement next_button_lineitem = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[3]/app-line-items/div/div/form/div[8]/div[1]/button"))));
		String color_line_item = next_button_lineitem.getCssValue("color");
		String c_line_item = Color.fromString(color_line_item).asHex();
		if (c_line_item.equals("#fa5c7c")) {
			System.out.println("Next button Not active");
			System.out.println("**********Please add line item");
		} else {
			System.out.println("Next button Active");
			next_button_lineitem.click();
			System.out.println("navigated to PAYMENT DETAILS form ****verification passed");
			System.out.println("****************************************************************************");

		}
		WebElement payment_status = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"financialStatus\"]"))));
		Assert.assertEquals(true, payment_status.isDisplayed());
		System.out.println("Payment status field is displayed");
		Select payment_status_option = new Select(payment_status);
		payment_status_option.selectByVisibleText("PAID");

		WebElement payment_status_dis = payment_status_option.getFirstSelectedOption();
		String payment_status_display = payment_status_dis.getText();
		System.out.println("Payment status  " + payment_status_display + "  selected");

		if (payment_status_option.isMultiple()) {
			payment_status_option.selectByVisibleText("PAID");
			payment_status_option.selectByVisibleText("PARTIALLY_PAID");
			payment_status_option.selectByVisibleText("PENDING");
		}

		else {
			System.out.println("***Multiple selection not possible");
		}

		WebElement payment_method = wait
				.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentMethod\"]"))));
		Assert.assertEquals(true, payment_method.isDisplayed());
		System.out.println("Payment method field is displayed");
		Select payment_method_option = new Select(payment_method);
		payment_method_option.selectByVisibleText("Check");

		WebElement payment_method_dis = payment_method_option.getFirstSelectedOption();
		String payment_method_display = payment_method_dis.getText();
		System.out.println("Payment method  " + payment_method_display + "  selected");

		if (payment_method_option.isMultiple()) {
			payment_method_option.selectByVisibleText("Check");
			payment_method_option.selectByVisibleText("Cash");
		} else {
			System.out.println("***Multiple selection not possible");
		}

		WebElement method_check = payment_method_option.getFirstSelectedOption();
		String pay_method_check = method_check.getText();
		if (pay_method_check.contains("Check")) {
			System.out.println("Check payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement method_card = payment_method_option.getFirstSelectedOption();
		String pay_method_card = method_card.getText();
		if (pay_method_card.contains("Credit/ Debit card")) {
			System.out.println("Credit/ Debit card payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement method_googlepay = payment_method_option.getFirstSelectedOption();
		String pay_method_googlepay = method_googlepay.getText();
		if (pay_method_googlepay.contains("google pay/phone pay")) {
			System.out.println("google pay/phone pay payment method selected");
			System.out.println("***There are no options to enter future payment details");
		}

		WebElement status_pending = payment_status_option.getFirstSelectedOption();
		String status_pending_notify = status_pending.getText();
		if (status_pending_notify.contains("PENDING")) {
			System.out.println("Payment status PENDING selected");
			System.out.println("***No notification given total amount considered as pending");
		}
		if (status_pending_notify.contains("PARTIALLY_PAID")) {
			WebElement collected_amount = wait
					.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"collectedPayment\"]"))));
			collected_amount.sendKeys("20000");
			System.out.println("Collected amount=" + collected_amount.getAttribute("value"));
			WebElement pending_amount = wait
					.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pendingPayment\"]"))));
			pending_amount.click();
			System.out.println("Pending amount=" + pending_amount.getAttribute("value"));
			System.out.println("***Pending amount auto calculated");

		}

		WebElement next_payment = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[4]/app-payment/div/div/form/div[2]/div[1]/button/span"))));
		next_payment.click();
		System.out.println("navigated to ORDER SUMMARY form ****verification passed");
		System.out.println("****************************************************************************");

		WebElement order_creation_date_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[1]/span"))));
		Assert.assertEquals(true, order_creation_date_summery.isDisplayed());
		System.out.println("Order creation date:  " + order_creation_date_summery.getText());

		WebElement currency_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[2]/span"))));
		Assert.assertEquals(true, currency_summery.isDisplayed());
		System.out.println("Currency:  " + currency_summery.getText());

		WebElement sales_channel_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/span"))));
		Assert.assertEquals(true, sales_channel_summery.isDisplayed());
		System.out.println("Sales channel:  " + sales_channel_summery.getText());

		WebElement payment_status_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[1]/strong[3]/span"))));
		Assert.assertEquals(true, payment_status_summery.isDisplayed());
		System.out.println("Payment status:  " + payment_status_summery.getText());

		WebElement line_item_inserted_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[2]/div/div/div[1]/strong"))));
		Assert.assertEquals(true, line_item_inserted_summery.isDisplayed());
		System.out.println("Line item:  " + line_item_inserted_summery.getText());

		WebElement shipping_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[4]"))));
		Assert.assertEquals(true, shipping_total_summery.isDisplayed());
		System.out.println(shipping_total_summery.getText());

		WebElement tax_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[3]"))));
		Assert.assertEquals(true, tax_total_summery.isDisplayed());
		System.out.println(tax_total_summery.getText());

		WebElement subtotal_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[1]/div/div/div[1]/div[3]"))));
		Assert.assertEquals(true, subtotal_summery.isDisplayed());
		System.out.println("Sub Total=:  " + subtotal_summery.getText());

		WebElement order_total_summery = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[2]/div/div[1]"))));
		Assert.assertEquals(true, order_total_summery.isDisplayed());
		System.out.println(order_total_summery.getText());

		WebElement outstanding = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[3]/div/div[3]/div/div[2]/div/div[2]"))));
		Assert.assertEquals(true, outstanding.isDisplayed());
		System.out.println(outstanding.getText());

		System.out.println("Order creation date field is displayed");
		System.out.println("Currency field is displayed");
		System.out.println("Sales channel field is displayed");
		System.out.println("Payment status is displayed");
		System.out.println("Line item is displayed");
		System.out.println("Shipping total is displayed");
		System.out.println("Total summery is displayed");
		System.out.println("Sub Total is displayed");
		System.out.println("Order total is displayed");

		WebElement create = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[5]/app-order-summary/div/div/div[4]/div[2]/button/span"))));
		Assert.assertEquals(true, create.isDisplayed());
		create.click();
		System.out.println("Create button displayed");
		System.out.println("ORDER CREATED *****navigated to ORDER STATUS page");
		System.out.println("****************************************************************************");

		WebElement order_number1 = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[3]/div/h2"))));
		Assert.assertEquals(true, order_number1.isDisplayed());
		System.out.println("order number displayed");
		System.out.println(order_number1.getText());

		WebElement create_new_order1 = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[5]/div/div/div[1]/button"))));
		Assert.assertEquals(true, create_new_order1.isDisplayed());
		System.out.println("create new order button displayed");

		WebElement close_order = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-pages/div/div/div[2]/app-create-order/div/aw-wizard/div/aw-wizard-step[6]/app-order-status/div/div/div/div/div[5]/div/div/div[2]/button"))));
		Assert.assertEquals(true, close_order.isDisplayed());
		System.out.println("close button displayed");

	}

}
