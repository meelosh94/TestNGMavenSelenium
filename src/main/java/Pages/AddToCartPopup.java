package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AddToCartPopup extends BasePage {

    By itemAddedLbl = By.xpath("/html/body/div[11]/div[2]/div/div/div[1]/svg");
    By viewShoppingCartButton = By.xpath("/html/body/div[11]/div[2]/div/div/div[1]/div/div[2]/a/button");

    public AddToCartPopup(WebDriver driver)
    {
        super(driver);
    }

    public boolean findItemAddedLbl()
    {
        try
        {
            driver.findElement(itemAddedLbl);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public void clickViewShoppingCartButton()
    {
        driver.findElement(viewShoppingCartButton).click();
    }
}
