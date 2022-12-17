package com.andreev.testWithAllureReports;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public static void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repository}")
    public static void searchRepository(String repository) {
        $(".js-site-search-form").click();
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public static void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Переходим в Issues")
    public static void goToIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие issue с названием {issueName}")
    public static void shouldIssueWithName(String issueName) {
        $(("#issue_1_link")).shouldHave(Condition.text(issueName));
        WebAttachments.takeScreenshot();
    }
}
