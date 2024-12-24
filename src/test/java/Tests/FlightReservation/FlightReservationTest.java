package Tests.FlightReservation;

import Tests.BaseTest;
import Tests.FlightReservation.model.FlightReservationTestdata;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FlightReservation.*;
import utils.JsonUtil;

public class FlightReservationTest extends BaseTest {
    FlightReservationTestdata flightReservationTestdata;
    @BeforeTest
    @Parameters("testdatapath")
    public void setFlightReservationTestdata(String testdatapath){
        this.flightReservationTestdata= JsonUtil.getTestData(testdatapath, FlightReservationTestdata.class);
    }
    @Test
    public void UserRegistrationTest(){
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.navigateTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());
        registrationPage.detailsEntryAndRegister(flightReservationTestdata.firstName(), flightReservationTestdata.lastName(),flightReservationTestdata.email(),flightReservationTestdata.password(),flightReservationTestdata.street(),flightReservationTestdata.city(),"Alabama", flightReservationTestdata.zip());
    }
    @Test(dependsOnMethods = "UserRegistrationTest")
    public void RegistrationConfirmation(){
        RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());
        registrationConfirmationPage.clickOnFlightsSearch();
    }
    @Test(dependsOnMethods = "RegistrationConfirmation")
    public void SearchPageTest(){
        SearchPage searchPage=new SearchPage(driver);
        Assert.assertTrue(searchPage.isAt());
        searchPage.SelectPassengers(flightReservationTestdata.passengersCount());
        searchPage.clickSearchResults();
    }
    @Test(dependsOnMethods = "SearchPageTest")
    public void FlightSelectionTest(){
        FlightSelectionTestPage flightSelectionTestPage=new FlightSelectionTestPage(driver);
        Assert.assertTrue(flightSelectionTestPage.isAt());
        flightSelectionTestPage.ConfirmFlight();
    }
    @Test(dependsOnMethods = "FlightSelectionTest")
    public void FlighConfirmationTest(){
        FlightsConfirmationPage flightsConfirmationPage=new FlightsConfirmationPage(driver);
        Assert.assertTrue(flightsConfirmationPage.isAt());
        String dta=flightsConfirmationPage.getDetails();
        Assert.assertEquals(dta,flightReservationTestdata.expectedPrice());
    }
}
