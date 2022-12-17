package com.andreev.nameIssueTestWithAllure;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@Nested
@DisplayName("Проверка наличия issue на чистом selenide с листнером")
public class SelenideWithListenerTest {

    @Test
    @DisplayName("В репозитории arteeem13/allure_reports_in_testsсть issue c названием Add information in readme")
    public void checkNameIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".js-site-search-form").click();
        $(".header-search-input").setValue("arteeem13/allure_reports_in_tests").pressEnter();
        $(linkText("arteeem13/allure_reports_in_tests")).click();
        $("#issues-tab").click();
        $(("#issue_1_link")).shouldHave(Condition.text("Add information in readme"));
    }
}
