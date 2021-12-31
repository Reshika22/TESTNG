package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class CreateLead extends BaseTest{
	
	
	//WebDriver will always open a new browser
	@Test(dataProvider = "sendData", groups = {"Lead"} , alwaysRun = true , enabled = true)
	public void runCreate
	(String companyName , String firstName , String lastName ,
	 String source , String marketing , String localfName ,
	 String locallName , String personTitle , String dob ,
	 String profTitle , String department , String annualRevenue ,
	 String country , String currency , String industry ,
	 String empNumber , String owner , String sicCode ,
	 String symbol , String description , String note ,
	 String cntryCode , String areaCode , String ph_num ,
	 String ph_ext , String ask_Name , String email ,
	 String website , String toName , String attnName ,
	 String address1 , String address2 , String city ,
	 String state , String postCode , String postExt 
			) throws InterruptedException {


		driver.findElement(By.linkText("Create Lead")).click(); // create leads option click
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName); // enter company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName); // enter first name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName); // enter last name

		//WebElement lastNameTextBox = driver.findElement(By.id("createLeadForm_lastName"));
		//lastNameTextBox.sendKeys(lastName);

		WebElement elementDropdownSource = driver.findElement(By.id("createLeadForm_dataSourceId")); 
		Select selectSource = new Select(elementDropdownSource);
		selectSource.selectByVisibleText(source);

		WebElement elementDropdownMarketing = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select selectMarket = new Select(elementDropdownMarketing);
		selectMarket.selectByVisibleText(marketing);

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(localfName); 
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys(locallName); 
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys(personTitle); 
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys(dob); 
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys(profTitle); 
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(department); 
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys(annualRevenue); 

		//WebElement elementDropdown1 = driver.findElement(By.id("createLeadForm_generalCountryGeoId")); 
		//Select select1 = new Select(elementDropdown1);
		//select1.selectByVisibleText("Ireland");
		//select1.selectByValue("IRL");
		//select1.selectByIndex(0);
		WebElement elementDropdownCountry = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select selectCountry = new Select(elementDropdownCountry);
		selectCountry.selectByVisibleText(country); 

		WebElement elementDropdownCurrency = driver.findElement(By.id("createLeadForm_currencyUomId")); 
		Select selectCurr = new Select(elementDropdownCurrency);
		selectCurr.selectByVisibleText(currency);

		WebElement elementDropdownIndustry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select selectInd = new Select(elementDropdownIndustry);
		selectInd.selectByValue(industry);

		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys(empNumber); 

		WebElement elementDropdownOwner = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select selectOwn = new Select(elementDropdownOwner);
		selectOwn.selectByVisibleText(owner);

		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys(sicCode); 
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys(symbol); 
		driver.findElement(By.id("createLeadForm_description")).sendKeys(description); 
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys(note); 

		//Create Lead section 2 -->Contact Information
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys(cntryCode); 
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys(areaCode); 
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(ph_num); 
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys(ph_ext); 
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys(ask_Name); 
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email); 
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys(website); 

		//Create Lead Section 3 -->Primary Address
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys(toName); 
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys(attnName); 
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys(address1); 
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys(address2); 
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys(city); 

		WebElement elementDropdownState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selectState = new Select(elementDropdownState);
		selectState.selectByVisibleText(state);

		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys(postCode); 
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys(postExt); 
		//Thread.sleep(3000);

		driver.findElement(By.name("submitButton")).click(); // submit button click

		//Get the title
		String title = driver.getTitle();
		System.out.println("Title of the web page :" + title);
		System.out.println(System.getProperty("webdriver.chrome.driver"));

		// Get first Name and Print
		String firstNameLead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("First Name : " + firstNameLead);

	}
	

}
