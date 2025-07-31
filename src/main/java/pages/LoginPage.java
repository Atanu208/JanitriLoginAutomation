package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
        WebDriver driver;

    private By userIdInput = By.xpath("//input[@placeholder='Enter your User ID']");
    private By passwordInput = By.xpath("//input[@placeholder='Enter your Password']");
    private By loginButton = By.xpath("//button[contains(text(),'Log In')]");
    private By eyeIcon = By.xpath("//button[contains(@class,'password-toggle')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String userId) {
        driver.findElement(userIdInput).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        String type = driver.findElement(passwordInput).getAttribute("type");
        return type.equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }

    public boolean isPageLoaded() {
        return driver.findElement(userIdInput).isDisplayed() &&
               driver.findElement(passwordInput).isDisplayed() &&
               driver.findElement(loginButton).isDisplayed();
    }
}
