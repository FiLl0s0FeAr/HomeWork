import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static io.qameta.allure.Allure.step;

public class TestNGCraftOfExile {
    public String baseURLCraftOfExile = "https://www.craftofexile.com/";
    public WebDriver driver;

    @BeforeMethod(description = "Configure something before test")
    public void setBaseURLCraftOfExile(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURLCraftOfExile);
    }

    @Test(description = "Verify page title")
    public void verifyHomePageTitle(){
        step("Simple step");
        String expectedTitle = "Craft of Exile";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Verify russian language")
    public void verifyLanguages(){
        WebElement language = driver.findElement(By.xpath("//*[@id=\"clngsel\"]/div/img"));
        language.click();
        WebElement russianLanguage = driver.findElement(By.xpath("//*[@id=\"clngsel\"]/div/div/div[5]"));
        String expectedLanguage = "Русский";
        String actualLanguage = russianLanguage.getText();
        Assert.assertEquals(actualLanguage, expectedLanguage);
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}
