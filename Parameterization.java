package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameterization extends BaseTest{
	
	@Test(dataProvider = "sendData")
	public void dataCreate(String companyName , String firstName , String lastName)
	{
		driver.findElement(By.linkText("Create Lead")).click(); // create leads option click
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName); // enter company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName); // enter first name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName); // enter last name
		driver.findElement(By.name("submitButton")).click(); 
	}
	
	
	@DataProvider
	public String[][] sendData() {

		String[][] data = new String[2][3];
		
		data[0][0]= "BNYM Technologies";
		data[0][1]= "Reshika";
		data[0][2]= "Prabu";

		data[1][0]= "BNYM Technologies";
		data[1][1]= "Hari";
		data[1][2]= "Ragu";

		return data;
	}
}
