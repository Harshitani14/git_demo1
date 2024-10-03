package NewProject.NewProject;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class LoginPage {
	    WebDriver driver;

	    // Locators for login elements
	    By username = By.id("username");
	    By password = By.name("pwd");
	    By loginButton = By.id("loginButton");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void enterUsername(String uname) {
	        driver.findElement(username).sendKeys(uname);
	    }

	    public void enterPassword(String pwd) {
	        driver.findElement(password).sendKeys(pwd);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	}


