package Steps;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Шаги, выполняемые на главной странице
 */

public class MainPageSteps extends BaseSteps{

    @Step("выбран пункт главного меню {0}")

    public void stepSelectMainMenu(String menuItem){

        new MainPage().selectMainMenu(menuItem);
    }

    @Step("выбран пункт подменю {0}")

    public void stepSelectSubMenu(String menuItem){

        new MainPage().selectSubmenu(menuItem);

    }



}