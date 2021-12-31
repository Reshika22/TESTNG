package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static ChromeDriver driver;
	public  String[][] data = new String[1][2];
	
	
	
	@BeforeMethod
	@Parameters({"url","username","password"})
	public void launch(String url,String userName , String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();

	}
	
	@AfterMethod
	public void close() {
		
		driver.close(); //close the browser

	}
	
	@DataProvider
	public String[][] input() {
		data[0][0] = "incident";
		data[0][1] = "Reset my password";
		return data;
		
	}

}
