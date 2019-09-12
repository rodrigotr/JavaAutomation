package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class FirstSession {

    private WebDriver driver;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/vendor/chromedriver 2");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void dropdownTest(){
        driver.findElement(By.linkText("Dropdown")).click();

        WebElement title = driver.findElement(By.cssSelector("div .example h3"));

        assertTrue(title.getText().equals("Dropdown List"));

        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown"));
        Select dropdownselect = new Select(dropdown);
        dropdownselect.selectByVisibleText("Option 2");

        assertTrue(dropdownselect.getFirstSelectedOption().getText().equals("Option 2"));

        System.out.println("RTR");

    }

    @Test
    public void checkboxTest(){
        driver.findElement(By.linkText("Checkboxes")).click();

        WebElement title = driver.findElement(By.cssSelector("div .example h3"));

        assertTrue(title.getText().equals("Checkboxes"));

        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)"));
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)"));
        checkbox2.click();

        assertTrue(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());

        System.out.println("RTR");

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
