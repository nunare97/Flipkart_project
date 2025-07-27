package Flipkart_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Mobile_purchase {
	static WebDriver  driver;
	static String expectedresult,iphone16;
	static long start;
	@BeforeClass
	public static void browserSetup()
	{
		// browser setup
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Naresh\\eclipse-workspace\\Naresh\\ProjectClassDayOne\\target\\msedgedriver.exe");
		driver=new EdgeDriver();
		//System.out.println("Browser is launched....");
	}
	@AfterClass
	public static void browserquit() {
		if (driver != null) {
			driver.quit();  // Quit browser
		}
	}
	@Before
    public void startTime() {
        start = System.currentTimeMillis();
        System.out.println("before");
    }
 
    @After
    public void endTime() {
        long end = System.currentTimeMillis();
        System.out.println("After total time = " + (end - start));
    }
	@Test
	public void method1() {
		//flipkart launch
		driver.get("https://www.flipkart.com/");
	}
	@Test
	public void method2() {
		//search iphone 16 
		WebElement searchbar=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input"));
		searchbar.sendKeys("iphone 16",Keys.ENTER);
	}
	@Test
	public void method3() {
		WebElement iphone1=driver.findElement(By.xpath("(//div[contains(text(),'iPhone')])[1]"));
	  expectedresult=iphone1.getText();
		System.out.println(expectedresult);
		iphone1.click();
		
		Set<String> allWindows=driver.getWindowHandles();
		List<String> l=new ArrayList(allWindows);
		driver.switchTo().window(l.get(1));
	}
	@Test
	public void method4() {
		iphone16=driver.findElement(By.xpath("//span[@class='VU-ZEz']")).getText();
		System.out.println(iphone16);
		 
	}
	@Test
	public void method5() {
		if(expectedresult == iphone16) {
			System.out.println("validation pass");
		}else {
			System.out.println("validation failed");
		}
	}

	

}
