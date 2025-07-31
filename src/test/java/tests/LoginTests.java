package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    
    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.isLoginButtonEnabled());
    }

    @Test
    public void testPasswordMaskedButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("Test123");
        Assert.assertTrue(loginPage.isPasswordMasked());
        loginPage.togglePasswordVisibility();
        Assert.assertFalse(loginPage.isPasswordMasked());
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("invalid");
        loginPage.enterPassword("invalid");
        loginPage.clickLogin();
        // Add wait or sleep here if error takes time to appear
        Assert.assertTrue(driver.getPageSource().contains("Invalid") || driver.getPageSource().contains("error"));
    }

    @Test
    public void testLoginPageElementsPresent() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded());
    }
}
