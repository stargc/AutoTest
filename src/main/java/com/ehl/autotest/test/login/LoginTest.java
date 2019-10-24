package com.ehl.autotest.test.login;

import com.ehl.autotest.test.BaseAutoTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author created by guanchen on 2019/10/22 14:50
 */
public class LoginTest extends BaseLoginTest {

    @Test(priority = 1)
    public void showLoginDialog() {
        WebElement logDialog = chromeDriver.findElementByXPath("//input[@id='loginPhone']");

        assertFalse(logDialog.isDisplayed());
        chromeDriver.findElementById("logbtn").click();

        waitElementShow(logDialog);
        assertTrue(logDialog.isDisplayed());
    }

    @Test(priority = 2)
    public void clickLoginBtnWithNullInfo() {
        doLogin("", "");

        assertEquals("提示：手机号不能为空！",
                chromeDriver.findElementByXPath("//em[@id='loginPhone-error']").getText());
        assertEquals("提示：密码不能为空！",
                chromeDriver.findElementByXPath("//em[@id='loginPassword-error']").getText());
    }

    @Test(priority = 3)
    public void clickLoginBtnWithNullPassword() {
        doLogin("admin", "");
        assertEquals("提示：密码不能为空！",
                chromeDriver.findElementByXPath("//em[@id='loginPassword-error']").getText());
    }

    @Test(priority = 4)
    public void clickLoginBtnWithNullPhone() {
        doLogin("", "123");
        assertEquals("提示：手机号不能为空！",
                chromeDriver.findElementByXPath("//em[@id='loginPhone-error']").getText());
    }

    @Test(priority = 5)
    public void checkErrorPassword() {
        doLogin("errorUserName", "errorPassword");
        String msg = findElementUtilLoaded(By.className("toast-message")).getText();
        assertEquals("用户名或密码错误", msg);
    }
}
