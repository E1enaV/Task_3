package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import java.time.Duration;

public class MainPage {
    WebDriver driver;

    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.linkText("Личный Кабинет");
    //Кнопка "Войти в аккаунт"
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Активная вкладка конструктора
    private final By activeTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    //Заголовок "Соберите бургер"
    public By constructorBurger = By.cssSelector("h1.text.text_type_main-large.mb-5.mt-10");
    //Раздел "Булки"
    private final By bunsTab = By.xpath(".//div/span[text()='Булки']");
    //Раздел "Соусы"
    private final By saucesTab = By.xpath(".//div/span[text()='Соусы']");
    //Раздел "Начинки"
    private final By fillingsTab = By.xpath(".//div/span[text()='Начинки']");
    //Кнопка "Оформить заказ"
    private final By placeOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Возврат названия активного раздела")
    public boolean getTextActiveTab() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(activeTab)).isDisplayed();
    }

    @Step("Клик на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик на кнопку 'Войти в аккаунт'")
    public void clickSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();
    }

    @Step("Клик на раздел 'Булки'")
    public void clickBuns() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(bunsTab));
        driver.findElement(bunsTab).click();
    }

    @Step("Клик на раздел 'Соусы'")
    public void clickSauces() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();
    }

    @Step("Клик на раздел 'Начинки'")
    public void clickFillings() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(fillingsTab));
        driver.findElement(fillingsTab).click();
    }

    @Step("Кнопка 'Оформить заказ' загрузилась")
    public boolean placeOrderButtonAppeared() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(placeOrderButton)).isDisplayed();
    }
}