package week5.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public ChromeDriver driver;
	public String fileName;
	public String[] input = new String[1];
	@Parameters({"username","password"})
	@BeforeMethod
	public void loginLead(String username , String password) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);//username enter
		driver.findElement(By.id("password")).sendKeys(password); //password enter
		driver.findElement(By.className("decorativeSubmit")).click(); // submit button click
		driver.findElement(By.linkText("CRM/SFA")).click(); // crm/sfa button click
		driver.findElement(By.linkText("Leads")).click();  // leads tab click

	}
	
	
	@DataProvider
	public String[][] sendData() throws IOException {
		fileName = "CreateLead";
		return DataExcelRead.readData(fileName);
	}
	
	@DataProvider
	public String[] sendInputDelete() {
		input[0] = "98";
		return input;

	}
	
	@DataProvider
	public String[] sendInputDuplicate() {
		input[0] = "babu@testleaf.com";
		return input;

	}
	
	@DataProvider
	public String[] sendInputEdit() {
		input[0] = "Babu";
		return input;

	}

	@AfterMethod
	public void close() {
		
		driver.close(); //close the browser

	}
}
