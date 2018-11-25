package sbertest.steps;

import sbertest.pages.TravelsAndBuysPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelsAndBuysPageSteps {
    @Step("Нажали на кнопку \"Оформить онлайн\"")
    public void stepTABPButton() {
        new TravelsAndBuysPage().sendButton.click();
    }
}
