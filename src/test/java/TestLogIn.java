import Pages.HomePage;
import Pages.LoginPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class TestLogIn extends BaseTest {

    HomePage homePage;
    LoginPopup loginPopup;

    public TestLogIn() throws IOException {
    }

    @BeforeClass
    private void Setup()
    {
        homePage = new HomePage(driver);
        loginPopup = new LoginPopup(driver);
    }

    @BeforeMethod
    private void beforeMethod()
    {
        driver.get(url);
    }


    /*
    Test for positive log in scenario
    Precondition:
    1.User is logged out

    Actions:
    1. Click 'sign in' button
    2. Enter credentials
    3. Click 'sign in' button

    Assert:
    1. 'Welcome back' message should be visible
     */
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
        Assert.assertTrue(homePage.findWelcomeBackLbl(), "You are not logged in!");
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

    @Test
    public void TestLogOut()
    {
        homePage.clickSignInButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='batman-dialog-wrap']/div")));
        loginPopup.enterUsername(username);
        loginPopup.enterPassword(password);
        loginPopup.clickSignInButton();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='batman-dialog-wrap']/div")));
        homePage.hoverAccountHover();
        Assert.assertTrue(homePage.findWelcomeBackLbl(), "You are not logged in!");

        homePage.clickSignOutButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form-searchbar']/div[2]"))); //wait for page to reload
        homePage.hoverAccountHover();
        Assert.assertFalse(homePage.findWelcomeBackLbl(), "You are still logged in!");

    }

//    @AfterMethod
//    private void AfterMethod() throws InterruptedException {
//        driver.quit();
//    }
}
