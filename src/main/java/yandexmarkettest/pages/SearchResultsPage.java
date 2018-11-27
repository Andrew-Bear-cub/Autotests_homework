package yandexmarkettest.pages;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sbertest.steps.BaseSteps;

import java.util.List;

public class SearchResultsPage {

    //Поле поиска
    @FindBy(xpath = "")
    WebElement searchField;

    //Кнопка расширенного поиска
    @FindBy(xpath = "//span[text()='Все фильтры']")
    WebElement goToExtendSearchButton;

    //Общий икспас для результатов поиска (по крайней мере, у меня по этому икспасу нашлось ровно 12 элементов :))
    @FindBy(xpath = "//div[contains(@class, 'n-snippet-card2 ')]")
    List<WebElement> searchresultsList;

    public SearchResultsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    //переменная для хранения числа результатов поиска
    int searchResultsCount = searchresultsList.size();
    //переменная для хранения первого результата поиска (для дальнейшего сравнения)
    WebElement firstResult = searchresultsList.get(0);
    //переменная для хранения названия первого результата поиска
    String firstResultName = firstResult.getAttribute("title");

    public void goToExtendedearch(){
        goToExtendSearchButton.click();
    }

    public void search(){
        searchField.sendKeys(firstResultName);
        searchField.sendKeys(Keys.RETURN);
    }

    public void compareResultsCount(){
        Assert.assertEquals("Количество результатов поиска не равно 12!", searchResultsCount, 12);
    }

    public void compareFirstResult(){
        Assert.assertEquals("Элементы не совпадают!",firstResult, searchresultsList.get(0));
    }

}
