package com.ehl.autotest.test.login;

import com.ehl.autotest.test.BaseAutoTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author created by guanchen on 2019/10/23 17:45
 */
public class LoginSuccessTest extends BaseLoginTest {

    @Test(priority = 1)
    public void login() {
        loginUtilSuccess("admin", "123456");
        assertTrue(chromeDriver.getCurrentUrl().endsWith("href=dataResource_body"));
        assertEquals(chromeDriver.getTitle(), "信息资源");
    }

    @Test(priority = 2)
    public void loginout() {
        WebElement header = chromeDriver.findElementByXPath("//img[@id='userInfoForHeader']");
        actions.click(header).perform();

        actions.click(findElementUtilLoaded(By.id("loginOutBtn"))).perform();

        waitPageLoad("href=index");
        assertTrue(chromeDriver.getCurrentUrl().endsWith("href=index"));
    }
}
