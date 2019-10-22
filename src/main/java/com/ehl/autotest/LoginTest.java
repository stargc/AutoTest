package com.ehl.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.xml.bind.Element;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author created by guanchen on 2019/10/22 14:50
 */
public class LoginTest extends AutotestApplicationTests {

    @Test(priority = 999,groups = {"loginTest"})
    @Override
    public void doTest() throws InterruptedException {

        // 要测试的网址
        String baseUrl = "http://10.150.27.144:8099/";
        chromeDriver.get(baseUrl);
        chromeDriver.findElementById("logbtn").click();
        List<WebElement> inputs = chromeDriver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("admin");
        inputs.get(1).sendKeys("123456");

        chromeDriver.findElementByXPath("//input[@id='loginBtn']").click();

        String title = chromeDriver.findElementById("bannerNameForDataResource").getText();
        System.out.println(title);

        assertEquals("所有信息资源库",title);
    }
}
