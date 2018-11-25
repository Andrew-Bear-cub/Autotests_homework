package yandexmarkettest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sbertest.steps.BaseSteps;

public class YandexMarketElectronicPage {
    @FindBy(xpath = "//div/div/a[@data-reactid='37'][text()='Телевизоры']")
    WebElement tvies;

    @FindBy(xpath = "//div/div/a[@data-reactid='26'][text()='Наушники и Bluetooth-гарнитуры']")
    WebElement headphones;


    public YandexMarketElectronicPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void goToTvies() {
        tvies.click();
    }

    public void goToHeadphones() {
        headphones.click();
    }
}
