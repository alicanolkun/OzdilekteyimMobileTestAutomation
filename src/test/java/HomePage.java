import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseModel{
    public static By btn_StartShopping = By.id("tv_startShoppingStore");

    @Step("<wait> saniye bekle")
    public void waitForsecond(int wait) throws InterruptedException {
        Thread.sleep(1000*wait);
        logger.info(wait + "saniye bekledi !!!");
    }

    @Step("Anasayfanin acildigi kontrol edilir")
    public void checkHomePageOpened(){
        Assert.assertEquals(getText(btn_StartShopping),"ALIŞVERİŞE BAŞLA");
    }

    @Step("Alisverise basla butonuna tiklanir")
    public void clickStartShoppingButton(){
        clickElement(btn_StartShopping);
        logger.info("Alisverise basla butonuna tıklandı!!!");
    }

}
