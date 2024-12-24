package Tests.VendorPortal;

import Tests.BaseTest;
import Tests.VendorPortal.model.VendorPortolTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.VendorPortal.DashboardPage;
import pages.VendorPortal.LoginTestPage;
import utils.JsonUtil;

public class VendorDashboardTest extends BaseTest {
    private static final Logger log= LoggerFactory.getLogger(VendorDashboardTest.class);
    LoginTestPage vendorLoginTestPage;
    DashboardPage dashboardTestPage;
    private VendorPortolTest testdata;
    @BeforeTest
    @Parameters("testdatapath")
    public void setClass(String testdatapath){
        this.vendorLoginTestPage=new LoginTestPage(driver);
        this.dashboardTestPage =new DashboardPage(driver);
        this.testdata= JsonUtil.getTestData(testdatapath, VendorPortolTest.class);
    }
    @Test
    public void LoginTest()  {
        vendorLoginTestPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(vendorLoginTestPage.isAt());
        vendorLoginTestPage.Login(testdata.username(), testdata.password());
    }
    @Test(dependsOnMethods = "LoginTest")
    public void Dashboard(){
        Assert.assertTrue(dashboardTestPage.isAt());
        log.info(dashboardTestPage.getAnnualEarning());
        Assert.assertEquals(dashboardTestPage.getMonthlyEarning(),testdata.monthlyEarning());
        Assert.assertEquals(dashboardTestPage.getAnnualEarning(),testdata.annualEarning());
        Assert.assertEquals(dashboardTestPage.getProfitMargin(),testdata.profitMargin());
        Assert.assertEquals(dashboardTestPage.avaiableInventoryText(),testdata.availableInventory());
        dashboardTestPage.Logout();
    }
    @Test(dependsOnMethods = "Dashboard")
    public void Logout(){
        Assert.assertTrue(vendorLoginTestPage.isAt());
    }
}
