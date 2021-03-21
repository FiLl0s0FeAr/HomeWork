package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LittleNightmaresTwoPage {
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//*[text()='Фальшь']")
    WebElement firstAchievements;

    @FindBy(xpath = "//*[text()='login']")
    WebElement login;

    public LittleNightmaresTwoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public String getNameAchievments() throws InterruptedException {
        return firstAchievements.getText();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.visibilityOfAllElements(login));
        login.click();
    }

}
