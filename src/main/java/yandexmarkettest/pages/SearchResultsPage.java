package yandexmarkettest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandexmarkettest.steps.BaseSteps;

import java.util.List;

public class SearchResultsPage {

    //Поле поиска
    @FindBy(xpath = "//*[@id=\"header-search\"]")
    private WebElement searchField;

    //Кнопка расширенного поиска
    @FindBy(xpath = "//span[text()='Все фильтры']")
    private WebElement goToExtendSearchButton;

    //Кнопка для переключения вида результатов поиска на список
    @FindBy(xpath = "//label[contains(@class,'right')]//input[@class='radio-button__control']")
    private WebElement listView;


    //Общий икспас для результатов поиска (по крайней мере, у меня по этому икспасу нашлось ровно 48 элементов :))
    @FindBy(xpath = "//div[contains(@class, 'n-snippet-card2 ')]")
    private List<WebElement> searchresultsList;

    /**
     * //переменная для хранения числа результатов поиска
     * int searchResultsCount = searchresultsList.size();
     * //переменная для хранения первого результата поиска (для дальнейшего сравнения)
     * WebElement firstResult = searchresultsList.get(0);
     * //переменная для хранения названия первого результата поиска
     * String firstResultName = firstResult.getAttribute("title");
     */
    public SearchResultsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void goToExtendedearch() {
        WebElement searchButton = (new WebDriverWait(BaseSteps.getDriver(), 15))
                .until(ExpectedConditions.elementToBeClickable(goToExtendSearchButton));
        searchButton.click();

    }

    public void switchToList() {
        listView.click();
    }

    public void search() {
        String firstResultName = searchresultsList.get(0).getAttribute("title");
        searchField.sendKeys(firstResultName);
        searchField.sendKeys(Keys.RETURN);
    }

    //У меня по умолчанию стоит 48 результатов поиска, хз как проверить что их 12 :)
    // поэтому жестко выбираю показывать по 12 результатов, а то тесты падают. При этом, наушники в принципе падают,
    //потому что их всего 19 и не дает выбрать, показывать по 12 или 48
    public void compareResultsCount(int count) {
        int searchResultsCount = searchresultsList.size();
        Assert.assertEquals("Количество результатов поиска не равно "+ count + "!", count, searchResultsCount);
    }

    public WebElement remeberFirstElement() {
        return searchresultsList.get(0);
    }

    public void compareFirstResult() {
        WebElement newFirstResult = searchresultsList.get(0);
        Assert.assertEquals("Элементы не совпадают!", newFirstResult, remeberFirstElement());
    }

}
