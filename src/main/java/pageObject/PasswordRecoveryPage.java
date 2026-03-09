package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import java.time.Duration;

public class PasswordRecoveryPage {

    WebDriver driver;

    //Кнопка-ссылка 'Войти'
    private final By signInLink = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на кнопку-ссылку 'Войти'")
    public void clickSignInLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(signInLink));
        driver.findElement(signInLink).click();
    }
}