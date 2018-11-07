package Steps;

import pages.TravelsAndBuysPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelsAndBuysPageSteps extends BaseSteps {
    @Step("Нажали на кнопку \"Оформить онлайн\"")
    public void stepTABPButton() {
        new TravelsAndBuysPage(driver).sendButton.click();
    }
}
