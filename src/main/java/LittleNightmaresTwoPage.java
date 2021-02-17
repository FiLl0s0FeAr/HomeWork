import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LittleNightmaresTwoPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//*[@id=\"2635637\"]/div[2]/a/img")
    WebElement image2;

    @FindBy(xpath = "//*[text()='Фальшь']")
    WebElement firstAchievements;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div[5]/div[4]/div[5]/div[4]/div[1]/span")
    WebElement webAward;

    @FindBy(xpath = "//img")
    WebElement image;

    @FindBy(xpath = "//*[text()='login']")
    WebElement login;

    public LittleNightmaresTwoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public String getNameAchievments() throws InterruptedException {
        //wait.wait(10000);
        return firstAchievements.getText();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.visibilityOfAllElements(login));
        login.click();
    }

}
