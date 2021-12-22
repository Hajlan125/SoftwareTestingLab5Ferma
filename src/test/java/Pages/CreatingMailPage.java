package Pages;

import Utility.Configuration;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreatingMailPage {
    AndroidDriver driver;

    public CreatingMailPage(AndroidDriver driver) {
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
    public void sendImage() throws IOException {
        driver.pushFile("sdcard/Download/z-toxic.jpg", new File("z-toxic.jpg"));
    }

    @AndroidFindBy(id = "ru.yandex.mail:id/copy_edit_text")
    public MobileElement receiver;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public MobileElement denyButton;
    @AndroidFindBy(id = "ru.yandex.mail:id/attach_file")
    public MobileElement attachFile;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement allowButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Low']")
    public MobileElement resolutionButton;
    @AndroidFindBy(id = "ru.yandex.mail:id/menu_send")
    public MobileElement send;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='File from phone'")
    public MobileElement fileFromPhoneButton;
}
