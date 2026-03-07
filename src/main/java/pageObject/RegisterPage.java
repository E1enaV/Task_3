package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import java.time.Duration;

public class RegisterPage {
    WebDriver driver;

    //Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Поле ввода "Имя"
    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");
    //Поле ввода "Email"
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    //Поле ввода "Пароль"
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    //Текст ошибки при неккоректном пароле
    private final By passwordErrorText = By.xpath(".//p[text()='Некорректный пароль']");
    //Кнопка-ссылка "Войти"
    private final By signInButton = By.linkText("Войти");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

   @Step("Заполнение поля ввода 'Имя'")
    public void sendKeysName(String name) {
       new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.visibilityOfElementLocated(nameInput));
       driver.findElement(nameInput).sendKeys(name);
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

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }

    @Step("Получение ошибки о некорректном пароле")
    public String getErrorText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordErrorText));
        return driver.findElement(passwordErrorText).getText();
    }

    @Step("Клик на кнопку-ссылку 'Войти'")
    public void clickSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();
    }

    @Step("Зарегистрироваться в приложении Stellar Burgers")
    public void registration(String name, String email,String password) {
        sendKeysName(name);
        sendKeysEmail(email);
        sendKeysPassword(password);
        clickRegisterButton();
    }
}