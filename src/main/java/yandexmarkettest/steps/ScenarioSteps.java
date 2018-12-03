package yandexmarkettest.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    //создаем экземпляры всех страниц
    MainPageSteps mainPage = new MainPageSteps();
    MarketPageSteps marketPage = new MarketPageSteps();
    SearchResultsPageSteps searchResultsPage = new SearchResultsPageSteps();
    ExtendedSearchPageSteps extendSearchPage = new ExtendedSearchPageSteps();

    @When("^Перешли на Яндекс.Маркет")
    public void goToMarket(){
        mainPage.goToMarket();
    }

    @When("^Выбрали раздел \"([^\"]*)\"$")
    public void chooseSubMenu(String menuItem){
        marketPage.chooseSubMenu(menuItem);
    }

    @When("^Перешли в расширенный поиск")
    public void goToExtendSearch(){
        searchResultsPage.goToExtendedearch();
    }

    @Then("^Задали минимальную цену \"([^\"]*)\" рублей$")
    public void setMinPrice(int minPrice){
        extendSearchPage.setMinPriceField(minPrice);
    }

    @Then("^Выбрали производителя \"([^\"]*)\"$")
    public void chooseManufacturer(String manufacturer){
        extendSearchPage.chooseManufacturer(manufacturer);
    }

    @Then("^Нажали кнопку применить")
    public void showResults(){
        extendSearchPage.showResults();
    }

    @Then("^Проверили что элементов на странице \"48\"")
    public void compareResultsCount(){searchResultsPage.compareResultsCount();}

    @Then("^Запомнили первый элемент")
    public void rememberFirstElement(){searchResultsPage.rememberFirstElement();}

    @When("^Ввели название первого элемента в поиск")
    public void search(){searchResultsPage.search();}

    @Then("^Проверили что результат поиска совпадает с запомненным значением")
    public void compareFirstResult(){searchResultsPage.compareFirstResult();}



}
