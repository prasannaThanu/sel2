package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;

	public static Properties credentials = new Properties();
	public static FileInputStream file;
	
	 public static  ExtentHtmlReporter htmlReporter;
	 public static  ExtentReports ext;
	 public static  ExtentTest test;

	@BeforeSuite
	public void  InitialSetup() throws IOException 
	{
		file = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//EnvironmentConfig//EnvironmentDetails.properties");
		credentials.load(file);

		String  ReportName = new SimpleDateFormat("MM-dd-yyyy_HH-SSS").format(new GregorianCalendar().getTime()) ;

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//Extent-Reports/"
				+"ExtentReports"+ReportName+".html");	
		
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"ExtentReports/"+"ExtentReports"+ReportName+".html");	
		ext = new ExtentReports();
		
		ext.attachReporter(htmlReporter);
		
		String ExtentReportTitle = "Manheim Test";

		System.out.println("1st ExtentReportTitle : " + ExtentReportTitle);
		test = ext.createTest(ExtentReportTitle);


		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demo.guru99.com/V1/index.php");

	}

	public static WebDriver driver()
	{
		return driver;
	}

	@AfterSuite
	public void QuitBrowser()
	{
		driver.quit();
		ext.flush();
	}

}
