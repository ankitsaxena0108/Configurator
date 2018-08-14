package com.prudential.cbi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prudential.JUnitCoreConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JUnitCoreConfiguration.class })
public class CBISeleniumMainTest extends BaseTest {


	@BeforeClass
	public void init() throws InterruptedException {
		TestCaseHelper.login();
		driver.manage().window().maximize();
		ClickDashboard();

	}

	@Test
	public void auploadFile() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadButton")));
		Thread.sleep(5000);
		WebElement element= BaseTest.driver.findElement(By.xpath("//*[@id=\"select_option_11\"]/div[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) BaseTest.driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		element.click();
		
		/*WebElement category = BaseTest.driver.findElement(By.name("categoryType"));
		category.click();
		Thread.sleep(5000);
		WebElement categoryValue = BaseTest.driver.findElement(By.cssSelector("md-option[value = 'Payout']"));
		Thread.sleep(5000);
		categoryValue.click();*/
		Robot robot = new Robot();
		Thread.sleep(5000);
		WebElement browse = BaseTest.driver.findElement(By.xpath("//*[@id=\"fileName\"]/div[2]/button[3]"));
		browse.click();
		Thread.sleep(5000);

		robot.setAutoDelay(10000);
		StringSelection strSelection = new StringSelection(BaseTest.cbiProp.get("fileUploadPath"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(1000);

		WebElement upload = BaseTest.driver.findElement(By.xpath("//*[@id=\"uploadButton\"]"));
		upload.click();

		Thread.sleep(5000);

	}

	@Test
	public void bdownloadFile() throws InterruptedException {

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadButton")));

		Thread.sleep(1000);
		WebElement download = BaseTest.driver.findElement(By.xpath("//*[@id=\"downloadButton\"]"));
		download.click();
		Thread.sleep(1000);

	}

	@Test
	public void cSaveInputFeedScheduleInfo() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadButton")));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 300);");

		WebElement ipFeed = BaseTest.driver.findElement(By.id("ipFeed"));
		ipFeed.click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("startTimeHrs")));
		(BaseTest.driver.findElement(By.id("startTimeHrs"))).clear();
		(BaseTest.driver.findElement(By.id("startTimeHrs"))).sendKeys("12:10:02");
		(BaseTest.driver.findElement(By.id("startTimeMins"))).clear();
		(BaseTest.driver.findElement(By.id("startTimeMins"))).sendKeys("17:20");
		(BaseTest.driver.findElement(By.id("recurrenceHourly"))).clear();
		(BaseTest.driver.findElement(By.id("recurrenceHourly"))).sendKeys("6");

		WebElement saveInputFeed = BaseTest.driver.findElement(By.id("saveInputFeed"));
		saveInputFeed.click();

		Thread.sleep(5000);

	}

	@Test
	public void dSaveBankFeedScheduleInfo() throws InterruptedException {
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadButton")));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 300);");
		Thread.sleep(2000);

		WebElement ipBankFeed = BaseTest.driver.findElement(By.id("ipBankFeed"));
		ipBankFeed.click();

		Thread.sleep(2000);

		// jse.executeScript("scroll(0, 300);");

		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bstartTimeHrs")));

		(BaseTest.driver.findElement(By.id("bstartTimeHrs"))).clear();
		(BaseTest.driver.findElement(By.id("bstartTimeHrs"))).sendKeys("12:10:01");
		(BaseTest.driver.findElement(By.id("bstartTimeMins"))).clear();
		(BaseTest.driver.findElement(By.id("bstartTimeMins"))).sendKeys("17:20");
		(BaseTest.driver.findElement(By.id("brecurrenceHourly"))).clear();
		(BaseTest.driver.findElement(By.id("brecurrenceHourly"))).sendKeys("6");

		Thread.sleep(2000);
		jse.executeScript("scroll(0, 300);");

		WebElement saveBankFeed = BaseTest.driver.findElement(By.id("saveBankFeed"));
		saveBankFeed.click();

		Thread.sleep(5000);

	}

	@Test
	public void eSaveSourceScheduleInfo() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadButton")));

		WebElement editSource = BaseTest.driver.findElement(By.id("editSource"));
		editSource.click();
		Thread.sleep(5000);

		WebElement scheduleInfoTab = BaseTest.driver.findElement(By.xpath(
				"/html/body/div/div/md-content/div[1]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]"));
		scheduleInfoTab.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("startTimeHrs")));
		(BaseTest.driver.findElement(By.id("startTimeHrs"))).clear();
		(BaseTest.driver.findElement(By.id("startTimeHrs"))).sendKeys("12:10:02");
		(BaseTest.driver.findElement(By.id("startTimeMins"))).clear();
		(BaseTest.driver.findElement(By.id("startTimeMins"))).sendKeys("17:20");
		(BaseTest.driver.findElement(By.id("recurrenceHourly"))).clear();
		(BaseTest.driver.findElement(By.id("recurrenceHourly"))).sendKeys("6");

		WebElement save = BaseTest.driver.findElement(By.id("save"));
		save.click();

		Thread.sleep(5000);

	}

	//@Test
	public void fSaveBankScheduleInfo() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadButton")));

		WebElement editBank = BaseTest.driver.findElement(By.id("editBank"));
		editBank.click();
		Thread.sleep(5000);

		WebElement scheduleInfoTab = BaseTest.driver.findElement(By.xpath(
				"/html/body/div/div/md-content/div[1]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]"));
		scheduleInfoTab.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("startTimeHrs")));
		(BaseTest.driver.findElement(By.id("startTimeHrs"))).clear();
		(BaseTest.driver.findElement(By.id("startTimeHrs"))).sendKeys("12:10:02");
		(BaseTest.driver.findElement(By.id("startTimeMins"))).clear();
		(BaseTest.driver.findElement(By.id("startTimeMins"))).sendKeys("17:20");
		(BaseTest.driver.findElement(By.id("recurrenceHourly"))).clear();
		(BaseTest.driver.findElement(By.id("recurrenceHourly"))).sendKeys("6");

		WebElement save = BaseTest.driver.findElement(By.id("save"));
		save.click();

		Thread.sleep(5000);
	}

	@Test
	public void gEnquiryAudit() throws InterruptedException {
		AuditEnquiry();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));

		(BaseTest.driver.findElement(By.id("name"))).sendKeys("system1");
		(BaseTest.driver.findElement(By.id("fileDirection"))).sendKeys("Inward");
		(BaseTest.driver.findElement(By.id("category"))).sendKeys("Collection");
		(BaseTest.driver.findElement(By.id("status"))).sendKeys("PROCESSED");
		(BaseTest.driver.findElement(By.id("paymentType"))).sendKeys("CreditCard");

		WebElement search = BaseTest.driver.findElement(By.id("auditSearch"));
		search.click();

		Thread.sleep(1000);

	}

	private void AuditEnquiry() {
		TestCaseHelper.invokeMenu("/html/body/div/md-sidenav[1]/tri-menu/md-content/tri-menu-item[2]/div/button");
	}

	@AfterClass
	public void closeScreen() throws InterruptedException {
		TestCaseHelper.logout();
		TestCaseHelper.closeScreens();

	}

	private void ClickDashboard() {
		TestCaseHelper.invokeMenu("/html/body/div/md-sidenav[1]/tri-menu/md-content/tri-menu-item[1]/div/button");
	}

}
