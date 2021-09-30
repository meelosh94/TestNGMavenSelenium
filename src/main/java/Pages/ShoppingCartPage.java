package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {

    By firstItemInCart = By.xpath("//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div");

    public ShoppingCartPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean waitForItem()
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemInCart));

            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
