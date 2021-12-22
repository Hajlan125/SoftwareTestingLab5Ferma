package Pages;

import Utility.Configuration;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AuthorizationPage {
    AndroidDriver driver;


    public AuthorizationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    public void clickTo(MobileElement element){
        new WebDriverWait(driver, Configuration.TIMEOUTS).until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void sendTextTo(MobileElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    @AndroidFindBy(id = "ru.yandex.mail:id/list_yandex")
    public MobileElement yandexList;

    @AndroidFindBy(id = "ru.yandex.mail:id/edit_login")
    public MobileElement editLoginField;

    @AndroidFindBy(id = "ru.yandex.mail:id/edit_password")
    public MobileElement editPasswordField;

    @AndroidFindBy(id = "ru.yandex.mail:id/button_next")
    public MobileElement nextButton;

    public void clickYandex(){
        if (yandexList.isDisplayed()) {
            yandexList.click();
        }
    }
}
