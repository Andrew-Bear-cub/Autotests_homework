package yandexmarkettest.steps;

import ru.yandex.qatools.allure.annotations.Step;
import yandexmarkettest.pages.YandexMarketPage;

public class MarketPageSteps {

    //выбор категории сделал через свич, не смог отловить икспас выплывающей менюшки чтобы сделать красиво :(
    @Step
    public void chooseSubMenu(String menuItem) {
        new YandexMarketPage().chooseSubMenu(menuItem);
        }
    }
