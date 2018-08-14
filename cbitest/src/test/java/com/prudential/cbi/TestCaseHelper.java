package com.prudential.cbi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseHelper {

	public static boolean login() {

		String username, userpassword;

		username = BaseTest.cbiProp.get("username");
		userpassword = BaseTest.cbiProp.get("userpassword");

		// If logged in - then first Logout
		/*
		 * boolean isLoggedin = true; try {
		 * BaseTest.driver.findElement(By.id("uxpMenuSearch")); } catch
		 * (NoSuchElementException e) { isLoggedin = false; }
		 * 
		 * if (isLoggedin) { logout(); }
		 */

		// Wait for Sign-in screen to appear
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit")));

		// Now login into the system
		(BaseTest.driver.findElement(By.id("username"))).sendKeys(username);
		(BaseTest.driver.findElement(By.id("password"))).sendKeys(userpassword);

		WebElement login = BaseTest.driver.findElement(By.name("submit"));
		login.click();
		return true;

	}

	public static void invokeMenu(String xpath) {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		WebElement menu = BaseTest.driver.findElement(By.xpath(xpath));
		menu.click();
	}

	public static void DashboardMenu() {
		TestCaseHelper.invokeMenu("/html/body/div/md-sidenav[1]/tri-menu/md-content/tri-menu-item[1]/div/button");
	}

	public static void logout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,
				Integer.valueOf(BaseTest.cbiProp.get("maxscreenloadtimeinsec")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/md-toolbar/div/md-menu[2]/button/span")));
		WebElement user = BaseTest.driver.findElement(By.xpath("/html/body/div[1]/div/md-toolbar/div/md-menu[2]/button/span"));
		user.click();
		Thread.sleep(1000);
		WebElement logout = BaseTest.driver.findElement(By.xpath("//*[@id=\"menu_container_4\"]/md-menu-content/md-menu-item/button"));
		logout.click();
		Thread.sleep(1000);
	}

	/*
	 * public static Connection getConnection() { return
	 * JDBCConnection.getInstance(CBIProperties.dbDriverClass, CBIProperties.dbUrl,
	 * CBIProperties.dbUserName, CBIProperties.dbUserPassword).getConnection(); }
	 */

	public static void closeScreens() {
		Robot robot;
		try {
			TimeUnit.MILLISECONDS.sleep(Integer.valueOf(BaseTest.cbiProp.get("shorttimedelay")));

			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ESCAPE);
				TimeUnit.MILLISECONDS.sleep(Integer.valueOf(BaseTest.cbiProp.get("shorttimedelay")));
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_F3);
				robot.keyRelease(KeyEvent.VK_F3);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				e.printStackTrace();
			}

		} catch (WebDriverException e2) {
			System.out.println("Some issue WebDriver Exception");
			return;
		} catch (InterruptedException e1) {
			// Handle error
		}
	}

}
