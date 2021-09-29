import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public Config config;
    WebDriver driver;
    WebDriverWait wait;

    public BaseTest() throws IOException
    {
        config = new Config("prod", "acc1");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait for all the actions
        wait = new WebDriverWait(driver, 5); //explicit wait
    }
    public BaseTest(@Optional("prod") String env, @Optional("acc1") String acc) throws IOException
    {
        config = new Config(env, acc);
    }
}
