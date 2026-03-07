import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pageObject.MainPage;
import static base.ApiUrl.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTest extends BaseTest{

    @BeforeEach
    public void newData() {
        driver.get(BASE_URL);
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void shouldSwitchToBunsTab() {
        mainPage.clickFillings();
        mainPage.clickBuns();
        assertTrue(mainPage.getTextActiveTab(), "Нет перехода на раздел 'Булки'");
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    public void shouldSwitchToSaucesTab() {
        mainPage.clickSauces();
        assertTrue(mainPage.getTextActiveTab(), "Нет перехода на раздел 'Соусы'");
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    public void shouldSwitchToFillingsTab() {
        mainPage.clickFillings();
        assertTrue(mainPage.getTextActiveTab(), "Нет перехода на раздел 'Начинки'");
    }
}