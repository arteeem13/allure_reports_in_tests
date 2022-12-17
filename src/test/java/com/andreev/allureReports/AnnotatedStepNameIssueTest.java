package com.andreev.allureReports;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.andreev.allureReports.WebSteps.*;

@Nested
@DisplayName("Проверка наличия issue через annotated steps")
public class AnnotatedStepNameIssueTest {

    private final static String REPOSITORY = "arteeem13/allure_reports_in_tests";
    private final static String NAME_ISSUE = "Add information in readme";

    @Test
    @DisplayName("В репозитории " + REPOSITORY + " есть issue c названием " + NAME_ISSUE)
    public void checkNameIssue() {
        openMainPage();
        searchRepository(REPOSITORY);
        goToRepository(REPOSITORY);
        goToIssueTab();
        shouldIssueWithName(NAME_ISSUE);
    }
}
