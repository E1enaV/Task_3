import base.StepUser;
import base.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static base.ApiUrl.*;
import static base.DataUser.*;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;

public class ProfilePageTest extends BaseTest{

    @BeforeEach
    public void upUserAndLogin() {
        StepUser stepUser = new StepUser();
        User user = StepUser.dataUser();
        Response response = stepUser.createUser(user);
        this.token = response.path("accessToken");

        driver.get(BASE_URL);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        mainPage.clickSignInButton();
        loginPage.waitPageLoad();
        loginPage.login(RANDOM_EMAIL, PASSWORD);
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void shouldGoToProfile() {
        profilePage = new ProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        profilePage.waitPageProfileLoad();
        assertEquals(PERSONAL_ACCOUNT_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор по клику на 'Конструктор'")
    public void shouldGoToConstructor() {
        profilePage = new ProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        profilePage.waitPageProfileLoad();
        profilePage.clickDesignerButton();
        assertTrue(mainPage.placeOrderButtonAppeared());
    }

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор по клику на логотип Stellar Burgers")
    public void shouldGoToHomePage() {
        profilePage = new ProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        profilePage.waitPageProfileLoad();
        profilePage.clickLogoButton();
        assertTrue(mainPage.placeOrderButtonAppeared());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void shouldExit() {
        profilePage = new ProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        profilePage.waitPageProfileLoad();
        profilePage.clickExitLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitPageLoad();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }
}