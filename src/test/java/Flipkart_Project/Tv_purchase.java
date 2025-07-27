package Flipkart_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Tv_purchase {
	static WebDriver  driver;
	static String expectedresult,redmii;
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
		searchbar.sendKeys("Redmi tv",Keys.ENTER);
	}
	@Test
	public void method3() {
		WebElement redmitv=driver.findElement(By.xpath("//div[contains(text(),'Mi Xiaomi 80 cm')]"));
	    expectedresult=redmitv.getText();
		System.out.println(expectedresult);
		redmitv.click();
		
		Set<String> allWindows=driver.getWindowHandles();
		List<String> l=new ArrayList(allWindows);
		driver.switchTo().window(l.get(1));
	}
	@Test
	public void method4() {
		redmii=driver.findElement(By.xpath("//span[@class='VU-ZEz']")).getText();
		System.out.println(redmii);
		 
	}
	@Ignore
	@Test
	public void method5() {
		if(expectedresult == redmii) {
			System.out.println("validation pass");
		}else {
			System.out.println("validation failed");
		}
	}

	
}
