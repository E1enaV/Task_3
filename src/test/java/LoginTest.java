import base.StepUser;
import base.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PasswordRecoveryPage;
import pageObject.RegisterPage;
import static base.ApiUrl.*;
import static base.DataUser.*;

public class LoginTest extends BaseTest{

    @BeforeEach
    public void upUser() {
        StepUser stepUser = new StepUser();
        User user = StepUser.dataUser();
        Response response = stepUser.createUser(user);
        this.token = response.path("accessToken");
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void homePageSignInButtonCheck() {
        driver.get(BASE_URL);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        mainPage.clickSignInButton();
        loginPage.waitPageLoad();
        loginPage.login(RANDOM_EMAIL, PASSWORD);
        assertTrue(mainPage.placeOrderButtonAppeared(), "Кнопка 'Войти в аккаунт' не отображается");
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void accountButtonSighInCheck() {
        driver.get(BASE_URL);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.waitPageLoad();
        loginPage.login(RANDOM_EMAIL, PASSWORD);
        assertTrue(mainPage.placeOrderButtonAppeared(), "Кнопка 'Войти' не отображается");
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти' в форме регистрации")
    public void regPageSignInLinkCheck() {
        driver.get(REGISTRATION_PAGE_URL);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        registerPage.clickSignInButton();
        loginPage.waitPageLoad();
        loginPage.login(RANDOM_EMAIL, PASSWORD);
        assertTrue(mainPage.placeOrderButtonAppeared(), "Кнопка 'Войти' не отображается");
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти' в форме восстановления пароля")
    public void forgotPageSignInLinkCheck() {
        driver.get(PASSWORD_RECOVERY_URL);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        passwordRecoveryPage.clickSignInLink();
        loginPage.waitPageLoad();
        loginPage.login(RANDOM_EMAIL, PASSWORD);
        assertTrue(mainPage.placeOrderButtonAppeared(), "Кнопка 'Войти' не отображается");
    }
}