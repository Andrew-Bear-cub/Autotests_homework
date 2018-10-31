/**
 * @author Andrey makarov, Aplana
 */

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @see Test_Homework_task_1 Класс в котором мы пишем наш тест
 * -driver - объявили переменную driver типа WebDriver в которой будет храниться драйвер нашего браузера;
 * -baseUrl - объявили переменную baseUrl типа String в которой будет хранится ссылка на тестируемый сайт;
 */
public class Test_Homework_task_1 extends BaseTest {


    /**
     * @see #sberIsuranceTest() непосредственно запуск теста:
     * -findElement - поиск эелемента на странице;
     * -Assert - предположение о чем-либо
     */
    @Test
    @Ignore
    public void sberIsuranceTest() {
        //Переходим по ссылке
        driver.get(baseUrl);

        //находим на старнице элемент страхование, кликаем на него
        driver.findElement(By.xpath("//span[contains(text(), 'Страхование')]")).click();

        //находим элемент Путешествия и покупки, кликаем на него
        driver.findElement(By.xpath("//a[@class='lg-menu__sub-link'][text()='Путешествия и покупки']")).click();

        //проверяем наличие на странице необходимого элемента. В данном случае заголовка – Страхование путешественников
        WebElement title = driver.findElement(By.xpath("//h3[text()='Страхование путешественников']"));

        //Предполагаем равенство. В данном случае равенство заданной строки и найденного заголовка
        Assert.assertEquals("Страхование путешественников", title.getText());

        //Находим на странице кнопку Оформить онлайн. Т.к. их две одинаковых, а отличаются только ссылками, на которые
        //они ведут - искал по икспасу через ссылку. И нажимаем на нее.
        driver.findElement(By.xpath("//div[@data-pid='SBRF_ColList_sb_bundle-9624889']//*/p[@class='kit-button kit-button_color_green kit-button_size_m']")).click();

        /*Т.к.  форма открывается в новой вкладке - перейдем на нее. Создадим массив в который загоним имена вкладок
        и перейдем на вторую.*/
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //Выбираем минимальную страховку
        driver.findElement(By.xpath("//*[text()='Минимальная']")).click();

        //Нажимаем кнопку оформить
        driver.findElement(By.xpath("//span[text()='Оформить']")).click();

        //Вводим данные о застрахованных в поля
        fillField(By.name("insured0_surname"), "IVANOV");
        fillField(By.name("insured0_name"), "IVAN");
        fillField(By.name("insured0_birthDate"), "01.01.1990");

        //Точно так же введем данные о страхователе
        fillField(By.name("surname"), "ПЕТРОВА");
        fillField(By.name("name"), "МАРИНА");
        fillField(By.name("middlename"), "ПЕТРОВНА");
        fillField(By.name("birthDate"), "02.02.1965");

        //Кликаем в чекбоксе чтобы выбрать женский пол
        driver.findElement(By.xpath("//input[@name='female']")).click();

        //Теперь заполняем данные паспорта страхователя
        fillField(By.name("passport_series"), "1234");
        fillField(By.name("passport_number"), "567890");
        fillField(By.name("issueDate"), "03.02.2010");
        fillField(By.name("issuePlace"), "ГДЕ-НИБУДЬ И КАК-НИБУДЬ");

        //Проверим, что все поля заполнены верно
        Assert.assertEquals("IVANOV",
                driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("IVAN",
                driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("01.01.1990",
                driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        Assert.assertEquals("ПЕТРОВА",
                driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("МАРИНА",
                driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("ПЕТРОВНА",
                driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("02.02.1965",
                driver.findElement(By.name("birthDate")).getAttribute("value"));
        Assert.assertEquals("1234",
                driver.findElement(By.name("passport_series")).getAttribute("value"));
        Assert.assertEquals("567890",
                driver.findElement(By.name("passport_number")).getAttribute("value"));
        Assert.assertEquals("03.02.2010",
                driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("ГДЕ-НИБУДЬ И КАК-НИБУДЬ",
                driver.findElement(By.name("issuePlace")).getAttribute("value"));

        //Нажимаем на кнопку продолжить
        driver.findElement(By.xpath("//span[@class='b-continue-btn']")).click();

        //Проверяем наличие сообщения об ошибке
        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div[text()='Заполнены не все обязательные поля']")).getText());
    }
}