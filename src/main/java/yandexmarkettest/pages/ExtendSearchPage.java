package yandexmarkettest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import yandexmarkettest.steps.BaseSteps;


public class ExtendSearchPage {

    @FindBy(xpath = "//input[@name='glf-pricefrom-var']")
    WebElement minPriceField;
    @FindBy(xpath = "//span[@data-filter='glf,7893318,153074']")
    WebElement manufacturerLGCheckbox;
    @FindBy(xpath = "//span[@data-filter='glf,7893318,153061']")
    WebElement manufacturerSamsungCheckbox;
    //Для экономии кода чекбоксы всех трех производителей описал в одном классе, мне показалось что так правильно :)
    @FindBy(xpath = "//span[@data-filter='glf,7893318,8455647']")
    WebElement manufacturerBeatsCheckbox;
    @FindBy(xpath = "//a[contains(@class, 'show-filtered')]")
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
