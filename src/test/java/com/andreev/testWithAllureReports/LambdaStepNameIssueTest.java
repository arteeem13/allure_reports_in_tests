package com.andreev.testWithAllureReports;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Nested
@DisplayName("Проверка наличия issue через лямбда-шаги")
public class LambdaStepNameIssueTest {

    private final static String REPOSITORY = "arteeem13/allure_reports_in_tests";
    private final static String NAME_ISSUE = "Add information in readme";

    @Test
    @DisplayName("В репозитории " + REPOSITORY + " есть issue c названием " + NAME_ISSUE)
    public void checkNameIssue() {

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".js-site-search-form").click();
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Переходим в Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие issue с названием " + NAME_ISSUE, () -> {
            $(("#issue_1_link")).shouldHave(Condition.text(NAME_ISSUE));
            WebAttachments.takeScreenshot();
        });
    }
}
