package com.automationframework.pages.flightreservation;

import com.automationframework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightSearchBtn;

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstNameElement;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightSearchBtn));
        return this.goToFlightSearchBtn.isDisplayed();
    }

    public String getFirstName() {
        return firstNameElement.getText();
    }

    public void goToFlightsSearch() {
        this.goToFlightSearchBtn.click();
    }

}
