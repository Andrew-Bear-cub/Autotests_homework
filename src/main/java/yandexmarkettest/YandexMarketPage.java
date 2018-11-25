package yandexmarkettest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sbertest.steps.BaseSteps;

public class YandexMarketPage {


    @FindBy(xpath = "//li/a[text()='Электроника']")
    WebElement electronic;

    public YandexMarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void goToElectronic() {
        electronic.click();
    }
}

