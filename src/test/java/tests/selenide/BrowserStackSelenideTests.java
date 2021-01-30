package tests.selenide;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;

public class BrowserStackSelenideTests extends TestBase {

    @Test
    @Tag("android")
    void searchAndroidTest() {
        step("Open application", () -> open());

        step("Type search", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });

        step("Verify content found", () ->
                $$(className("android.widget.TextView"))
                        .shouldHave(sizeGreaterThan(0))
        );
    }

    @Test
    @Tag("ios")
    void searchIOSTest() {
        step("Open application", () -> open());
        step("Type search", () -> {
            $(AccessibilityId("Text Button")).click();
            $(AccessibilityId("Text Input")).setValue("hello@browserstack.com").pressEnter();
        });
        step("Check entered text is visible", () -> {
            $(AccessibilityId("Text Output")).shouldHave(text("hello@browserstack.com"));
        });

    }
}