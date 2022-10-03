package com.demo.tests;

import com.demo.utils.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    public String url = "https://www.saucedemo.com/";

    public String uname = "standard_user";
    public String pwd = "secret_sauce";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser){
        BrowserFactory.setDriver(browser);
        driver = BrowserFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        BrowserFactory.getDriver().quit();
    }
}
