package com.automationframework.tests;

import com.automationframework.pages.vendorportal.DashboardPage;
import com.automationframework.pages.vendorportal.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
