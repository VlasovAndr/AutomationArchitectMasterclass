package com.automationframework.pages.flightreservation;

import com.automationframework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightConfirmationPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);

    @FindBy(xpath = "//div[@class='row'][1]/div[2]")
    private WebElement flightConfirmationElement;

    @FindBy(xpath = "//div[@class='row'][2]/div[2]")
    private WebElement taxElement;

    @FindBy(xpath = "//div[@class='row'][3]/div[2]")
    private WebElement totalPriceElement;

    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationElement));
        return this.flightConfirmationElement.isDisplayed();
    }

    public String getPrice() {
        String confirmation = this.flightConfirmationElement.getText();
        String price = this.totalPriceElement.getText();
        log.info("Flight confirmation : {}", confirmation);
        log.info("Total price : {}", price);
        return price;
    }

}
