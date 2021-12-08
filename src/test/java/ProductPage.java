import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductPage extends BaseModel {
    WebDriverWait wait = new WebDriverWait(appiumDriver,20);
    public static By img_prodcut = By.id("textView");
    public static By btn_cart = By.id("ivAddCart");
    public static By btn_Fav = By.id("imgFav");
    public static By btn_ProductSize = By.id("tvInSizeItem");
    public static By btn_AddToCart = By.xpath(".//*[@text='SEPETE EKLE']");

    @Step("<int> kere sayfada aşagi dogru kaydir")
    public void scrollUsingTouchActionsByElements(int times) throws InterruptedException {

        Dimension dimension = appiumDriver.manage().window().getSize();
        int startx = (int) (dimension.width * 0.5);
        int starty = (int) (dimension.height * 0.8);
        int endx = (int) (dimension.width * 0.2);
        int endy = (int) (dimension.height * 0.2);
        TouchAction touchActions = new TouchAction(appiumDriver);
        for (int i = 0; i < times; i++) {
            touchActions.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release().perform();
            Thread.sleep(1000);
            System.out.printf("%d%d", endx, endy);
        }

    }
    @Step("rastgele ürün seçilir")
    public void selectRandomlyElement() {
        List<MobileElement> elements = appiumDriver.findElements(By.id("textView"));
        Random random = new Random();
        int randomInt = random.nextInt(elements.size());
        elements.get(randomInt).click();
    }
    @Step("Urun detay sayafasinin acildigi kontrol edilir")
    public void checkProductDetailPageOpened(){
        Assert.assertTrue(isElementDisplayed(btn_cart));
        logger.info("urun sayfasi acildi");
    }

    @Step("favori butonuna tiklanir")
    public void clickByFavorite(){
        clickElement(btn_Fav);
        logger.info("Favoriler butonuna tıklandı");
    }

    @Step("urun bedeni secilir")
    public void selectProductSize(){
        clickElement(btn_ProductSize);
        logger.info("urun bedeni secildi");
    }


    @Step("Sepete ekle butonuna tıklanır")
    public void addToCart(){
        clickElement(btn_AddToCart);
        logger.info("Sepete ekle butonuna tıkladı");
    }

}

