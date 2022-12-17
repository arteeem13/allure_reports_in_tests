package com.andreev.nameIssueTestWithAllure;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.andreev.nameIssueTestWithAllure.WebSteps.*;

@Nested
@DisplayName("Проверка наличия issue через annotated steps")
@Owner("AndreevAD")
@Feature("Issue")
public class AnnotatedStepTest {

    private final static String REPOSITORY = "arteeem13/allure_reports_in_tests";
    private final static String NAME_ISSUE = "Add information in readme";

    @Test
    @Story("Проверка по названию issue")
    @DisplayName("В репозитории " + REPOSITORY + " есть issue c названием " + NAME_ISSUE)
    @Severity(SeverityLevel.CRITICAL)
    public void checkNameIssue() {
        openMainPage();
        searchRepository(REPOSITORY);
        goToRepository(REPOSITORY);
        goToIssueTab();
        shouldIssueWithName(NAME_ISSUE);
    }
}
