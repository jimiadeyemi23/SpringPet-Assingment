package com.qa.Spring_Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class allOwnersPage 
{
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/div/button")
	WebElement addUsersButton;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[1]/td[1]/a")
	WebElement user;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody")
	WebElement OwnerTable;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[17]/td[1]/a")
	WebElement jimiade;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[16]/td[1]/a")
	WebElement jimi2;
	
	public boolean userExists = false;
	public boolean userTableExist = false;
	
	public boolean checkUser()
	{
		if(user.isDisplayed())
		{
			return userExists = true;
		}
		return userExists;
	}
	
	public void ClickAddUser()
	{
		addUsersButton.click();
	}
	
	public boolean CheckUserTable()
	{
		if(OwnerTable.isDisplayed() && user.isDisplayed())
		{
			userTableExist = true;
		}
		return userTableExist;
	}
	
	public void searchOwner(String input)
	{
		
	}

}
