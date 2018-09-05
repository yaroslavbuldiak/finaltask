package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class Reporter {
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports extent;
    private ExtentTest test;

    public void create(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/TestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void init(Method method){
        test = extent.createTest(method.getName());
    }

    public void addReport(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            test.fail(MarkupHelper.createLabel(result.getName()+" Test Case is FAILED", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            test.pass(MarkupHelper.createLabel(result.getName()+" Test Case is PASSED",ExtentColor.GREEN));
        }
        else {
            test.skip(MarkupHelper.createLabel(result.getName()+" Test Case is SKIPPED",ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }

    public void close(){
        extent.flush();
    }
}
