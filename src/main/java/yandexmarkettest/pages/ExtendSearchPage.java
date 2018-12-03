package yandexmarkettest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import yandexmarkettest.steps.BaseSteps;


public class ExtendSearchPage {

    @FindBy(xpath = "//input[@name='glf-pricefrom-var']")
    WebElement minPriceField;
    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[4]/a/span/label")
    WebElement manufacturerLGCheckbox;
    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[7]/a/span/label")
    WebElement manufacturerSamsungCheckbox;
    //Для экономии кода чекбоксы всех трех производителей описал в одном классе, мне показалось что так правильно :)
    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div[1]/div[1]/div[3]/div[2]/div/div[1]/div[3]/a/span/label")
    WebElement manufacturerBeatsCheckbox;
    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div[1]/div[5]/a[2]")
    WebElement showResultsButton;

    public ExtendSearchPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    //метод для заполнения минимальной суммы
    public void setMinPriceField(int minSum) {

        minPriceField.sendKeys(Integer.toString(minSum));
    }

    //метод для выбора производителя, сделал через свич. Для выбора двух - вызову дважды
    public void chooseManufacturer(String manufacturer) {
        switch (manufacturer) {
            case "Beats":
                manufacturerBeatsCheckbox.click();
                break;
            case "Samsung":
                manufacturerSamsungCheckbox.click();
                break;
            case "LG":
                manufacturerLGCheckbox.click();
                break;
            default:
                break;
        }
    }

    public void showResults() {
        showResultsButton.click();
    }
}
