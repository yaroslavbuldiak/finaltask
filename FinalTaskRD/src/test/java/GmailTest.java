import configuration.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailMainPage;
import page.LoginPage;

public class GmailTest extends BaseTest {

    private LoginPage loginPage;
    private GmailMainPage gmailMainPage;

    @Test
    public void CheckReceivedMail(){
        loginPage = new LoginPage(driver);
        gmailMainPage = new GmailMainPage(driver);
        driver.get(TestData.URL);

        loginPage.login(TestData.LOGIN, TestData.PASSWORD);
        gmailMainPage.sendMail(TestData.LOGIN, TestData.SUBJECT, TestData.BODY);
        gmailMainPage.readNewLetter();

        Assert.assertTrue(gmailMainPage.checkMailText().contains(TestData.BODY));
    }
}
