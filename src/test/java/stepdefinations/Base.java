package stepdefinations;

import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class Base {
	
	public WebDriver driver;
	public AdminPage ad;
	public ReadConfig readConfig;
	public AddNewCustomerPage addCust;

}
