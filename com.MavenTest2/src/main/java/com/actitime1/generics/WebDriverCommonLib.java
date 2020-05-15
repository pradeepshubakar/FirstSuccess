package main.java.com.actitime1.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib extends Baseclass1{

	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void waitForElementLoad(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementInGui(WebElement element) throws InterruptedException {
		int count=0;
		while(count<=20) {
			try {
				element.isEnabled();
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
}
