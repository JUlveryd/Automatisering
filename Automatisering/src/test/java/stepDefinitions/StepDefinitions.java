package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;
	private String email;
	private String username;
	private String password;
	

		@Given("I have navigated to the website")
		public void i_have_navigated_to_the_website() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://login.mailchimp.com/signup/");
		}

		@Given("I have generated an <email>")
		public void i_have_generated_an_email() {			
			Random r = new Random();
		    email = "dgbsjkgsbgaksjgabkg35378";
		    for (int i = 0; i < 10; i++) {
		        System.out.print(email.charAt(r.nextInt(email.length())));
		    }//System.out.print(email + "@gmail.com"); // prints 10 random characters from alphabet		    
		driver.close();
		}
		@Given("I have entered it into the email field")
		public void i_have_entered_it_into_the_email_field() {
		    driver.findElement(By.id("email")).sendKeys(email + "@gmail.com");
		    
		}
		@Given("I have generated a <username>")
		public void i_have_generated_a_username() {
			username = email;
		    
		}
		@Given("I have entered it into the username field")
		public void i_have_entered_it_into_the_username_field() {
			driver.findElement(By.id("new_username")).sendKeys(username);
		}
		@Given("I have generated a <password>")
		public void i_have_generated_a_password() {
		    password = "TaQ1g5#h";
		}
		@Given("I have entered it into the password field")
		public void i_have_entered_it_into_the_password_field() {
			driver.findElement(By.id("new_password")).sendKeys(password);
		}
		@When("I press Sign Up")
		public void i_press_sign_up() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

}