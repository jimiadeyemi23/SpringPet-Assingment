package com.qa.Spring_Assessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step 
{
	
	WebDriver driver = null;
	
	static ExtentReports extent = new ExtentReports(constantVars.extentReports, true);
	ExtentTest test;
	
	public String FirstNameHolder = "";
	public int numOfOwners = 0;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", constantVars.chromeDriver);
		driver = new ChromeDriver();
	}
	
	
	@Given("^an owner exists within the database$")
	public void an_owner_exists_within_the_database() throws Throwable 
	{
		test = extent.startTest("testing the getAll method");
		test.log(LogStatus.INFO, "Start Test");
		driver.navigate().to(constantVars.allOwnersPage);
			
		allOwnersPage ownerspage = PageFactory.initElements(driver, allOwnersPage.class);
		//ownerspage.checkUser();
		
		if(ownerspage.checkUser() == true)
		{
			test.log(LogStatus.PASS, "There is a owner in the database");
		}
		else
		{
			test.log(LogStatus.FAIL, "No owners are present in the database");
		}
		assertEquals(true, ownerspage.checkUser());
	}

	@When("^the owner retrieves data about other owners$")
	public void the_owner_retrieves_data_about_other_owners() throws Throwable 
	{

		test.log(LogStatus.INFO, "the owner retrieves data about other owners");
		driver.navigate().to(constantVars.allOwnersPage);
		allOwnersPage ownerspage = PageFactory.initElements(driver, allOwnersPage.class);
		
		//ownerspage.CheckUserTable();
		
		if(ownerspage.CheckUserTable() == true)
		{
			test.log(LogStatus.PASS, "You can see all of the owners actively in the database");
		}
		else
		{
			test.log(LogStatus.FAIL, "No owners are present in the database");
		}
		assertEquals(true, ownerspage.CheckUserTable());
	}

	@Then("^the page has been loaded$")
	public void the_page_has_been_loaded() throws Throwable 
	{
		
		test.log(LogStatus.INFO, "The page loads");
		driver.navigate().to(constantVars.allOwnersPage);
		allOwnersPage ownerspage = PageFactory.initElements(driver, allOwnersPage.class);
		
		if(driver.getCurrentUrl().equals(constantVars.allOwnersPage))
		{
			test.log(LogStatus.PASS, "the page loaded correctly");
		}
		else
		{
			test.log(LogStatus.FAIL, "the page did not load");
		}
		assertEquals(constantVars.allOwnersPage, driver.getCurrentUrl());
		
	}

	@Given("^a new owners needs to be added$")
	public void a_new_owners_needs_to_be_added() throws Throwable 
	{
		test = extent.startTest("testing the Post method");
		test.log(LogStatus.INFO, "New Owner details have been inputed");
		driver.navigate().to(constantVars.addOwnersPage);
		addOwnersPage addOwner = PageFactory.initElements(driver, addOwnersPage.class);
		
		addOwner.inputData("jimi", "ade", "something", "MK", "076913486");
		FirstNameHolder = "jimi";
		
		if(addOwner.checkAllInputed())
		{
			test.log(LogStatus.PASS, "All input fields have been filled");
		}
		else
		{
			test.log(LogStatus.FAIL, "One of the fields is empty ");
		}
		
		assertEquals(true, addOwner.addOwnerButton.isEnabled());
		//extent.flush();
	}

	@When("^parameters have been added correctly$")
	public void parameters_have_been_added_correctly() throws Throwable 
	{
		test.log(LogStatus.INFO, "Check data has been inputed correctly");
		driver.navigate().to(constantVars.addOwnersPage);
		addOwnersPage addOwner = PageFactory.initElements(driver, addOwnersPage.class);
		addOwner.inputData("jimi", "ade", "something", "MK", "076913486");
		
		if(addOwner.checkAllInputed())
		{
			test.log(LogStatus.PASS, "All input fields have been filled");
		}
		else
		{
			test.log(LogStatus.FAIL, "One of the fields is empty ");
		}
		assertEquals(true, addOwner.checkAllInputed());
	}

	@Then("^the new owner has been added$")
	public void the_new_owner_has_been_added() throws Throwable 
	{
		test.log(LogStatus.INFO, "Check the created owner has been added to the database");
		driver.navigate().to(constantVars.allOwnersPage);
		allOwnersPage ownerspage = PageFactory.initElements(driver, allOwnersPage.class);
		numOfOwners =  driver.findElements(By.className("ownerFullName")).size();
//		System.out.println(driver.findElements(By.className("ownerFullName")).size());
		
		if(ownerspage.jimiade.getAttribute("ng-reflect-router-link").equals("/owners/22") )
		{
			test.log(LogStatus.PASS, "All input fields have been filled");
		}
		else
		{
			test.log(LogStatus.FAIL, "One of the fields is empty ");
		}
		assertEquals("/owners/22", ownerspage.jimiade.getAttribute("ng-reflect-router-link"));
		extent.flush();
	}

	@Given("^a owner exists with the last name \"([^\"]*)\"$")
	public void a_owner_exists_with_the_last_name(String arg1) throws Throwable 
	{
		test = extent.startTest("Testing search with paramateters");
		test.log(LogStatus.INFO, "Start Test");
		driver.navigate().to(constantVars.allOwnersPage);
		allOwnersPage ownerspage = PageFactory.initElements(driver, allOwnersPage.class);
		//System.out.println(arg1);
		
		if(ownerspage.jimi2.isDisplayed())
		{
			test.log(LogStatus.PASS, "the last name has been found");
		}
		else
		{
			test.log(LogStatus.FAIL, "Could not find the right owner");
		}
		assertEquals("jimi <lastName>", ownerspage.jimi2.getText());
	}

	@When("^the owner retrieves the owner with the last = name \"([^\"]*)\"$")
	public void the_owner_retrieves_the_owner_with_the_last_name(String arg1) throws Throwable 
	{
		a_owner_exists_with_the_last_name(arg1);
	}

	@Then("^the owner has been created$")
	public void the_owner_has_been_created() throws Throwable 
	{
		test.log(LogStatus.INFO, "The owner has been created");
		driver.navigate().to(constantVars.allOwnersPage);
		allOwnersPage ownerspage = PageFactory.initElements(driver, allOwnersPage.class);
		
		assertEquals("jimi <lastName>", ownerspage.jimi2.getText());
	}

	@When("^the owner deletes a owner with a specified id$")
	public void the_owner_deletes_a_owner_with_a_specified_id() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the owner has been deleted$")
	public void the_owner_has_been_deleted() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^an owner exists with the id$")
	public void an_owner_exists_with_the_id() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the manager retrieves owner with the id$")
	public void the_manager_retrieves_owner_with_the_id() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the owner with the id has been found$")
	public void the_owner_with_the_id_has_been_found() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^when the owner retrieves data about other owners$")
	public void when_the_owner_retrieves_data_about_other_owners() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^all owners have been found$")
	public void all_owners_have_been_found() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	public void teardown()
	{
		extent.flush();
	}
}
