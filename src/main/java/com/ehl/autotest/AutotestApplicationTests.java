package com.ehl.autotest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AutotestApplicationTests {

	public static ChromeDriver chromeDriver;
	RestTemplate restTemplate;

	@BeforeClass
	public static void openBrowser() {
		System.out.println("start --- openBrowser");

		System.setProperty("webdriver.chrome.driver","D:/Download/chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts()
				.implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void closeBrowser() {
		System.out.println("end --- closeBrowser");
		chromeDriver.quit();
	}

	@Test
	public void doTest() throws InterruptedException {
		System.out.println("Base Test:");
		assertEquals("true","true");
	}

}
