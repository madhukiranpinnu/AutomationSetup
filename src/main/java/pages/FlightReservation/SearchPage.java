package pages.FlightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class SearchPage extends BasePage {
    @FindBy(id="twoway")
    private WebElement twoway_Radiobutton;
    @FindBy(id = "oneway")
    private WebElement oneway_Radiobutton;
    @FindBy(id="search-flights")
    private WebElement searchFlifhts;
    @FindBy(id="passengers")
    private WebElement passengers_Dropdown;
    public SearchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        webDriverWait.until(ExpectedConditions.visibilityOf(twoway_Radiobutton));
        return twoway_Radiobutton.isDisplayed();
    }
    public void clickSearchResults(){
        this.searchFlifhts.click();
    }
    public void SelectPassengers(String value){
        Select select=new Select(passengers_Dropdown);
        select.selectByValue(value);
    }
}
