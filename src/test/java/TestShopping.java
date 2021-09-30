import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TestShopping extends BaseTest
{
        HomePage homePage;
        ItemsPage itemsPage;
        ItemPage itemPage;
        ShoppingCartPage shoppingCartPage;
        AddToCartPopup addToCartPopup;

    public TestShopping() throws IOException {
    }

    @BeforeClass
    private void Setup()
    {
        homePage = new HomePage(driver);
        itemsPage = new ItemsPage(driver);
        itemPage = new ItemPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        addToCartPopup = new AddToCartPopup(driver);

    }

    @Test
    public void TestCheckShoppingCart()
    {
        homePage.searchItem("volleyball");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/div[2]/div/div[2]/a[1]/div[1]/img")));

        itemsPage.clickOnFirstItem();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        itemPage.clickAddToCartButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div[2]/div")));
        addToCartPopup.clickViewShoppingCartButton();

        Assert.assertTrue(shoppingCartPage.waitForItem(), "Item didn't appear in cart!");
    }
}
