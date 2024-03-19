package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static DesiredCapabilities capabilities;
    private static AppiumDriver<?> driver;
    private static String nameScenario;
    private static File directory;
    private static int numPrint;
    public DriverFactory(String app,
                         String platform,
                         String device,
                         String automation,
                         String appPackage,
                         String appActivity,
                         boolean headless) throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,app);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platform);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        capabilities.setCapability(AndroidMobileCapabilityType.IS_HEADLESS, headless);
        driver = new AppiumDriver<>(
                new URL("http://127.0.0.1:4723/wd/hub"), capabilities
        );
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    /*
      Criar pastas com os nomes dos cenários de execução automatizados
       */
    public static void makeDirectory() {
        String path = "target/report/attachments";
        directory = new File(path + "/" + nameScenario);
        directory.mkdir();
        numPrint = 0;
    }

    /*
    Criar as evidencias enumeradas com os passos de execução automatizados
     */
    public static void printScreenshot(String steps) throws IOException {
        numPrint++;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = directory.getPath() + "/" + numPrint + " - " + steps + ".png";
        FileUtils.copyFile(file, new File(path));
    }

    public static AppiumDriver<?> getDriver() {
        return driver;
    }
    public static void setNameScenario(String nameScenario) {
        DriverFactory.nameScenario = nameScenario;
    }

}
