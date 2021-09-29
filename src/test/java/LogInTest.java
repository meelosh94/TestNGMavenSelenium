import Pages.HomePage;
import Pages.LoginPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LogInTest extends BaseTest {

    String url, username, password;

    HomePage homePage;
    LoginPopup loginPopup;

    public LogInTest() throws IOException {
    }

    @BeforeClass
    private void Setup()
    {
        url = config.getUrl();
        username = config.getUsername();
        password = config.getPassword();

        homePage = new HomePage(driver);
        loginPopup = new LoginPopup(driver);
    }

    @BeforeMethod
    private void beforeMethod()
    {
        driver.get(url);
    }

    @Test
    private void TestLogInTrue()
    {
        homePage.clickSignInButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='batman-dialog-wrap']/div")));
        loginPopup.enterUsername(username);
        loginPopup.enterPassword(password);
        loginPopup.clickSignInButton();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='batman-dialog-wrap']/div")));
        homePage.hoverAccountHover();
        Assert.assertTrue(homePage.findSignOutButton(), "You are not logged in!");
    }

    @Test(dataProvider = "falseCredentials")
    private void TestLogInFalse(String username, String password)
    {
//        driver.get(url);
        homePage.clickSignInButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='batman-dialog-wrap']/div")));
        loginPopup.enterUsername(username);
        loginPopup.enterPassword(password);
        loginPopup.clickSignInButton();

        Assert.assertTrue(loginPopup.waitForIncorrectCredentials(), "Incorrect credentials message not found!");
//        driver.close();
    }

    @DataProvider(name = "falseCredentials")
    public static Object[][] falseCredentials()
    {
        return new Object[][]{
                {"xxx@yyy.zzz", "fakePassword"},
                {"123@456.x", "Password123"}
        };
    }

//    @AfterMethod
//    private void AfterMethod() throws InterruptedException {
//        driver.quit();
//    }
}
