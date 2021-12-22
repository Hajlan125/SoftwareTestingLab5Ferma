import Utility.Retry;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FarmTest extends MainTest {
    @Test(retryAnalyzer = Retry.class, testName = "Auth")
    public void authTesting() throws InterruptedException {

    }


}
