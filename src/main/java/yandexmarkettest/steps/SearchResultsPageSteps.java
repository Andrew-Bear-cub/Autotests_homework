package yandexmarkettest.steps;

import ru.yandex.qatools.allure.annotations.Step;
import yandexmarkettest.pages.SearchResultsPage;

public class SearchResultsPageSteps {

    @Step
    public void goToExtendedearch() {
        new SearchResultsPage().goToExtendedearch();
    }

    @Step
    public void search() {
        new SearchResultsPage().search();
    }

    @Step
    public void compareResultsCount() {
        new SearchResultsPage().compareResultsCount();
    }

    @Step
    public void compareFirstResult() {
        new SearchResultsPage().compareFirstResult();
    }


}
