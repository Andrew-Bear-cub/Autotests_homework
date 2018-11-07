package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage {

    //переписал все и кнопки и текстовые поля через FindBy

    //Выбираем минимальную страховку
    @FindBy(xpath = "//*[text()='Минимальная']")
    WebElement minimumInsuranceButton;

    //Кнопка оформить, жмется для перехода к заполнению полей
    @FindBy(xpath = "//span[text()='Оформить']")
    WebElement makeButton;

    //Кнопка продолжить, жмется после заполнения полей
    @FindBy(xpath = "//span[@class='b-continue-btn']")
    WebElement continueButton;

    //Данные застрахованного лица: фамилия
    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;

    //Имя
    @FindBy(name = "insured0_name")
    WebElement insuredName;

    //Дата рождения
    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthdate;

    //данные страхователя: фамилия
    @FindBy(name = "surname")
    WebElement clientSurname;

    //имя
    @FindBy(name = "name")
    WebElement clientName;

    //отчество
    @FindBy(name = "middlename")
    WebElement clientMiddlename;

    //дата рождения
    @FindBy(name = "birthDate")
    WebElement clientBirthDate;

    //выбор пола: женский
    @FindBy(xpath = "//input[@name='female']")
    WebElement clientFemaleSexFlag;

    //выбор пола: мужской
    @FindBy(xpath = "//input[@name='male']")
    WebElement clientMaleSexFlag;

    //серия паспорта
    @FindBy(name = "passport_series")
    WebElement clientPassportSeries;

    //номер паспорта
    @FindBy(name = "passport_number")
    WebElement clientPassportNumber;

    //дата выдачи паспорта
    @FindBy(name = "issueDate")
    WebElement clientPassportIssueDate;

    //кем и когда выдан
    @FindBy(name = "issuePlace")
    WebElement clientPassportIssuePlace;

    //Сообщение об ошибке
    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid']")
    WebElement errorMessage;

    //конструктор, без которого не заработает
    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        /*Задаим ожидание появления кнопки "Минимальная" (страница грузится каждый раз по разному, поставил 20 секунд
        чтоб наверняка)*/
        //(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(minimumInsuranceButton));
    }

    /*метод для заполнения полей, передаем имя элемента и значение, внутри вызывается метод заполнения полей по элементу
    и значению*/
    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(insuredSurname, value);
                break;
            case "Имя застрахованного":
                fillField(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insuredBirthdate, value);
                break;
            case "Имя страхователя":
                fillField(clientName, value);
                break;
            case "Фамилия страхователя":
                fillField(clientSurname, value);
                break;
            case "Отчество страхователя":
                fillField(clientMiddlename, value);
                break;
            case "Дата рождения страхователя":
                fillField(clientBirthDate, value);
                break;
            case "Пол страхователя":
                chooseSex(value);
                break;
            case "Серия паспорта страхователя":
                fillField(clientPassportSeries, value);
                break;
            case "Номер паспорта страхователя":
                fillField(clientPassportNumber, value);
                break;
            case "Дата выдачи паспорта страхователя":
                fillField(clientPassportIssueDate, value);
                break;
            case "Место выдачи паспорта страхователя":
                fillField(clientPassportIssuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено!");
        }

    }


    //Метод, возвращающий значения полей. Будет использоваться для проверки заполнения
    public WebElement getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                return insuredSurname;

            case "Имя застрахованного":
                return insuredName;

            case "Дата рождения застрахованного":
                return insuredBirthdate;

            case "Имя страхователя":
                return clientName;

            case "Фамилия страхователя":
                return clientSurname;

            case "Отчество страхователя":
                return clientMiddlename;

            case "Дата рождения страхователя":
                return clientBirthDate;

            case "Серия паспорта страхователя":
                return clientPassportSeries;

            case "Номер паспорта страхователя":
                return clientPassportNumber;

            case "Дата выдачи паспорта страхователя":
                return clientPassportIssueDate;

            case "Место выдачи паспорта страхователя":
                return clientPassportIssuePlace;

            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено!");
        }

    }

    //метод для выбора суммы страховки. Тут описан только выбор кнопки "минимальная", но легко переделывается на две
    // остальных через switch
    public void chooseInsSum(String value) {
        switch (value) {
            case "Минимальная":
                minimumInsuranceButton.click();
                break;
            default:
                minimumInsuranceButton.click();
        }
    }

    //Метод для нажатия на кнопку продолжить, для перехода на вторую закладку, для заполнения данных по клиентам
    public void makeButton() {
        makeButton.click();
    }

    //Метод для нажатия на кнопку продолжить, после заполнения полей
    public void continueButton() {
        continueButton.click();
    }

    //метод для заполнения полей, передаем элемент и значение для заполнения
    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    //метод для выбора пола клиента. Привожу вводимое значение к верхнему регистру чтобы избежать ошибок, связанных с
    // регистром вводимого значения
    public void chooseSex(String sex) {
        while (true) {
            try {
                if (sex.toUpperCase().equals("МУЖСКОЙ")) {
                    clientMaleSexFlag.click();
                    break;
                } else if (sex.toUpperCase().equals("ЖЕНСКИЙ")) {
                    clientFemaleSexFlag.click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Нет такого пола! Выберите мужской или женский!");
            }
        }


        }
    public void checkErrorMessage (String value){
        String actualValue = errorMessage.getAttribute("innerHTML");
        org.junit.Assert.assertTrue("Получено значение: " + actualValue + ", Ожидалось: " + value,
                actualValue.contains(value));
    }
}

