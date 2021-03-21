import Page.CraftOfExilePage;
import Page.LittleNightmaresTwoPage;
import Page.SteamLoginPage;
import Page.ZKillboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://steamcommunity.com/sharedfiles/filedetails/?id=1446022987");

        driver.manage().window().maximize();

        LittleNightmaresTwoPage lntp = new LittleNightmaresTwoPage(driver);
        System.out.println(lntp.getNameAchievments());
        lntp.clickLogin();

        SteamLoginPage slp = new SteamLoginPage(driver);
        slp.setLogin("FiLL");
        slp.setPassword("FiLL");
        slp.clickSingIn();

        driver.get("https://zkillboard.com/character/2114938111/");
        ZKillboardPage zlb = new ZKillboardPage(driver);
        System.out.println(zlb.getName());
        System.out.println(zlb.getTime());
        System.out.println(zlb.getISKEarned());
        System.out.println(zlb.getISKLost());

        driver.get("https://www.craftofexile.com/");
        CraftOfExilePage coep = new CraftOfExilePage(driver);
        coep.clickBodyArmors();
        coep.clickBodyArmorSTR();
        coep.clickInfluence();
        coep.clickInfluenceCrusader();
        coep.clickModKillExplode();

    }
}
