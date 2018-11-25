package sbertest.pages;

import sbertest.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//div[contains(@class, 'lg-menu__row')]")
    WebElement mainMenu;

    @FindBy(xpath="//li[@class='lg-menu__item lg-menu__item_hovered']/*//div[@class='kit-col kit-col_lg_5 lg-menu__col']")
    WebElement subMenu;

    public MainPage()
    {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(".//span[text()='"+menuItem+"']")).click();
    }
    public void selectSubmenu(String menuItem){
        subMenu.findElement(By.xpath(".//li[@class='lg-menu__sub-item']//a[contains(text(), '"+menuItem+"')]")).click();
    }

}
