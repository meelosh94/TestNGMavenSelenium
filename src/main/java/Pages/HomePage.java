package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    By accountHover = By.xpath("//*[@id='nav-user-account']/span");
    By signInButton = By.xpath("//*[@id='nav-user-account']/div/div/p[3]/a[2]");
    By signOutButton = By.xpath("//*[@id='nav-user-account']/div/div/div/p/b");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void hoverAccountHover()
    {
        Actions action = new Actions(driver);
        WebElement accHover = driver.findElement(accountHover);
        action.moveToElement(accHover).build().perform();
    }

    public void clickSignInButton()
    {
        hoverAccountHover();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        driver.findElement(signInButton).click();
    }

    public boolean findSignOutButton() {
        try
        {
            driver.findElement(signOutButton);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
