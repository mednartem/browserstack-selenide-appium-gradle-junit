package config;

import helpers.PlatformHelper;
import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static MobileConfig getConfig() {
        return ConfigFactory.newInstance().create(MobileConfig.class, System.getProperties());
    }

    public static String getUsername() {
        return getConfig().username();
    }

    public static String getPassword() {
        return getConfig().password();
    }

    public static String getApp() {
        return getConfig().app();
    }

    public static PlatformHelper getPlatform() {
        return getConfig().platform();
    }

    public static String getBrowserStackUrl() {
        return getConfig().browserstackURL();
    }

}
