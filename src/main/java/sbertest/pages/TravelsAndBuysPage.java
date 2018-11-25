package sbertest.pages;

import sbertest.steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelsAndBuysPage {
    @FindBy(xpath = "//div[@data-pid='SBRF_ColList_sb_bundle-9624889']//*/p[@class='kit-button kit-button_color_green kit-button_size_m']")
    public WebElement sendButton;

    public TravelsAndBuysPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        //Ожидание появления кнопки
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton));

    }
}
