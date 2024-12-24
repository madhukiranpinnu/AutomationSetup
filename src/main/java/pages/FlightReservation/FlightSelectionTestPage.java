package pages.FlightReservation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionTestPage extends BasePage {
    @FindBy(name="departure-flight")
    private List<WebElement> departure_RadioButton;
    @FindBy(name="arrival-flight")
    private List<WebElement> arraival_Radiobutton;
    @FindBy(id = "confirm-flights")
    private WebElement confirmFlights_Button;

    public FlightSelectionTestPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isAt() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(confirmFlights_Button));
        return this.confirmFlights_Button.isDisplayed();
    }
    public void ConfirmFlight(){
        int rand1= ThreadLocalRandom.current().nextInt(0,arraival_Radiobutton.size());
        this.arraival_Radiobutton.get(rand1).click();
        int rand2=ThreadLocalRandom.current().nextInt(0,departure_RadioButton.size());
        this.departure_RadioButton.get(rand2).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",this.confirmFlights_Button);
    }
}
