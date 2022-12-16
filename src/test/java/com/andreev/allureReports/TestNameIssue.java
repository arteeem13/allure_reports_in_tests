package com.andreev.allureReports;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.*;

public class TestNameIssue {

    @Test
    public void checkNameIssue() {

        open("https://github.com/");

        $(".js-site-search-form").click();
        $(".header-search-input").setValue("arteeem13/allure_reports_in_tests").pressEnter();
        $(linkText("arteeem13/allure_reports_in_tests")).click();
        $("#issues-tab").click();
        $(("#issue_1_link")).shouldHave(Condition.text("Add information in readme"));
    }
}
