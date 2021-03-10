import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGLittleNightmaresTwo {
    public String baseURLLittleNightmaresTwo = "https://steamcommunity.com/sharedfiles/filedetails/?id=1446022987";
    public WebDriver driver;

    @BeforeTest
    public void setBaseURLLittleNightmaresTwo(){
        System.setProperty("webdriver.chrome.driver","./chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.get(baseURLLittleNightmaresTwo);
    }

    @Test(description = "Verify page title")
    public void verifyHomePageTitle(){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Steam Community :: Guide :: [112%] Полное руководство по получению всех достижений");
    }

    @Test()
    public void verifyHornetAchievement(){
        WebElement hornetAchievement = driver.findElement(By.xpath("//*[text()=\"Испытание решительности\"]"));
        String expectedHornetAchievement = "Испытание решительности";
        String actualHornetAchievement = hornetAchievement.getText();
        Assert.assertEquals(actualHornetAchievement, expectedHornetAchievement);
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}

