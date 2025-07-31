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
    Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty.");
}

@Test
public void testPasswordMaskedButton() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterPassword("Test123");
    Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked initially.");
    loginPage.togglePasswordVisibility();
    Assert.assertFalse(loginPage.isPasswordMasked(), "Password should be unmasked after toggle.");
}

@Test
public void testInvalidLoginShowErrorMsg() {
    
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUserId("invalid");
    loginPage.enterPassword("invalid");
    loginPage.clickLogin();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    WebElement errorDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.className("invalid-credential-div")
    ));

    String errorText = errorDiv.getText().trim();
    System.out.println("Error Message Shown: " + errorText);

    Assert.assertTrue(errorText.contains("Invalid"), "Expected error message to contain 'Invalid'");
}

@Test
public void testLoginPageElementsPresent() {
    LoginPage loginPage = new LoginPage(driver);
    Assert.assertTrue(loginPage.isPageLoaded());
    Assert.assertTrue(driver.getTitle().contains("Janitri")); // Optional
}

}
