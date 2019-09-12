package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static org.testng.Assert.assertTrue;

public class TestLogin extends BaseTest {



    @Test
    public void loginSucceeded() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginWithUsernameAndPassword("tomsmith", "SuperSecretPassword!");
        assertTrue(getWebDriver().findElement(By.cssSelector(".flash.success")).isDisplayed());
        //tarea crear homepage y hacer el assert a homepage
    }
    @Test
    public void loginFail() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginWithUsernameAndPassword("asdkjh", "SuperSecretPassword!");
        assertTrue(getWebDriver().findElement(By.cssSelector(".flash.success")).isDisplayed());
    }




}

