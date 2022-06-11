package OMSTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import OMSPages.OMSFindOrdersPage;
import OMSPages.OMSLoginPage;
import OMSPages.OMSSalesOrdersPage;
import TestScenario.OMSTestBase;

public class OMSTest extends OMSTestBase {

	OMSLoginPage loginPage;
	OMSFindOrdersPage findOrdersPage;
	OMSSalesOrdersPage salesOrdersPage;

	private static final Logger log = LogManager.getLogger(OMSTest.class);

	@Test(priority = 0)
	public void OMSLoginTest() {

		log.info("Verifying successful login.");

		loginPage = new OMSLoginPage(driver);

		OMSFindOrdersPage findOrdersPage = loginPage.login("vt@testvox.com", "vt@testvox.com");

	}

	@Test(priority = 1)
	public void OMSFindOrdersDisplayTest() {
		findOrdersPage = new OMSFindOrdersPage(driver);
		findOrdersPage.manageOrdersTabDisplay();
		findOrdersPage.findOrdersTabDisplay();
		findOrdersPage.filtersDisplay();
	}

	@Test(priority = 2, enabled = true)
	public void OrderDisplayNameTest() {
		findOrdersPage.OrderdisplayNameField();
	}

	@Test(priority = 3, enabled = true)
	public void CustomerReferenceTest() {
		findOrdersPage.CustomerReferenceField();
	}

	@Test(priority = 4, enabled = false)
	public void OrderTypeTest() {
		findOrdersPage.OrderTypeDropdown();
	}

	@Test(priority = 5, enabled = false)
	public void OrderStatusTest() {
		findOrdersPage.OrderStatusDropdown();
	}

	@Test(priority = 6, enabled = false)
	public void OrderGroupsTest() {
		findOrdersPage.OrderGroupsDropdown();
	}

	@Test(priority = 7, enabled = false)
	public void OrderLabelsTest() {
		findOrdersPage.OrderLabelsDropdown();
	}

	@Test(priority = 8, enabled = false)
	public void SalesChannelTest() {
		findOrdersPage.SalesChannelDropdown();
	}

	@Test(priority = 9, enabled = false)
	public void DeliveryChannelTest() {
		findOrdersPage.DeliveryChannelDropdown();
	}

	@Test(priority = 10, enabled = false)
	public void DispatchDateTest() {
		findOrdersPage.DispacthDatePicker();
	}

	@Test(priority = 11, enabled = false)
	public void DeliveryDateTest() {
		findOrdersPage.DeliveryDatePicker();
	}

	@Test(priority = 12, enabled = false)
	public void OrderEntityAssigneeNamesTest() {
		findOrdersPage.OrderEntityAssigneeNamesDropdown();
	}

	@Test(priority = 13, enabled = false)
	public void OrderPaymentStatusTest() {
		findOrdersPage.OrderPaymentStatusDropdown();
	}

	@Test(priority = 14, enabled = false)
	public void OrderTagTest() {
		findOrdersPage.OrderTagField();
	}

	@Test(priority = 15, enabled = false)
	public void OrderFulfillmentCenterTest() {
		findOrdersPage.OrderFulfillmentCenterDropdown();
	}

	@Test(priority = 16)
	public void SearchAndExcelTest() {
		findOrdersPage.search();
		findOrdersPage.excel();
	}

	@Test(priority = 17)
	public void OrderEditTest() {
		findOrdersPage.orderEditAction();
	}

	@Test(priority = 18, enabled = false)
	public void OrderCancelAndRejectTest() {

		findOrdersPage.orderCancelAction();
		findOrdersPage.orderRejectAction();
		findOrdersPage.orderStatusAction();
	}

	@Test(priority = 19)
	public void NavigateToSalesOrdersTest() {
		findOrdersPage.navigatetoSalesOrdersPage();
	}

	@Test(priority = 20)
	public void OMSSalesOrdersTest() {
		salesOrdersPage = new OMSSalesOrdersPage(driver);
		salesOrdersPage.salesOrdersTabDisplay();
		salesOrdersPage.filterDisplay();
		salesOrdersPage.findOrders();
	}
}
