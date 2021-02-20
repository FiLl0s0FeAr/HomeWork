package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZKillboardPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//img")
    WebElement image;

    @FindBy(xpath = "/html/body/div[1]/div[2]/span/div[1]/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/a")
    WebElement name;

    @FindBy(id = "my_clock")
    WebElement time;

    @FindBy(xpath = "/html/body/div[1]/div[2]/span/div[1]/div[2]/table[1]/tbody/tr[5]/td[1]")
    WebElement iskEarned;

    @FindBy(xpath = "/html/body/div[1]/div[2]/span/div[1]/div[2]/table[1]/tbody/tr[5]/td[3]")
    WebElement iskLost;

    public ZKillboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public String getName(){
        wait.until(ExpectedConditions.visibilityOf(name));
        return name.getText();
    }

    public String getISKEarned(){
        return iskEarned.getText();
    }

    public String getISKLost(){
        return iskLost.getText();
    }

    public String getTime(){
        wait.until(ExpectedConditions.visibilityOf(time));
        return time.getText();
    }
}
