package com.automationframework.pages.flightreservation;

import com.automationframework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightsSelectionPage extends AbstractPage {

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsBtn;

    public FlightsSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsBtn));
        return this.confirmFlightsBtn.isDisplayed();
    }

    public void selectFlights() {
        int random = ThreadLocalRandom.current().nextInt(0, departureFlightOptions.size());
        this.departureFlightOptions.get(random).click();
        this.arrivalFlightOptions.get(random).click();
    }

    public void confirmFlight() {
        this.confirmFlightsBtn.click();
    }

}
