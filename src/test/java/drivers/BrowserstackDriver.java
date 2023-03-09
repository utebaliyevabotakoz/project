package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private final static BrowserstackConfig CONFIG = ConfigFactory.create(BrowserstackConfig.class);

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", CONFIG.login());
        mutableCapabilities.setCapability("browserstack.key", CONFIG.password());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", CONFIG.appUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", CONFIG.device());
        mutableCapabilities.setCapability("os_version", CONFIG.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", CONFIG.projectName());
        mutableCapabilities.setCapability("build", CONFIG.buildName());
        mutableCapabilities.setCapability("name", CONFIG.testName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(new URL(CONFIG.baseUrl()), mutableCapabilities);
    }
}