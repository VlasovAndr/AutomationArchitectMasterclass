package com.automationframework.tests.flightreservation;

import com.automationframework.pages.flightreservation.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest {

    private WebDriver driver;
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupDriver(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

    @Test
    public void userRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium@docker.com", "docker");
        registrationPage.enterAddress("123 address", "atlanta", "30001");
        registrationPage.register();
    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConfirmationTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());
        registrationConfirmationPage.goToFlightsSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest() {
        FlightsSearchPage flightsSearchPage = new FlightsSearchPage(driver);
        Assert.assertTrue(flightsSearchPage.isAt());
        flightsSearchPage.selectPassengers(noOfPassengers);
        flightsSearchPage.searchFlights();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void flightsSelectionTest() {
        FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage(driver);
        Assert.assertTrue(flightsSelectionPage.isAt());
        flightsSelectionPage.selectFlights();
        flightsSelectionPage.confirmFlight();
    }

    @Test(dependsOnMethods = "flightsSelectionTest")
    public void flightConfirmationTest() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());
        Assert.assertEquals(flightConfirmationPage.getPrice(), expectedPrice);
    }
}
