package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    @FindBy(id = "identifierId")
    private WebElement loginField;

    @FindBy(xpath = "//*[@name = 'password']")
    private WebElement passwordField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String login, String password){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        loginField.sendKeys(login + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        passwordField.sendKeys(password + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }
}
