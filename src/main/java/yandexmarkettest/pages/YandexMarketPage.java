package yandexmarkettest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sbertest.steps.BaseSteps;

public class YandexMarketPage {


    @FindBy(xpath = "//a[text()='Телевизоры']")
    WebElement tvies;

    @FindBy(xpath = "//a[text()='Наушники']")
    WebElement headphones;

    public YandexMarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    //выбор категории сделал через свич, не смог отловить икспас выплывающей менюшки чтобы сделать красиво :(
    public void chooseSubMenu(String menuItem) {
        switch (menuItem) {
            case "Телевизоры":
                tvies.click();
                break;
            case "Наушники":
                headphones.click();
                break;
            default:
                break;
        }
    }
}

