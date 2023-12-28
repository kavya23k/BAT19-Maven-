package stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefination extends Base{
	// it's called as hooks in BDD cucumber 
    //@Before will execute before every scenario
	@Before
	public void setUp() throws Exception {
		System.out.println("Setup method execution");
	
	   readConfig = new ReadConfig(); // Create object of ReadConfig java class. 
	   
	   String browser = readConfig.getBrowser();
	   if(browser.equalsIgnoreCase("chrome")) {
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   Thread.sleep(2000);
		   
	   }else if (browser.equalsIgnoreCase("firefox"));{
	   driver=new FirefoxDriver();
	   driver.manage().window().maximize();
	   Thread.sleep(2000);
	   }
	}
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		driver=new ChromeDriver();
		ad=new AdminPage(driver);   // Create object of AdminPage java class 
	    
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
	    Thread.sleep(2000);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws InterruptedException {
		ad.setUsername(email);
		ad.setPassword(password);
	    Thread.sleep(2000);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
	    ad.clickOnLogin();
	}

	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) throws InterruptedException {
	    
		Assert.assertEquals(driver.getTitle(),title);
		Thread.sleep(2000);
	}

	//add new customer
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		addCust = new AddNewCustomerPage(driver);
		   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
		   Thread.sleep(2000);
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
	   
	addCust.clickOnCustomersMenu();
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() {
	addCust.clickOnCustomersMenuItem();
	}

	@When("User click on Add new button")
	public void user_click_on_add_new_button() throws InterruptedException {
	
	addCust.clickOnAddNewButton();
	Thread.sleep(2000);
		
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
	  Thread.sleep(2000);
	Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String newPassword, String firstName , String lastName, String gender, String compName, String AdminComment) throws InterruptedException {
	   
		  addCust.SetEmail(newEmail);
		  addCust.SetPassword(newPassword);
		  addCust.SetFirstName(firstName);
		  addCust.SetLastName(lastName);
		  addCust.SetGender(gender);
		//  addCust.enterDob("6/13/1988");
		//  addCust.enterManagerOfVendor("Vendor 1");
		  addCust.SetCompanyName(compName);
		  addCust.SetAdminContent(AdminComment);
		    Thread.sleep(2000);
	}

	@When("User click on save button")
	public void user_click_on_save_button() {
		addCust.clickOnSave();
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) throws InterruptedException {
	    Thread.sleep(2000);
	}

	@Then("Close browser")
	public void close_browser() {
	   
		driver.close();
	}
	
	
 
	//@After will execute after every scenario 
	@After
    public void tearDown(Scenario sc) throws Exception {
    	System.out.println("teardown method execute after each test case scenario");
    	if(sc.isFailed()==true) {
    	String filepath = "C:\\Users\\B5in\\eclipse-workspace\\11Nov23CucumberMavenProject\\screenshot\\failedscreenshot.png";
    	
    	//convert WebDriver object into Takescreenshot 
    	TakesScreenshot scrshot = ((TakesScreenshot)driver); 
    	
    	// call getscreenshotAs() to store image file 
    	File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
    	File destFile=new File(filepath); 
    	FileUtils.copyFile(scrFile, destFile);
    	Thread.sleep(2000);
    	driver.quit();
    	}
}
}