package com.ehl.autotest.test.login;

import com.ehl.autotest.test.BaseAutoTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * @author created by guanchen on 2019/10/24 14:07
 */
public class BaseLoginTest  extends BaseAutoTests {

    @BeforeClass
    @Parameters({"baseUrl"})
    public void beforeClass(String baseUrl){
        System.out.println("start --- loginTest");
        chromeDriver.get(baseUrl);

    }
    @AfterClass
    @Parameters({"baseUrl"})
    public void afterClass(String baseUrl){
        System.out.println("end --- loginTest");
        chromeDriver.get(baseUrl);
    }
}
