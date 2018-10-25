package com.qa.Spring_Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addOwnersPage 
{
	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement firstName;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"address\"]")
	WebElement Address;
	
	@FindBy(xpath = "//*[@id=\"city\"]")
	WebElement City;
	
	@FindBy(xpath = "//*[@id=\"telephone\"]")
	WebElement Telephone;

	@FindBy(xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	WebElement addOwnerButton;
	
	public boolean Checkall = false;
	public boolean Inputed = false;
	
	
	public void inputData(String fName,String lName, String address, String city, String telephone)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		Address.sendKeys(address);
		City.sendKeys(city);
		Telephone.sendKeys(telephone);
		
	}
	
	public boolean checkAllInputed()
	{
		if(addOwnerButton.isEnabled())
		{
			Checkall = true;
			
		}
		
		return Checkall;
	}
}
