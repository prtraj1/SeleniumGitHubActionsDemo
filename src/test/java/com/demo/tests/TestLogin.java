package com.demo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase{

    By userNameTxtBox = By.id("user-name");
    By passwordTxtBox = By.id("password");
    By signInBtn = By.id("login-button");

    @Test
    public void validLoginTest(){
        driver.findElement(userNameTxtBox).sendKeys(uname);
        driver.findElement(passwordTxtBox).sendKeys(pwd);
        driver.findElement(signInBtn).click();
        Assert.assertTrue(driver.findElement(By.className("shopping_cart_link")).isDisplayed());
    }

    @Test
    public void invalidLoginTest(){
        driver.findElement(userNameTxtBox).sendKeys(uname);
        driver.findElement(passwordTxtBox).sendKeys(pwd + "--");
        driver.findElement(signInBtn).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message-container")).isDisplayed());
    }

}
