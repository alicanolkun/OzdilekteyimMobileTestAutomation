import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage extends BaseModel{
    WebDriverWait wait = new WebDriverWait(appiumDriver,20);
    public static By SearchArea = By.id("edtSearch");
    public static By btn_Catagory = By.id("nav_categories");
    public static By txt_HomeTextile = By.xpath(".//*[@text='Ev Tekstili']");
    public static By btn_Woman = By.xpath(".//*[@text='Kadın']");
    public static By btn_Jean = By.xpath(".//*[@text='Pantolon']");

    @Step("Alisveris sayfanin acildigi gorulur")
    public void checkMainPageOpen(){
        Assert.assertEquals(getText(SearchArea),"Ara");
    }

    @Step("Kategoriler butonuna tiklanir")
    public void clicksOnCategoryButton(){
        clickElement(btn_Catagory);
    }

    @Step("Kategoriler sayfasinin acildigi gorulur")
    public void checkCategoriesPageOpened(){
        Assert.assertTrue(isElementDisplayed(txt_HomeTextile));
        logger.info("Kategoriler sayfasi acildi");
    }

   @Step("Kategorilerden kadin secilir")
    public void clicksOnWomanButton(){
       clickElement(btn_Woman);
        logger.info("Kadin kategorisine tiklandi");
       Assert.assertEquals(getText(btn_Woman),"Kadın");
        logger.info("Kadın kategorisi acildigi goruldu");
   }

    @Step("Pantalon butonuna tiklanir")
    public void clicksOnJeansButton(){
        clickElement(btn_Jean);
        logger.info("Pantalon butonuna tiklandi");
    }

}
