package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
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

	@Given("I have accepted cookies")
	public void i_have_accepted_cookies() throws InterruptedException { 
		click(driver, By.id("onetrust-accept-btn-handler"));
//		System.out.println("Cookies accepted");
		}

	private void click(WebDriver driver, By by) throws InterruptedException { 
//		Thread.sleep(1000);		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();	
	}

	@Given("I have input an email {string}")
	public void i_have_input_an_email(String mail) {

		if (mail.equals("blank")) {
			email = "";
//			System.out.println("No email");
		} else {
			email = username + mail;
//			System.out.println("Valid email");
		}
		driver.findElement(By.id("email")).sendKeys(email);
	}

	@Given("I have input a username {string}")
	public void i_have_input_a_username(String uname) {
		if (uname.equals("longName")) {
			String random = randomNumber(101);
			username = random;
//			System.out.println("Long username");
		} else {
			String random = randomNumber(16);
			username = random;
//			System.out.println("Short username");
		}
		driver.findElement(By.id("new_username")).sendKeys(username);
	}

	@Given("I have input a <password>")
	public void i_have_generated_a_password() {
		password = "TaQ1g5#h";
		driver.findElement(By.id("new_password")).sendKeys(password);
	}

	@Given("I have checked No Emails box")
	public void i_have_checked_no_emails_box() {
		if (!driver.findElement(By.cssSelector("#marketing_newsletter")).isSelected());	{
			driver.findElement(By.cssSelector("#marketing_newsletter")).click();
		}
	}

	@When("I press Sign Up {string}")
	public void i_press_sign_up(String signup) throws InterruptedException {
		click(driver, By.id("create-account"));
		
		if (signup.equals("nameTaken")) {			
			driver.get("https://login.mailchimp.com/signup/");
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("new_username")).sendKeys(username);
			driver.findElement(By.id("new_password")).sendKeys(password);
			click(driver, By.id("create-account"));
		} 
	}

	@Then("the {string} should be")
	public void the_should_be(String result) {
		if (result.equals("No email error")) {
			assertEquals(driver
					.findElement(By.cssSelector("div.login-field:nth-child(1) > div:nth-child(1) > span:nth-child(3)")).getText(),
					("Please enter a value"));
		}

		else if (result.equals("Account created")) {
			String url = driver.getCurrentUrl();
			Assert.assertTrue(url.contains("https://login.mailchimp.com/signup/success/?username=" + username));
			
//			assertEquals(driver.findElement(By.cssSelector("#signup-content > div > div > div > h1")).getText(),
//			("Check your email"));
		}

		else if (result.equals("Username taken error")) {
			assertEquals(driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span")).getText(),
					("Another user with this username already exists. Maybe it's your evil twin. Spooky."));
		}

		else if (result.equals("Username too long error")) {
			assertEquals(driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span")).getText(),
					("Enter a value less than 100 characters long"));
		}
		else {
			System.out.println("No matching assert");
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	private String randomNumber(Integer num) {
		// create a string of uppercase and lowercase characters and numbers
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		// combine all strings
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		// create random string builder
		StringBuilder sb = new StringBuilder(num);

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = num;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphaNumeric.length());

			// get character specified by index from the string
			char randomChar = alphaNumeric.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}
		String randomString = sb.toString();
//		System.out.println("Random String is: " + randomString);
		return randomString;
	}
}