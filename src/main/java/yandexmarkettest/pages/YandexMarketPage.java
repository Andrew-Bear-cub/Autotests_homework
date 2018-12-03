package yandexmarkettest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import yandexmarkettest.steps.BaseSteps;

public class YandexMarketPage {

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/noindex/div/div[2]/a")
    WebElement electronicMenu;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/noindex/div/div[2]/div[1]/div/div/div[1]/div/div/div[3]/a[2]")
    WebElement tvies;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/noindex/div/div[2]/div[1]/div/div/div[1]/div/div/div[2]/a[2]")
    WebElement headphones;

    public YandexMarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    //загуглил как навести указатель на элемент, чтобы открылось меню. Но загуглил поздно, поэтому тупо воткнул вызов
    //этого метода в выбор категории
    public void showElectronicMenu(){
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(electronicMenu).build().perform();
    }

    //выбор категории сделал через свич, не смог отловить икспас выплывающей менюшки чтобы сделать красиво :(
    public void chooseSubMenu(String menuItem) {
        switch (menuItem) {
            case "Телевизоры":
                showElectronicMenu();
                tvies.click();
                break;
            case "Наушники":
                showElectronicMenu();
                headphones.click();
                break;
            default:
                break;
        }
    }
}

