package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.MobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {

        if (deviceHost == null) {
            deviceHost = "mobile";
        }

        switch (deviceHost) {
            case "android":
            case "ios":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "mobile":
                Configuration.browser = MobileDriver.class.getName();
                break;
        }
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();

//        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();

        Attach.addVideo(sessionId);
    }
}