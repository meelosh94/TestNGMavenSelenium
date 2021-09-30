package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsPage extends BasePage {

    By firstItem = By.xpath("//*[@id='root']/div/div/div[2]/div[2]/div/div[2]/a[1]/div[1]/img");

    public ItemsPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnFirstItem()
    {
        driver.findElement(firstItem).click();
    }
}
