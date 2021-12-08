import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseModel extends BaseTest{
    WebDriverWait wait = new WebDriverWait(appiumDriver,20);

    public MobileElement findElement(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return appiumDriver.findElement(by);
    }

    public void clickElement(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void setText(By by,String text){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        findElement(by).sendKeys(text);
    }

    public String getText(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return findElement(by).getText();
    }

    public List<MobileElement> findElements(By by) {
        return appiumDriver.findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        try {
            return findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}
