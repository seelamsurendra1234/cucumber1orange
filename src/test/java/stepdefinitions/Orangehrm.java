

package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class Orangehrm
{

	public static WebDriver ssr;
 public static String empid;
	@Given("i open browser with a url {string}")
	public void i_open_browser_with_a_url(String url) {
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	      ssr=new ChromeDriver();
	     ssr.manage().deleteAllCookies();
	     ssr.manage().window().maximize();
		ssr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ssr.get(url);
	}
	@Then("i should see login page")
	public void i_should_see_login_page() {
		if(ssr.findElement(By.id("btnLogin")).isDisplayed());
		{
		System.out.println("login module is displayed");
		}
	}
	    
	
	@When("i click on login button")
	public void i_click_on_login_button() {
		
	    ssr.findElement(By.id("btnLogin")).click();
	}
	@Then("i should see admin module")
	public void i_should_see_admin_module() {
	    if(ssr.findElement(By.linkText("Admin")).isDisplayed())
	    {
	    	System.out.println("admin module is displayed");
	    }
	}
	@When("i click on logout")
	public void i_click_on_logout() {
	 ssr.findElement(By.partialLinkText("Welcome")).click();
	 ssr.findElement(By.linkText("Logout")).click();
	}
	@When("i close browser")
	public void i_close_browser() {
	   ssr.close();
	
	}
	
	@Then("i should see appropriate error message")
	public void i_should_see_appropriate_error_message() {
	  String errmsg=ssr.findElement(By.id("spanMessage")).getText();
	  if(errmsg.toLowerCase().contains("invalid")||errmsg.toLowerCase().contains("empty"))
	  {
		  System.out.println("system should display appropriate error message");
	  }
	
	}
	@When("i enter password as  {string}")
	public void i_enter_password_as(String pwd) {
		ssr.findElement(By.id("txtPassword")).sendKeys(pwd); 
	}

	
	@When("i enter username as  {string}")
	public void i_enter_username_as7(String uid) {
		ssr.findElement(By.id("txtUsername")).sendKeys(uid);
	}
	@When("i enter password as   {string}")
	public void i_enter_password_as7(String pwd) {
		ssr.findElement(By.id("txtPassword")).sendKeys(pwd);
	}

	@Given("i open a browse with url {string}")
	public void i_open_a_browse_with_url(String url) {
		ssr=new ChromeDriver();
	     ssr.manage().deleteAllCookies();
	     ssr.manage().window().maximize();
		ssr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ssr.get(url);
	}
	@When("i enter user name as  {string}")
	public void i_enter_user_name_as(String uid) {
		ssr.findElement(By.id("txtUsername")).sendKeys(uid);
	}
	@When("i click login button")
	public void i_click_login_button() {
		ssr.findElement(By.id("btnLogin")).click();  
	}
	@When("i click on PIM")
	public void i_click_on_pim() {
	 ssr.findElement(By.linkText("PIM")).click();   
	}
	@When("i click on Addemployee")
	public void i_click_on_addemployee() {
	    ssr.findElement(By.linkText("Add Employee")).click();
	}
	
	@When("i enter first name as  {string}")
	public void i_enter_first_name_as(String fname) {
		ssr.findElement(By.id("firstName")).sendKeys(fname); 
	}
	@When("i enter last name as  {string}")
	public void i_enter_last_name_as(String lname) {
		ssr.findElement(By.id("lastName")).sendKeys(lname);
	}
	
	
	@When("click on save button")
	public void click_on_save_button() {
		empid=ssr.findElement(By.id("employeeId")).getAttribute("value");
		ssr.findElement(By.id("btnSave")).click(); 

	
	}
	@When("click on logout")
	public void click_on_logout() {
	   ssr.findElement(By.partialLinkText("Welcome")).click();
	   ssr.findElement(By.linkText("Logout")).click();
	}
	@When("i close the browser")
	public void i_close_the_browser() {
	  ssr.close();  
	
	}
	@Then("i should see employee list")
	public void i_should_see_employee_list() {
		ssr.findElement(By.linkText("Employee List")).click();
		ssr.findElement(By.id("empsearch_id")).sendKeys(empid); 
		ssr.findElement(By.id("searchBtn")).click();
		WebElement table=ssr.findElement(By.id("resultTable"));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				System.out.println("id present in the table,test pass");
			}else
			{
				System.out.println("id does not present in the table,test fail");
			}
		} 
	}
}
	