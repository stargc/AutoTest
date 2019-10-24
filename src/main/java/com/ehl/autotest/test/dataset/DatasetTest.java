package com.ehl.autotest.test.dataset;

import com.ehl.autotest.test.behavior.AfterLoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author created by guanchen on 2019/10/22 14:50
 */
public class DatasetTest extends AfterLoginTest {

    @BeforeClass
    public void beforeClass(){
        actions.moveToElement(chromeDriver.findElementById("resourceMenuAdmin")).perform();
        actions.click(findElementUtilLoaded(By.id("resourceDetailSearchAdmin"))).perform();
    }

    @AfterClass
    public void afterClass(){

    }

    @Test(priority = 1, groups = {"loginTest"})
    public void addDateSet() {
        findElementUtilLoaded(By.id("resourceSearchApplyButtonId")).click();
        waitElementShow(chromeDriver.findElementById("resourceAddForm"));

        actions.click(chromeDriver.findElementsByClassName("searchable-select-caret").get(1)).perform();
        waitElementShow(chromeDriver.findElementByXPath("//div[@title='天津纪委']"));
        actions.click(chromeDriver.findElementByXPath("//div[@title='天津纪委']")).perform();

        waitElementShow(chromeDriver.findElementsByClassName("searchable-select-caret").get(2));
        actions.click(chromeDriver.findElementsByClassName("searchable-select-caret").get(2)).perform();
        waitElementShow(chromeDriver.findElementByXPath("//div[@title='MySQL']"));
        actions.click(chromeDriver.findElementByXPath("//div[@title='MySQL']")).perform();

        chromeDriver.findElementByXPath("//input[@id='resourceAddDatasrcName']")
                .sendKeys("AutoTest");
        chromeDriver.findElementByXPath("//input[@id='resourceAddIP']")
                .sendKeys("192.168.0.2");
        chromeDriver.findElementByXPath("//input[@id='resourceAddPort']")
                .sendKeys("6399");
        chromeDriver.findElementByXPath("//input[@id='resourceAddPortForHttp']")
                .sendKeys("dbName");
        chromeDriver.findElementByXPath("//input[@id='resourceAddUserName']")
                .sendKeys("root");
        chromeDriver.findElementByXPath("//input[@id='resourceAddPassword']")
                .sendKeys("123456");
        chromeDriver.findElementByXPath("//button[@id='resourceAddApplyCompleteButton']").click();

        String msg = findElementUtilLoaded(By.className("toast-message")).getText();
        assertEquals("数据源添加成功！", msg);
        waitCompelled(2);
    }
}
