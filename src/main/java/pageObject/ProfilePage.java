package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import java.time.Duration;

public class ProfilePage {
    WebDriver driver;

    //Кнопка "Профиль"
    private final By personalAccountLink = By.xpath("//*[text()='Профиль']");;
    //Кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    //Логотип Stellar Burgers
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка "Конструктор"
    private final By designerButton = By.xpath("//*[text()='Конструктор']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы профиля")
    public void waitPageProfileLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountLink));
    }

    @Step("Клик на кнопку 'Выйти'")
    public void clickExitLink() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

    @Step("Клик на логотип Stellar Burgers")
    public void clickLogoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(logoButton));
        driver.findElement(logoButton).click();
    }

    @Step("Клик на кнопку 'Конструктор'")
    public void clickDesignerButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(designerButton));
        driver.findElement(designerButton).click();
    }
}