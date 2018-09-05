import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import util.Reporter;

import java.lang.reflect.Method;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Reporter reporter = new Reporter();

    @BeforeClass
    public void oneTimeSetUp(){
       reporter.create();
    }

    @BeforeTest
    @Parameters("browser")
    public WebDriver setUp(String browser){
        if(browser.equals("chrome"))
            driver = new ChromeDriver();
        else if(browser.equals("firefox"))
            driver = new FirefoxDriver();
        return driver;
    }

    @BeforeMethod
    public void initReport(Method method){
        reporter.init(method);
    }

    @AfterMethod
    public void addResult(ITestResult result){
       reporter.addReport(result);
    }

    @AfterClass
    public void close(){
       reporter.close();
       driver.quit();
    }
}
