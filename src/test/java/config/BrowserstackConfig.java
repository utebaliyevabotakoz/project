package config;

import org.aeonbits.owner.Config;

@BrowserstackConfig.LoadPolicy(BrowserstackConfig.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "system:properties",
        "classpath:${deviceHost}.properties",
        "classpath:secret.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

    @Key("mobile.version")
    String mobileVersion();

    @Key("mobile.device")
    String mobileDevice();

    @Key("mobile.app.path")
    String mobileAppPath();

    @Key("mobile.platformName")
    String mobilePlatformName();

    @Key("browsrrstackPlatformName")
    String browsrrstackPlatformName();

    @Key("mobile.apppackage")
    String mobileAppPackage();

    @Key("mobile.appactivity")
    String mobileAppActivity();

    @Key("mobile.url")
    String mobileUrl();

    @Key("deviceHost")
    String deviceHost();

}