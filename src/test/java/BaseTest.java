import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import base.StepUser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.*;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected PasswordRecoveryPage passwordRecoveryPage;
    protected RegisterPage registerPage;
    protected String token;
    protected ProfilePage profilePage;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        StepUser stepUser = new StepUser();
        if (token != null) {
            stepUser.deleteUser(token);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}