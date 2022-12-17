package com.andreev.allureReports;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@Nested
@DisplayName("Проверка наличия issue на чистом selenide")
public class SelenideTestNameIssue {

    @Test
    @DisplayName("В репозитории arteeem13/allure_reports_in_testsсть issue c названием Add information in readme")
    public void checkNameIssue() {

        open("https://github.com/");

        $(".js-site-search-form").click();
        $(".header-search-input").setValue("arteeem13/allure_reports_in_tests").pressEnter();
        $(linkText("arteeem13/allure_reports_in_tests")).click();
        $("#issues-tab").click();
        $(("#issue_1_link")).shouldHave(Condition.text("Add information in readme"));
    }
}
