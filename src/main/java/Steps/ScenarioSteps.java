package Steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    //Создаем экземплры классов шагов чтобы вызвать их методы
    //Главная страница
    MainPageSteps mainPageSteps = new MainPageSteps();

    //Страхование и покупки
    TravelsAndBuysPageSteps travelsAndBuysPageSteps = new TravelsAndBuysPageSteps();

    //Страхование выезжающих за рубеж
    TravelInsurancePageSteps travelInsurancePageSteps = new TravelInsurancePageSteps();

    /**@When("^Выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainPageSteps.stepSelectMainMenu(menuItem);
    }

    @When("^Выбран подпункт меню \"(.+)\"$")
    public void stepSelectSubMenu(String menuItem) {
        mainPageSteps.stepSelectSubMenu(menuItem);
    }

    @Then("^Выполняем нажатие на кнопку - Оформить онлайн")
    public void stepTABPButton() {
        travelsAndBuysPageSteps.stepTABPButton();
    }

    @When("^Переходим на страницу \"страхование путешественников\"")
    public void stepSwitchTab() {
        travelsAndBuysPageSteps.switchTab();
    }

    @Then("^Выбираем сумму страховки \"(.+)\"$")
    public void stepChooseInsSum(String value) {
        travelInsurancePageSteps.stepChooseInsSum(value);

    }

    @Then("^Нажимаем кнопку \"Оформить\" для перехода к заполнению полей")
    public void stepClickMakeButton() {
        travelInsurancePageSteps.stepClickMakeButton();
    }

    @When("Заполняются поля")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> travelInsurancePageSteps.stepFillField(key, value));
    }

    @When("^Выбираем пол страхователя\"(.+)\"$")
    public void stepChooseClientSex(String sex) {
        travelInsurancePageSteps.stepChooseClientSex(sex);
    }

    @Then("Нажимаем на кнопку \"Продолжить\"")
    public void stepClickContinueButton() {
        travelInsurancePageSteps.stepClickContinueButton();
    }

    @Then("^Проверяем наличие сообщения об ошибке на экране - \"(.+)\"$")
    public void checkErrorMesageStep(String value) {
        travelInsurancePageSteps.checkErrorMessageStep(value);
    }


}*/
    @When("^Выбран пункт меню \"([^\"]*)\"$")
    public void выбран_пункт_меню(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mainPageSteps.stepSelectMainMenu(arg1);
        throw new PendingException();
    }

    @When("^Выбран подпункт меню \"([^\"]*)\"$")
    public void выбран_подпункт_меню(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mainPageSteps.stepSelectSubMenu(arg1);
        throw new PendingException();
    }

    @Then("^Выполняем нажатие на кнопку - Оформить онлайн$")
    public void выполняем_нажатие_на_кнопку_Оформить_онлайн() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        travelsAndBuysPageSteps.stepTABPButton();
        throw new PendingException();
    }

    @When("^Переходим на страницу \"Страхование путешественников\"$")
    public void переходим_на_страницу() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        travelsAndBuysPageSteps.switchTab();
        throw new PendingException();
    }

    @Then("^Выбираем сумму страховки \"([^\"]*)\"$")
    public void выбираем_сумму_страховки(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        travelInsurancePageSteps.stepChooseInsSum(arg1);
        throw new PendingException();
    }

    @Then("^Нажимаем кнопку \"Оформить\" для перехода к заполнению полей$")
    public void нажимаем_кнопку_для_перехода_к_заполнению_полей() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        travelInsurancePageSteps.stepClickMakeButton();
        throw new PendingException();
    }

    @When("^Заполняются поля$")
    public void заполняются_поля(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        arg1.asMap(String.class, String.class).forEach(
                (key, value) -> travelInsurancePageSteps.stepFillField(key, value));
        throw new PendingException();
    }

    @When("^Выбираем пол страхователя\"([^\"]*)\"$")
    public void выбираем_пол_страхователя(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        travelInsurancePageSteps.stepChooseClientSex(arg1);
        throw new PendingException();
    }

    @Then("^Нажимаем на кнопку \"Продолжить\"$")
    public void нажимаем_на_кнопку(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        travelInsurancePageSteps.stepClickContinueButton();
        throw new PendingException();
    }

    @Then("^Проверяем наличие сообщения об ошибке на экране - \"([^\"]*)\"$")
    public void проверяем_наличие_сообщения_об_ошибке_на_экране(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        travelInsurancePageSteps.checkErrorMessageStep(arg1);
        throw new PendingException();
    }
}
