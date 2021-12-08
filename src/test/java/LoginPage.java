import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseModel{
    WebDriverWait wait = new WebDriverWait(appiumDriver,20);
    public static By btn_Login= By.id("btnLogin");
    public static By tbx_Email= By.id("etEposta");
    public static By tbx_Password= By.id("etPassword");
    public static By btn_Back= By.id("ivBack");


    @Step("Login sayfasinin acildigi gorulur")
    public void checkLoginPage(){
        Assert.assertTrue("Login sayfası acilmadi!",isElementDisplayed(btn_Login));
        logger.info("Login sayfasi acildi");
    }

    @Step("E-posta adresi <key> olarak girilir")
    public void setEmailAddress(String emailAddress){
        setText(tbx_Email,emailAddress);
        logger.info("E-posta adresi "+emailAddress+" olarak girildi.");
    }

    @Step("Parola <key> olarak girilir")
    public void setPassword(String password){
        setText(tbx_Password,password);
        logger.info("Şifre girildi.");
    }

    @Step("Geri butonuna tıklar")
    public void backButtonClick(){
        clickElement(btn_Back);
       logger.info("Geri butonuna tiklandi.");
    }
}


