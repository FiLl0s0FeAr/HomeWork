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

    @FindBy(xpath = "//div[3]/div/input")
    WebElement remember;

    @FindBy(xpath = "//*[contains(text(), 'Forgot your password?')")
    WebElement forgot;

    @FindBy(xpath = "//*[text()='Sing In']")
    WebElement singIn;

    public SteamLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 3);
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String strLogin){
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.sendKeys(strLogin);
    }

    public void setPassword(String strPassword){
        wait.until(ExpectedConditions.elementToBeSelected(password));
        password.sendKeys(strPassword);
    }

    public void clickRemember(){
        remember.click();
    }
    public void clickSingIn(){
        singIn.click();
    }
}
