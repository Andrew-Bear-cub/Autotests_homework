import Steps.BaseSteps;
import Steps.MainPageSteps;
import Steps.TravelInsurancePageSteps;
import Steps.TravelsAndBuysPageSteps;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.HashMap;

public class AllureReportSberInsTest extends BaseSteps {

    @Test
    //заголовок теста
    @Title("Сбербанк страхование путешественников")
    public void testInsurance() {
        //создадим экземпляры для каждого степа
        MainPageSteps mpSteps = new MainPageSteps();
        TravelsAndBuysPageSteps tabpSteps = new TravelsAndBuysPageSteps();


        //Подготовим словарь с тестовыми данными:
        //По застрахованному...
        HashMap<String, String> tstData = new HashMap<>();
        tstData.put("Фамилия застрахованного", "IVANOV");
        tstData.put("Имя застрахованного", "IVAN");
        tstData.put("Дата рождения застрахованного", "01.01.2010");

        //...и по страхователю
        tstData.put("Имя страхователя", "Мария");
        tstData.put("Фамилия страхователя", "Петрова");
        tstData.put("Отчество страхователя", "Алексеевна");
        tstData.put("Дата рождения страхователя", "01.01.1990");
        tstData.put("Серия паспорта страхователя", "1234");
        tstData.put("Номер паспорта страхователя", "567890");
        tstData.put("Дата выдачи паспорта страхователя", "10.01.2010");
        tstData.put("Место выдачи паспорта страхователя", "Где-нибудь кем-то там");

        //Переходим в главное меню, затем в путешествия и покупки
        mpSteps.stepSelectMainMenu("Страхование");
        mpSteps.stepSelectSubMenu("Путешествия и покупки");

        //Нажимаем кнопку оформить онлайн
        tabpSteps.stepTABPButton();

        /*Т.к.  форма открывается в новой вкладке - перейдем на нее. Создадим массив в который загоним имена вкладок
        и перейдем на вторую.*/
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        TravelInsurancePageSteps tipSteps = new TravelInsurancePageSteps();

        //Выбираем сумму страховки "Минимальная"
        tipSteps.stepChooseInsSum("Минимальная");

        //Нажимаем кнопку оформить для перехода к заполнению полей
        tipSteps.stepClickMakeButton();

        //Заполянем поля из словаря
        tipSteps.stepFillFields(tstData);

        //Не забываем указать пол страхователя!
        tipSteps.stepChooseClientSex("Женский");

        //Нажимаем на кнопку продолжить...
        tipSteps.stepClickContinueButton();

        //И проверяем наличие сообщения об ошибке
        tipSteps.checkErrorMessageStep("Заполнены не все обязательные поля");
    }

}
