package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	public WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//web elements
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	By lnkCustomers_menu=By.xpath("//a[@href='#']//p[contains (text(),'Customers')]");

	
	By lnkCustomers_menu_item=By.xpath("//p[text()=' Customers']");
	
	By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
	
	By txt_Email=By.xpath("//input[@id='Email']");
	
	By txt_password=By.xpath("//input[@id='Password']");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	
	By txtLastName = By.xpath("//input[@id='LastName']");
	
	By rdGenderMale=By.xpath("//input[@id='Gender_Male']");
	
	By rdGenderFemale=By.xpath("//input[@id='Gender_Female']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompany_name=By.xpath("//input[@id='Company']");
	
	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;
	
	By txtAdmin_comment=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	
	//User defined methods
	
	public String getPageTitle() {
	return ldriver.getTitle();
	}
	public void clickOnCustomersMenu() {
	ldriver.findElement(lnkCustomers_menu).click();
	}
	public void clickOnCustomersMenuItem() {
	ldriver.findElement(lnkCustomers_menu_item).click();
	}
	public void clickOnAddNewButton() {
	ldriver.findElement(btnAddNew).click();
	}
	public void SetEmail(String email) {
	ldriver.findElement(txt_Email).sendKeys(email);
	}
	public void SetPassword(String password) {
	ldriver.findElement(txt_password).sendKeys(password);
    }
    public void SetFirstName(String fname) {
    	ldriver.findElement(txtFirstName).sendKeys(fname);
    }
    public void SetLastName(String lname) {
    ldriver.findElement(txtFirstName).sendKeys(lname);
    }
    public void SetGender(String gender) {
    if(gender.equals("Male")){
    ldriver.findElement(rdGenderMale).click();
    }
    else {
	ldriver.findElement(rdGenderFemale).click();
    }
    }
    public void enterDob(String dob){
    ldriver.findElement(txtDob).sendKeys(dob);
    }
    public void SetCompanyName(String comName) {
	ldriver.findElement(txtCompany_name).sendKeys(comName);
    }
    public void enterManagerOfVendor(String value)
	{
		Select drp=new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}
    public void SetAdminContent(String content) {
	ldriver.findElement(txtAdmin_comment).sendKeys(content);
    }
    public void clickOnSave() {
	ldriver.findElement(btnSave).click();
    }
}
    
    
    
    
    
    