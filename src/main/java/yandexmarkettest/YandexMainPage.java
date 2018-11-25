package yandexmarkettest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sbertest.steps.BaseSteps;

public class YandexMainPage {

    @FindBy(xpath = "//a[@data-id='market']")
    WebElement marketLink;

    public YandexMainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void goToMarket() {
        marketLink.click();
    }

}