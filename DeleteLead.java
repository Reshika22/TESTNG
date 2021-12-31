package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DeleteLead extends BaseTest{
	
	
	@Test(dependsOnGroups={"Lead"}  , dataProvider = "sendInputDelete" )
	public void runDelete(String ph_Num) throws InterruptedException {


		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys(ph_Num);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// prabu's : .//*[text()='Lead ID']//ancestor::table//following::table[1]//tr[1]/td[1]//a

		//to avoid stale element expection 
		Thread.sleep(3000);

		String firstLead = driver.findElement(By.xpath("(.//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).getText();
		System.out.println("First Lead : " + firstLead);
		driver.findElement(By.xpath("(.//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).click();

		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstLead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String noRecord = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(noRecord.contains("No records"))
		{
			System.out.println(noRecord);
		}
		else
		{
			System.out.println("Record Exists");
		}

	}
	
	
}
