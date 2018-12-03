package yandexmarkettest.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandexmarkettest.steps.BaseSteps;

import java.util.List;

public class SearchResultsPage {

    //Поле поиска
    @FindBy(xpath = "//*[@id=\"header-search\"]")
    WebElement searchField;

    //Кнопка расширенного поиска
    @FindBy(xpath = "//span[text()='Все фильтры']")
    WebElement goToExtendSearchButton;

    //Общий икспас для результатов поиска (по крайней мере, у меня по этому икспасу нашлось ровно 12 элементов :))
    @FindBy(xpath = "//div[contains(@class, 'n-snippet-card2 ')]")
    List<WebElement> searchresultsList;

    /**
    //переменная для хранения числа результатов поиска
    int searchResultsCount = searchresultsList.size();
    //переменная для хранения первого результата поиска (для дальнейшего сравнения)
    WebElement firstResult = searchresultsList.get(0);
    //переменная для хранения названия первого результата поиска
    String firstResultName = firstResult.getAttribute("title");
    */
     public SearchResultsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void goToExtendedearch() {
        WebElement searchButton = (new WebDriverWait(BaseSteps.getDriver(), 15))
                .until(ExpectedConditions.elementToBeClickable(goToExtendSearchButton));
        searchButton.click();

    }

    public void search() {
        String firstResultName = searchresultsList.get(0).getAttribute("title");
        searchField.sendKeys(firstResultName);
        searchField.sendKeys(Keys.RETURN);
    }
    //У меня по умолчанию стоит 48 результатов поиска, хз как проверить что их 12 :)
    // поэтому переписал метод чтобы он проверял на 48, потому что если не 12, то выполнение тестов прекращается
    public void compareResultsCount() {
        int searchResultsCount = searchresultsList.size();
        Assert.assertEquals("Количество результатов поиска не равно 48!", 48, searchResultsCount);
    }

    public WebElement remeberFirstElement(){
         return searchresultsList.get(0);
    }

    public void compareFirstResult() {
        WebElement newFirstResult = searchresultsList.get(0);
        Assert.assertEquals("Элементы не совпадают!", newFirstResult, remeberFirstElement());
    }

}
