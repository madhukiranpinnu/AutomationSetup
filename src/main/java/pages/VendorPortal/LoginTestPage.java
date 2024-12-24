package pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class LoginTestPage extends BasePage {
    public LoginTestPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isAt() {
        webDriverWait.until(ExpectedConditions.visibilityOf(username_TextField));
        return username_TextField.isDisplayed();
    }
    @FindBy(id="username")
    private WebElement username_TextField;
    @FindBy(id="password")
    private WebElement password_TextField;
    @FindBy(id="login")
    private WebElement login_Button;
    public void Login(String userName,String passWord){
        this.username_TextField.sendKeys(userName);
        this.password_TextField.sendKeys(passWord);
        this.login_Button.click();
    }
    public void goTo(String url){
        driver.get(url);
    }
}
