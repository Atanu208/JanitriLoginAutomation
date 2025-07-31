package tests;

import base.BaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    
    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginButtonEnabled()); 
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

        // Wait for the error div to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.className("invalid-credential-div")
        ));

        // Optional: Validate the error text
        String errorText = errorDiv.getText();
        System.out.println("Error Message Shown: " + errorText);

        Assert.assertTrue(errorText.contains("Error:"));
    }


    @Test
    public void testLoginPageElementsPresent() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded());
    }
}
