package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SteamLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "username")
    WebElement login;

    @FindBy(id = "input_password")
    WebElement password;

    @FindBy(xpath = "//*[contains(text(), 'Forgot your password?')")
    WebElement forgot;

    @FindBy(xpath = "//*[@id=\"login_btn_signin\"]/button")
    WebElement singIn;

    public SteamLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String strLogin){
        wait.until(ExpectedConditions.visibilityOfAllElements(login));
        login.sendKeys(strLogin);
    }

    public void setPassword(String strPassword){
        wait.until(ExpectedConditions.visibilityOfAllElements(password));
        password.sendKeys(strPassword);
    }

    public void clickSingIn(){
        singIn.click();
    }
}
