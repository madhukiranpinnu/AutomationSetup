package pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class DashboardPage extends BasePage {
    private static final Logger log= LoggerFactory.getLogger(DashboardPage.class);
    @Override
    public boolean isAt() {
        webDriverWait.until(ExpectedConditions.visibilityOf(montlyEarning_Text));
        return this.montlyEarning_Text.isDisplayed();
    }
    public DashboardPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="monthly-earning")
    private WebElement montlyEarning_Text;
    @FindBy(id="annual-earning")
    private WebElement annualEarning_Text;
    @FindBy(id="profit-margin")
    private WebElement profitMargin_Text;
    @FindBy(id="available-inventory")
    private WebElement available_Inventory;
    @FindBy(xpath = "//*[@type='search']")
    private WebElement search_TextField;
    @FindBy(id="dataTable_info")
    private WebElement searchResults_CountText;
    @FindBy(css = "img.img-profile")
    private WebElement userProfilePictureElement;
    // prefer id / name / css
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;
    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutButton;
    public String getMonthlyEarning(){
        return montlyEarning_Text.getText();
    }
    public String getAnnualEarning(){
        return annualEarning_Text.getText();
    }
    public String getProfitMargin(){
        return profitMargin_Text.getText();
    }
    public String avaiableInventoryText(){
        return available_Inventory.getText();
    }
    public void sendSearch(String search){
        search_TextField.sendKeys(search);
    }
    public Integer searchResults(){
        String resultsText = this.searchResults_CountText.getText();
        String[] arr = resultsText.split(" ");
        // if we do not have 5th item, it would throw exception.
        // that's fine. we would want our test to fail anyway in that case!
        int count = Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }
    public void Logout(){
        webDriverWait.until(ExpectedConditions.visibilityOf(userProfilePictureElement));
        userProfilePictureElement.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(modalLogoutButton));
        modalLogoutButton.click();
    }
}
