import Pages.*;
import Utility.JSONService;
import Utility.Retry;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MainTest {
    AndroidDriver driver;
    DesiredCapabilities desiredCapabilities;
    AuthorizationPage autorizationPage;
    CreatingMailPage creatingMailPage;
    AndroidFilesPage androidFilesPage;
    SideMenuPage sideMenuPage;
    MailPage mailPage;
    SendedMailPage sendedMailPage;
    SettingsPage settingsPage;
    User user;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        setAndroidCapabilities();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        user = new User().init("user");
        driver.resetApp();
    }

    @Test
    public void mainTest() throws IOException {
        auth().clickTo(auth().yandexList);

        auth().sendTextTo(auth().editLoginField, user.userLogin);
        auth().clickTo(auth().nextButton);

        auth().sendTextTo(auth().editPasswordField, user.userPassword);
        auth().clickTo(auth().nextButton);

        //auth().clickTo(auth().goToMailButton);
        mail().clickTo(mail().goToMailButton);

//        mail().clickTo(mail().menuButton);
//        mail().clickTo(mail().sentMailsButton);
//        mail().clickTo(mail().menuButton);
//        mail().clickTo(mail().settingsButton);
        mail().clickTo(mail().createNewMail);
        crMail().clickTo(crMail().allowButton);
        crMail().sendTextTo(crMail().receiver, "AdRGaraev1@yandex.ru");
        crMail().clickTo(crMail().attachFile);
        crMail().clickTo(crMail().allowButton);
        crMail().clickTo(crMail().allowButton);
        crMail().clickTo(crMail().fileFromPhoneButton);
        files().clickTo(files().image);
        crMail().clickTo(crMail().resolutionButton);
        crMail().clickTo(crMail().send);

        mail().clickTo(mail().menuButton);
        sideMenu().clickTo(sideMenu().sendedMails);
        driver.swipe(940,340,180, 340, 500);
        sendedMail().clickTo(sendedMail().menuButton);

        sideMenu().clickTo(sideMenu().settingsButton);
        settings().clickTo(settings().themeSwitch);
        driver.swipe(500,1450,500, 400, 500);
        driver.swipe(500,1450,500, 400, 500);
        settings().clickTo(settings().clearCache);
        settings().clickTo(settings().returnButton);

        sideMenu().clickTo(sideMenu().logoutButton);
    }

    
    public void setAndroidCapabilities(){
        this.desiredCapabilities =  new DesiredCapabilities();
        JSONObject appiumJson = JSONService.readJsonFromFile("src/test/resources/androidSim.json");
        JSONObject caps = JSONService.getCapabilities(appiumJson);
        caps.keySet().forEach(keyStr -> this.desiredCapabilities.setCapability(keyStr, caps.get(keyStr)));
        try {
            this.driver = new AndroidDriver<MobileElement>(new URL(JSONService.getUrl(appiumJson)),this.desiredCapabilities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    public AuthorizationPage auth() {
        return Objects.requireNonNullElseGet(this.autorizationPage, () -> new AuthorizationPage(driver));
    }
    public MailPage mail() {
        return Objects.requireNonNullElseGet(this.mailPage, () -> new MailPage(driver));
    }
    public CreatingMailPage crMail() {
        return Objects.requireNonNullElseGet(this.creatingMailPage, () -> new CreatingMailPage(driver));
    }
    public AndroidFilesPage files() {
        return Objects.requireNonNullElseGet(this.androidFilesPage, () -> new AndroidFilesPage(driver));
    }
    public SideMenuPage sideMenu() {
        return Objects.requireNonNullElseGet(this.sideMenuPage, () -> new SideMenuPage(driver));
    }
    public SendedMailPage sendedMail() {
        return Objects.requireNonNullElseGet(this.sendedMailPage, () -> new SendedMailPage(driver));
    }
    public SettingsPage settings() {
        return Objects.requireNonNullElseGet(this.settingsPage, () -> new SettingsPage(driver));
    }

}
