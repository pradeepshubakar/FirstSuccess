package main.java.com.actitime1.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



import main.java.com.actitime1.pom.HomePage;
import main.java.com.actitime1.pom.LoginPage;

public class Baseclass1 {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static WebDriver driver;
	
	public FileLib f=new FileLib();
	
	
	
	
	
	//@Parameters("browser")
	@BeforeClass
	public void openBrowser() throws IOException {
		 String browser = f.getPropertyFileData("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
		}
	}
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		driver.get(f.getPropertyFileData("url"));
		 LoginPage l=new LoginPage(driver);
		l.getUnTbx().sendKeys(f.getPropertyFileData("username"));
		l.getPwTbx().sendKeys(f.getPropertyFileData("password"));
		l.getLoginButton().click();
		/*driver.findElement(By.xpath("//input[@id='username']")).sendKeys(f.getPropertyFileData("username"));
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(f.getPropertyFileData("password"));
		driver.findElement(By.xpath("//div[.='Login ']")).click();*/
		Thread.sleep(10);
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		 HomePage h=new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10);
		h.getLogOut().click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
