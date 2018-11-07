package util;


import Steps.BaseSteps;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.junit.AllureRunListener;

public class AllureListener extends AllureRunListener {


    public void testFailure(Failure failure){
        takeScreenShot();
        super.testFailure(failure);
    }
    @Attachment(type = "image/png", value = "Скриншот ошибки")
    public byte[] takeScreenShot(){
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);    }
}
