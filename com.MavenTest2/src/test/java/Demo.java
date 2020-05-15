package test.java;

import org.testng.Reporter;
import org.testng.annotations.Test;

import main.java.com.actitime1.generics.Baseclass1;

public class Demo extends Baseclass1 {
	@Test
	public void test() {
		Reporter.log("hi",true);
}
}
