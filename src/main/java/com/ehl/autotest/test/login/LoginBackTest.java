package com.ehl.autotest.test.login;

import com.ehl.autotest.test.BaseAutoTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author created by guanchen on 2019/10/23 17:45
 */
public class LoginBackTest extends BaseAutoTests {

    @Test(priority = 1)
    public void doBack() {
        loginUtilSuccess("admin", "123456");
        assertTrue(chromeDriver.getCurrentUrl().endsWith("href=dataResource_body"));

        chromeDriver.navigate().back();
        waitPageLoad("href=index");
        assertTrue(chromeDriver.getCurrentUrl().endsWith("href=index"));
    }

}
