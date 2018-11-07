package Steps;

import org.openqa.selenium.WebElement;
import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class TravelInsurancePageSteps extends BaseSteps {


    @Step("Выбираем сумму страховки")
    public void stepChooseInsSum(String value) {
        new TravelInsurancePage(driver).chooseInsSum(value);
    }

    @Step("Нажимаем кнопку \"Продолжить\" для перехода к заполнению полей")
    public void stepClickMakeButton() {
        new TravelInsurancePage(driver).makeButton();
    }

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new TravelInsurancePage(driver).fillField(field, value);

    }


    @Step("Заполнение полей: \n")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Выбираем пол страхователя: {0}")
    public void stepChooseClientSex(String sex) {
        new TravelInsurancePage(driver).chooseSex(sex);
    }

    @Step("Нажтмаем на кнопку \"Продолжить\" после заполнения полей")
    public void stepClickContinueButton() {
        new TravelInsurancePage(driver).continueButton();
    }

    @Step("На экране присутствует сообщение об ошибке \"{0}\".")
    public void checkErrorMessageStep(String value) {
        new TravelInsurancePage(driver).checkErrorMessage(value);
    }
}
