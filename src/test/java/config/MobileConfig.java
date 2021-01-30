package config;

import helpers.PlatformHelper;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:remote.properties",
        "classpath:${platform}.properties"
})
public interface MobileConfig extends Config {

    @Key("browserstack.platform")
    PlatformHelper platform();

    @Key("browserstack.username")
    String username();

    @Key("browserstack.password")
    String password();

    @Key("browserstack.app")
    String app();

    @Key("browserstack.url")
    String browserstackURL();
}
