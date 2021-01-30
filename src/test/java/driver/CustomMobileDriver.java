package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static helpers.BrowserStackHelper.getBrowserstackUrl;

public class CustomMobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {
        switch (ConfigHelper.getPlatform()) {
            case IOS:
                return getIOSDriver();
            case ANDROID:
                return getAndroidDriver();
            default:
                throw new UnsupportedOperationException("No such platform");
        }
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", ConfigHelper.getUsername());
        capabilities.setCapability("browserstack.key", ConfigHelper.getPassword());
        capabilities.setCapability("app", ConfigHelper.getApp());
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("project", "Android project");
        capabilities.setCapability("build", "Android");
        capabilities.setCapability("name", "android");
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    public WebDriver getIOSDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("project", "IOS project");
        capabilities.setCapability("build", "IOS");
        capabilities.setCapability("name", "ios");
        capabilities.setCapability("device", "iPhone XS");
        capabilities.setCapability("os_version", "12");

        return new IOSDriver(getBrowserstackUrl(), capabilities);
    }
}
