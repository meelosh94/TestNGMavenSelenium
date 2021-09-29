package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopup extends BasePage
{
    By usernameTB = By.xpath("//*[@id='fm-login-id']");
    By passwordTB = By.xpath("//*[@id='fm-login-password']");
    By signInButton = By.xpath("//*[@id='batman-dialog-wrap']/div/div[2]/div/div/button");
    By incorrectCredentials = By.xpath("//*[text()='Your account name or password is incorrect.']");

    public LoginPopup(WebDriver driver)
    {
        super(driver);
    }

    public void enterUsername(String username)
    {
        driver.findElement(usernameTB).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        driver.findElement(passwordTB).sendKeys(password);
    }

    public void clickSignInButton()
    {
        driver.findElement(signInButton).click();
    }

    public boolean waitForIncorrectCredentials()
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectCredentials));

            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
