package guru.qa.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private WebSteps webSteps = new WebSteps();

    @Test
    public void shouldSeeIssueInRepository(){
        webSteps.openPage();
        webSteps.searchRepository(REPOSITORY);
        webSteps.goToRepository(REPOSITORY);
        webSteps.openIssuesTab();
        webSteps.checkOpenedIssueSection();
    }
}
