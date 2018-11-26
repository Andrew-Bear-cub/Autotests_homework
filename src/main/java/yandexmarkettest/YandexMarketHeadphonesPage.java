package yandexmarkettest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sbertest.steps.BaseSteps;

import java.util.List;

public class YandexMarketHeadphonesPage {

    @FindBy(xpath = "//input[@name = 'Цена от']")
    WebElement minPriceInput;

    @FindBy(xpath = "//input[@name='Производитель Beats']")
    WebElement manufacturerBeatsChekbox;

    @FindBy(xpath = "//div[contains(@class, 'n-snippet-cell2 ')]")
    List<WebElement> searchresultsList;
    //переменная для хранения числа результатов поиска
    int searchResultsCount = searchresultsList.size();
    //переменная для хранения первого результата поиска (для дальнейшего сравнения)
    WebElement firstResult = searchresultsList.get(0);
    //переменная для хранения названия первого результата поиска
    String firstResultName = firstResult.getAttribute("title");

    public YandexMarketHeadphonesPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void chooseManufacturer(String manufacturer) {
        //Выбор производителя через свич, аналогично странице телевизоров
        switch (manufacturer) {
            case "Beats":
                manufacturerBeatsChekbox.click();
                break;
            default:
                manufacturerBeatsChekbox.click();
                break;
        }
    }

    public void setMinPrice(int price) {
        minPriceInput.sendKeys(Integer.toString(price));
    }

}
