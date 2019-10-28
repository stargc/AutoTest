package com.ehl.autotest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseAutoTests {

	public static ChromeDriver chromeDriver;
	public static WebDriverWait wait;
	public static Actions actions;

	/***
	 * 打开浏览器
	 */
	@BeforeSuite(alwaysRun = true)
	@Parameters({"baseUrl","driverLocation"})
	public void openBrowser(String baseUrl,String driverLocation) {
		System.out.println("start --- openBrowser");

		System.setProperty("webdriver.chrome.driver",driverLocation);
		ChromeOptions options = new ChromeOptions();

		chromeDriver = new ChromeDriver(options);
//		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(chromeDriver,10,1);
		actions = new Actions(chromeDriver);

		chromeDriver.get(baseUrl);
	}

	/***
	 * 关闭浏览器
	 */
	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		System.out.println("end --- closeBrowser");
		chromeDriver.quit();
	}

	/***
	 * 强制浏览器等待
	 * @param second
	 */
	public void waitCompelled(int second){
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/***
	 * 等待浏览器挑战页面
	 * 等待10s,未完成则报错
	 * @param url
	 */
	public void waitPageLoad(String url){
		wait.until(ExpectedConditions.urlContains(url));
	}

	/***
	 * 等待元素显示出来
	 * 等待10s,未完成则报错
	 * @param element
	 */
	public void waitElementShow(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/***
	 * 等待元素加载
	 * 等待10s,未完成则报错
	 * @param by
	 * @return
	 */
	public WebElement findElementUtilLoaded(By by){
		return wait.until(new ExpectedCondition<WebElement>(){
			@Override
			public WebElement apply(WebDriver text) {
				return text.findElement(by);
			}
		});
	}

	/***
	 * 尝试进行登录
	 * @param userName
	 * @param password
	 */
	public void doLogin(String userName, String password) {
		if (!chromeDriver.findElementByXPath("//input[@id='loginPhone']").isDisplayed()) {
			chromeDriver.findElementById("logbtn").click();
		}
		chromeDriver.findElementByXPath("//input[@id='loginPhone']").clear();
		chromeDriver.findElementByXPath("//input[@id='loginPassword']").clear();

		for (int i = 1; i <= userName.length(); i++) {
			chromeDriver.findElementByXPath("//input[@id='loginPhone']")
					.sendKeys(userName.substring(i-1,i));
		}
		for (int i = 1; i <= password.length(); i++) {
			chromeDriver.findElementByXPath("//input[@id='loginPassword']")
					.sendKeys(password.substring(i-1,i));
		}

		chromeDriver.findElementByXPath("//input[@id='loginBtn']").click();
	}

	/***
	 * 登录知道页面加载完成
	 * @param userName
	 * @param password
	 */
	public void loginUtilSuccess(String userName, String password) {
		doLogin(userName, password);
		waitPageLoad("dataResource_body");
	}



}
