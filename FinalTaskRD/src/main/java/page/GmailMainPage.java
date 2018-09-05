package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GmailMainPage extends BasePage {

    @FindBy(xpath = "//*[@class = 'z0']")
    private WebElement writeButton;

    @FindBy(xpath = "//*[@name = 'to']")
    private WebElement to;

    @FindBy(xpath = "//*[@name = 'subjectbox']")
    private WebElement subject;

    @FindBy(xpath = "//*[@class = 'Am Al editable LW-avf']")
    private WebElement body;

    @FindBy(xpath = "//*[@class = 'T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement send;

    @FindBy(xpath = "//*[@class = 'yX xY ']")
    private WebElement newLetter;

    @FindBy(className = "gs")
    private WebElement receivedMail;

    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    public void sendMail(String toData, String subjectData, String bodyData){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        writeButton.click();
        to.sendKeys(toData);
        subject.sendKeys(subjectData);
        body.sendKeys(bodyData);
        send.click();
        wait.until(ExpectedConditions.elementToBeClickable(writeButton));
    }

    public void readNewLetter(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        newLetter.click();
    }

    public String checkMailText(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return receivedMail.getText();
    }
}
