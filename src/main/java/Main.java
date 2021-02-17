import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://steamcommunity.com/sharedfiles/filedetails/?id=1446022987");

        driver.manage().window().maximize();
        LittleNightmaresTwoPage lntp = new LittleNightmaresTwoPage(driver);
        System.out.println(lntp.image.getTagName());
        System.out.println(lntp.image2.getTagName());
        System.out.println(lntp.getNameAchievments());
        System.out.println(lntp.webAward.getText());
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
        driver.quit();
    }
}
