package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static DesiredCapabilities capabilities;
    private static AppiumDriver<MobileElement> driver;

    public Driver(String platform, String device,
                  String automation, String appPackage, String appActivity) throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platform);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        driver = new AppiumDriver<>(
                new URL("http://127.0.0.1:4723/wd/hub"), capabilities
        );
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
