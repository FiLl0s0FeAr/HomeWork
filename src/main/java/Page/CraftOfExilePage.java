package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CraftOfExilePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[text()='Body Armors']")
    WebElement bodyArmors;

    @FindBy(xpath = "//*[@id=\"poecBase2Selector\"]/div[3]/div[7]")
    WebElement bodyArmorSTR;

    @FindBy(xpath = "//*[@id=\"poecInfluenceSelector\"]/div[2]/div")
    WebElement influence;

    @FindBy(xpath = "//*[@id=\"poecInfluenceSelector\"]/div[3]/div[2]")
    WebElement influenceCrusader;

    @FindBy(xpath = "//*[text()='Enemies you Kill Explode, dealing 3% of their Life as Physical Damage']")
    WebElement modKillExplode;

    public CraftOfExilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickBodyArmors(){
        bodyArmors.click();
    }

    public void clickBodyArmorSTR(){
        wait.until(ExpectedConditions.visibilityOf(bodyArmorSTR));
        bodyArmorSTR.click();
    }

    public void clickInfluence(){
        wait.until(ExpectedConditions.visibilityOf(influence));
        influence.click();
    }

    public void clickInfluenceCrusader(){
        wait.until(ExpectedConditions.visibilityOf(influenceCrusader));
        influenceCrusader.click();
    }

    public void clickModKillExplode(){
        wait.until(ExpectedConditions.visibilityOf(modKillExplode));
        modKillExplode.click();
    }
}
