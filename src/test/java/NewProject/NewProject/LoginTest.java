package NewProject.NewProject;


	import java.time.Duration;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class LoginTest {

	  WebDriver driver;
	    LoginPage loginPage;

	    @BeforeTest
	    public void setUp() {
	        // Set up WebDriver (ChromeDriver example)
	       System.setProperty("webdriver.chrome.driver", "E:\\NewProject\\Drivers\\chromedriver.exe");
	    	 driver = new ChromeDriver();
	    	WebDriverManager.chromedriver().setup();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.get("http://localhost/login.do");
	        loginPage = new LoginPage(driver);
	    }

	    @Test
	    public void testLogin() {
	        loginPage.enterUsername("admin");
	        loginPage.enterPassword("manager");
	        loginPage.clickLogin();

	        // Add an assertion for successful login
	        String expectedUrl = "https://demo.actitime.com/user/submit_tt.do";
	        String actualUrl = driver.getCurrentUrl();
	        Assert.assertEquals(actualUrl, expectedUrl);
	    }
	    @DataProvider(name = "loginData")
	    public Object[][] provideData() {
	        return new Object[][] {
	            {"admin", "manager"},
	            {"invalidUser", "invalidPass"}
	        };
	    }

	    @Test(dataProvider = "loginData")
	    public void testLoginWithDataProvider(String username, String password) {
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickLogin();
	        
	        if (username.equals("admin")) {
	            Assert.assertTrue(driver.getCurrentUrl().contains("submit_tt.do"));
	        } else {
	            Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	        }
	    }
	   

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	        
	        
	    }
	}
