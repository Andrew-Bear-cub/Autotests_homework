import sbertest.steps.BaseSteps;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import sbertest.pages.MainPage;
import sbertest.pages.TravelInsurancePage;
import sbertest.pages.TravelsAndBuysPage;

import java.util.ArrayList;

public class PageObjectSberInsTest extends BaseSteps {

    //Переписал тест с использованием PageObject и PageFactory
    @Test
    @Ignore
    public void newSberInsTest() {
        MainPage mainpage = new MainPage();
        mainpage.selectMainMenu("Страхование");
        mainpage.selectSubmenu("Путешествия и покупки");

        //Нажимаем на кнопку "Оформить онлайн"
        new TravelsAndBuysPage().sendButton.click();

        //Вот тут у меня затык. Я так пониаю, что клика на кнопку здесь открывается новое окно, но не могу придумать,
        // как сделать так, чтобы вновь открываемое окно присвоить переменной для вызова методов со страницы
        // TravelInsurancePage

        /*Т.к.  форма открывается в новой вкладке - перейдем на нее. Создадим массив в который загоним имена вкладок
        и перейдем на вторую.*/
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //Создаем новый экземпляр страницы "Страхование путешественников"
        TravelInsurancePage tip = new TravelInsurancePage();

        //Выберем минимальную страховку...
        tip.chooseInsSum("Минимальная");

        //И нажимаем кнопку оформить, для перехода к заполнению полей
        tip.makeButton();

        //И начинаем заполнять необходимые поля по застрахованному...
        tip.fillField("Фамилия застрахованного", "IVANOV");
        tip.fillField("Имя застрахованного", "IVAN");
        tip.fillField("Дата рождения застрахованного", "01.01.2010");

        //И страхователю
        tip.fillField("Имя страхователя", "Мария");
        tip.fillField("Фамилия страхователя", "Петрова");
        tip.fillField("Отчество страхователя", "Алексеевна");
        tip.fillField("Дата рождения страхователя", "01.01.1990");
        tip.chooseSex("Женский");
        tip.fillField("Серия паспорта страхователя", "1234");
        tip.fillField("Номер паспорта страхователя", "567890");
        tip.fillField("Дата выдачи паспорта страхователя", "10.01.2010");
        tip.fillField("Место выдачи паспорта страхователя", "Где-нибудь кем-то там");

        //Проверка заполнения полей
        checkFillField("IVAN", tip.getFillField("Имя застрахованного"));
        checkFillField("IVANOV", tip.getFillField("Фамилия застрахованного"));
        //...и т.д. уже поздно, лень много писать =)

        //Нажимаем на кнопку продолжить...
        tip.continueButton();

        //и проверяем наличие сообщения об ошибке
        checkErrorMessage("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div[@ng-show='tryNext && myForm.$invalid']")));

    }
}
