package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void setDriver() throws MalformedURLException {
        if(Boolean.getBoolean("selenium.grid.enabled")){
            this.driver = getRemoteDriver();
        }
        else{
            this.driver=getLocalDriver();
        }
    }
    private WebDriver getLocalDriver(){
        if(System.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
            return driver;
        }
        else{
            driver=new FirefoxDriver();
            return driver;
        }
    }
    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities;
        if(System.getProperty("browser").equalsIgnoreCase("chrome")){
            capabilities=new ChromeOptions();
        }
        else {
            capabilities=new FirefoxOptions();
        }
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
