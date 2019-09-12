package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void typeUsername(String username){
        getDriver().findElement(By.id("username")).sendKeys(username);
    }

    public void typePassword(String password){
        getDriver().findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton(){
        getDriver().findElement(By.cssSelector("button")).click();
    }

    public void loginWithUsernameAndPassword(String username, String password){
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
    }


}
