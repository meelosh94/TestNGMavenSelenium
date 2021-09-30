package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {

    By addToCartButton = By.xpath("//*[@id='root']/div/div[2]/div/div[2]/div[11]/span[2]/button");

    public ItemPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickAddToCartButton()
    {
        driver.findElement(addToCartButton).click();
    }
}
