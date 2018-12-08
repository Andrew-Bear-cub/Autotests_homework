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
    public void compareResultsCount(int count) {
        new SearchResultsPage().compareResultsCount(count);
    }

    @Step
    public void rememberFirstElement() {
        new SearchResultsPage().remeberFirstElement();
    }

    @Step
    public void compareFirstResult() {new SearchResultsPage().compareFirstResult();}

    @Step
    public void switchToList() {new SearchResultsPage().switchToList();}


}
