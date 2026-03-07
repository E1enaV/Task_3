package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    //Заголовок "Вход"
    private final By textInput = By.xpath(".//h2[text()='Вход']");
    //Поле ввода "Email"
    private final By emailInput = By.xpath(".//fieldset[1]//input");
    //Поле ввода "Пароль"
    private final By passwordInput = By.xpath(".//fieldset[2]//input");
    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что элемент загрузился")
    public boolean waitPageLoad() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(textInput)).isDisplayed();
    }

    @Step("Заполнение поля ввода 'Email'")
    public void sendKeysEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение поля ввода 'Пароль'")
    public void sendKeysPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Авторизация в приложении Stellar Burgers")
    public void login(String email, String password) {
        sendKeysEmail(email);
        sendKeysPassword(password);
        clickSignInButton();
    }
}