package yandexmarkettest.steps;

import ru.yandex.qatools.allure.annotations.Step;
import yandexmarkettest.pages.ExtendSearchPage;

public class ExtendedSearchPageSteps {

    @Step
    public void setMinPriceField(int minSum) {
        new ExtendSearchPage().setMinPriceField(minSum);
    }

    //метод для выбора производителя, сделал через свич. Для выбора двух - вызову дважды
    @Step
    public void chooseManufacturer(String manufacturer) {
        new ExtendSearchPage().chooseManufacturer(manufacturer);
    }

    @Step
    public void showResults() {
        new ExtendSearchPage().showResults();
    }
}
