package tests;

import com.codeborne.selenide.Configuration;
import driver.CustomMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;
import static helpers.BrowserStackHelper.getBSPublicLink;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = CustomMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void afterEach() {
        String sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browserstack build link", getBSPublicLink(sessionId));

        closeWebDriver();

        attachVideo(sessionId); // in browserstack video url generates after driver close
    }
}