package LoginTests.ErrMsg;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest 
{
	private static ChromeDriver driver;
	private static String testUrl = "http://abv.bg";
	
	private static String abvGdprLocator = "abv-GDPR-frame";
	private static String gdprConsLocator = "gdpr-consent-notice";
	private static String accCookLocator = "save";
	private static String userLocator = "username";
	private static String passLocator = "password";
	private static String logButLocator = "loginBut";
	private static String errMsgLocator = "form.errors";
	
	private static String wrongUser = "admin@abv.bg";
	private static String wrongPass = "admin123WrongPassword";
	private static String expectedErr = "Грешен потребител / парола.";

	@BeforeAll
	public static void openBrowser(){
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@Test
	public void testWebsite(){
	    System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	    driver.get(testUrl);
	    driver.manage().window().maximize();
	    
        driver.switchTo().frame(abvGdprLocator);

        driver.switchTo().frame(gdprConsLocator);
        
        WebElement acceptCookiesButton=driver.findElement(By.id(accCookLocator));
        acceptCookiesButton.click();
        
        WebElement username=driver.findElement(By.id(userLocator));
        WebElement password=driver.findElement(By.id(passLocator));
        WebElement loginButton=driver.findElement(By.id(logButLocator));
        
        username.sendKeys(wrongUser);
        password.sendKeys(wrongPass);
        loginButton.click();
        
        WebElement errorMsg=driver.findElement(By.id(errMsgLocator));
        
        Assertions.assertEquals(expectedErr, errorMsg.getText());	    
	    
	    System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@AfterAll
	public static void closeBrowser(){
		driver.quit();
	}
}
