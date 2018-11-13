package Steps;

import org.openqa.selenium.WebElement;
import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class TravelInsurancePageSteps {


    @Step("Выбираем сумму страховки")
    public void stepChooseInsSum(String value) {
        new TravelInsurancePage().chooseInsSum(value);
    }

    @Step("Нажимаем кнопку \"Продолжить\" для перехода к заполнению полей")
    public void stepClickMakeButton() {
        new TravelInsurancePage().makeButton();
    }

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new TravelInsurancePage().fillField(field, value);

    }


    @Step("Заполнение полей: \n")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Выбираем пол страхователя: {0}")
    public void stepChooseClientSex(String sex) {
        new TravelInsurancePage().chooseSex(sex);
    }

    @Step("Нажтмаем на кнопку \"Продолжить\" после заполнения полей")
    public void stepClickContinueButton() {
        new TravelInsurancePage().continueButton();
    }

    @Step("На экране присутствует сообщение об ошибке \"{0}\".")
    public void checkErrorMessageStep(String value) {
        new TravelInsurancePage().checkErrorMessage(value);
    }
}
