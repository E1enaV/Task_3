import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import pageObject.LoginPage;
import pageObject.RegisterPage;
import static base.ApiUrl.REGISTRATION_PAGE_URL;
import static base.DataUser.*;

public class RegisterTest extends BaseTest {

    @Test
    @Description("Регистрация с валидными данными")
    public void shouldSuccessReg() {
        driver.get(REGISTRATION_PAGE_URL);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.registration(RANDOM_NAME, RANDOM_EMAIL, PASSWORD);
        loginPage.waitPageLoad();
        loginPage.clickSignInButton();
        boolean actual = loginPage.waitPageLoad();
        assertTrue(actual, "Текст 'Вход' не найден");
    }

    @Test
    @Description("Регистрация с некорректным паролем")
    public void regShouldBeError() {
        driver.get(REGISTRATION_PAGE_URL);
        registerPage = new RegisterPage(driver);
        registerPage.registration(RANDOM_NAME, RANDOM_EMAIL, "pass");
        String actual = registerPage.getErrorText();
        assertEquals("Некорректный пароль", actual);
    }
}