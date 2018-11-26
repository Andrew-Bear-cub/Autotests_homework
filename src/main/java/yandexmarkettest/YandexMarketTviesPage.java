package yandexmarkettest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sbertest.steps.BaseSteps;

public class YandexMarketTviesPage {

    @FindBy(xpath = "//input[@name='Цена от']")
    WebElement minPriceInput;

    @FindBy(xpath = "//input[@name='Производитель Samsung']")
    WebElement manufacturerSamsungCheckbox;

    @FindBy(xpath = "//input[@name='Производитель LG']")
    WebElement manufacturerLGCheckbox;

    public YandexMarketTviesPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void chooseManufacturer(String manufacturer) {
        //Выбор производителя через свич, по умолчанию выбирает двоих нужных нам, но можно выбрать одного, передав
        // название
        switch (manufacturer) {
            case "Samsung":
                manufacturerSamsungCheckbox.click();
                break;
            case "LG":
                manufacturerLGCheckbox.click();
                break;
            default:
                manufacturerSamsungCheckbox.click();
                manufacturerLGCheckbox.click();
                break;
        }
    }

    public void setMinPrice(int price) {
        minPriceInput.sendKeys(Integer.toString(price));
    }

}
