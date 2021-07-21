package guru.qa.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testRepositoryIssue() {
        step("Открыть страницу github", () -> {
            open("https://github.com");
        });
        step("Найти и открыть репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        });
        step("Перейти в репозиторий " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });

        step("Перейти в раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверить, что открылся раздел Issues", () -> {
            $(byText("Issues")).should(Condition.visible);
        });
    }
}
