package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import selenium.SeleniumHelper;

public class DuplicateLead extends BaseTest {
	
@Test(dataProvider = "sendInputDuplicate" , groups = {"Lead"})
	public  void runDuplicate(String email) throws InterruptedException {

		SeleniumHelper.click(driver, By.linkText("Find Leads"));


		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(email);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);

		String firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]//a")).getText();
		System.out.println("First Lead : " + firstLead);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]//a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if(driver.getTitle().contains("Duplicate Lead"))
		{
			System.out.println("Duplicate Lead Page is verified");			
		}
		else
		{
			System.out.println("Duplicate Lead Page is not verified");
		}

		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String duplicateLead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(firstLead.equals(duplicateLead))
		{
			System.out.println("Name Captured Matched with Duplicate Name");

		}
		else
		{
			System.out.println("Name Captured Not Matched with Duplicate Name");

		}
		
	}

}
