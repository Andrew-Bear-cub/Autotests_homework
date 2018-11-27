package yandexmarkettest.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import yandexmarkettest.pages.ExtendSearchPage;
import yandexmarkettest.pages.SearchResultsPage;
import yandexmarkettest.pages.YandexMainPage;
import yandexmarkettest.pages.YandexMarketPage;

public class ScenarioSteps {
    //создаем экземпляры всех страниц
    YandexMainPage mainPage = new YandexMainPage();
    YandexMarketPage marketPage = new YandexMarketPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ExtendSearchPage extendSearchPage = new ExtendSearchPage();

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
}
