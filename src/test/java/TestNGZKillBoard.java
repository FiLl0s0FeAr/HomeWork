import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGZKillBoard {
    public String baseURLZKillboard = "https://zkillboard.com/character/2114938111/";
    public WebDriver driver;

    @BeforeTest
    public void setBaseURLTestNGZKillBoard(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.get(baseURLZKillboard);
    }

    @Test(description = "Verify character name")
    public void verifyCharacterName(){
        String expectedName = "Fill Lunaris";
        WebElement name = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div[1]/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/a"));
        String actualName = name.getText();
        Assert.assertEquals(actualName, expectedName);
    }

    @Test()
    public void verifyRecentActivity(){
        WebElement recentActivity = driver.findElement(By.xpath("//*[text()=\"Recent Activity\"]"));
        String expectedResentActivity = recentActivity.getText();
        Assert.assertEquals(expectedResentActivity, "Recent Activity");
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}