package com.automationframework.pages.flightreservation;

import com.automationframework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightsSearchPage extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement passengersSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsBtn;

    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengersSelect));
        return this.passengersSelect.isDisplayed();
    }

    public void selectPassengers(String noOfPassengers) {
        Select passengers = new Select(passengersSelect);
        passengers.selectByValue(noOfPassengers);
    }

    public void searchFlights() {
        searchFlightsBtn.click();
    }

}
