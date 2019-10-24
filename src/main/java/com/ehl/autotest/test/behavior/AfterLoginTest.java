package com.ehl.autotest.test.behavior;

import com.ehl.autotest.test.BaseAutoTests;
import org.testng.annotations.*;

/**
 * @author created by guanchen on 2019/10/23 17:50
 */
public class AfterLoginTest extends BaseAutoTests {

    @BeforeTest
    @Parameters({"baseUrl"})
    public void login(String baseUrl) {
        System.out.println("start ---  login");
        if (chromeDriver.getCurrentUrl().equals(baseUrl) ||
                chromeDriver.getCurrentUrl().endsWith("href=index")){
            loginUtilSuccess("admin","123456");
        }
        chromeDriver.get(baseUrl + "?href=dataResource_body");
    }

    @AfterTest
    public void afterTest() {
//        System.out.println("end --- ");
    }

}
