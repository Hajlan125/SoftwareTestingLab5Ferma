package Pages;

import Utility.Configuration;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SideMenuPage {
    AndroidDriver driver;

    public SideMenuPage(AndroidDriver driver) {
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

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]")
    public MobileElement sendedMails;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[14]")
    public MobileElement settingsButton;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[16]")
    public MobileElement logoutButton;


}
