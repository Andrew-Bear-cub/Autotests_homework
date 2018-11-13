package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    protected static String baseUrl;
    public static Properties properties = TestProperties.getinstance().getProperties();

    //Выполняется перед всем тестированием
    @Before
    public static void setUp() throws Exception {
        /*В обоих случаях тесты будут запускаться в хроме, потому что еще не добавил другие драйверы в проект,
         но на вырост оставил*/
        /*switch (properties.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));*/
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();

        //считываем из файла environment.properties значение свойства app.url и присваиваем его переменной baseUrl
        baseUrl = properties.getProperty("app.url");
        System.out.println("target URL is: " + baseUrl);
        //Устанавливаем неявные ожидания
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //развернуть на весь экран
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    //Выполняется после всего тестирования
    @After
    public static void tearDown() throws Exception {
        //Закрываем окно браузера
        driver.quit();
        System.out.println("Выполнение тестов завершнено.");

    }

    //Метод для заполнения полей
    public void fillField(By element, String value) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);

    }

    //Метод для проверки наличия элемента на странице
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Метод для проверки заполнения полей
    public void checkFillField(String value, WebElement element) {
        String actualValue = element.getAttribute("value");
        org.junit.Assert.assertTrue("Получено значение: " + actualValue + ", Ожидалось: " + value,
                actualValue.contains(value));
    }

    //Метод для проверки наличия сообщения об ошибке
    public void checkErrorMessage(String value, WebElement element){
        String actualValue = element.getAttribute("innerHTML");
        org.junit.Assert.assertTrue("Получено значение: " + actualValue + ", Ожидалось: " + value,
                actualValue.contains(value));
    }
    //Метод для перехода на вторую вкладку. Создадим массив в который загоним имена вкладок и перейдем на вторую
    public void switchTab(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
