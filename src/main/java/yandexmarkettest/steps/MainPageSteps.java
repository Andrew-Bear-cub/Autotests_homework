package yandexmarkettest.steps;

import ru.yandex.qatools.allure.annotations.Step;
import yandexmarkettest.pages.YandexMainPage;

public class MainPageSteps {

    @Step("Перешли на Яндекс.Маркет")
    public void goToMarket() {
        new YandexMainPage().goToMarket();
    }
}
