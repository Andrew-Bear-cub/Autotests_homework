package util;


import sbertest.steps.BaseSteps;
import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;


public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {


    public void result(Result result) {
        if (result.getStatus().equals("failed")) {
            takeScreenShot();
        }
        super.result(result);
    }

    @Attachment(type = "image/png", value = "Скриншот ошибки")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
