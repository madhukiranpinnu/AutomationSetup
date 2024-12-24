package pages.FlightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class RegistrationConfirmationPage extends BasePage {
    private WebDriver driver;
    @FindBy(id="go-to-flights-search")
    private WebElement gotoSearchButton;
    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
       webDriverWait.until(ExpectedConditions.visibilityOf(gotoSearchButton));
       return gotoSearchButton.isDisplayed();
    }

    public void clickOnFlightsSearch(){
        this.gotoSearchButton.click();
    }
}
