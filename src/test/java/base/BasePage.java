package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testcases.MailTravelPageClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
WebDriver driver;
	

@BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        if(browser.equalsIgnoreCase("edge")) {
           //WebDriverManager.chromedriver().setup();
        	System.out.println("inside edge");
        	System.setProperty("webdriver.edge.driver", "C:\\Users\\amits\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
        	  WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get("https://www.mailtravel.co.uk/");
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    
}