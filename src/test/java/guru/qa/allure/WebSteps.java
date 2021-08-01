package guru.qa.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открыть страницу github ")
    public void openPage(){
        open("https://github.com");
    }
    @Step("Найти {repository}")
    public void searchRepository(String nameRepository){
        $(".header-search-input").click();
        $(".header-search-input").setValue(nameRepository).submit();
    }
    @Step("Открыть {repository}")
    public void goToRepository(String nameRepository){
        $(linkText(nameRepository)).click();
    }
    @Step("Перейти в раздел Issues ")
    public void openIssuesTab(){
        $(partialLinkText("Issues")).click();
    }
    @Step("Проверить, что открылся раздел Issues")
    public void checkOpenedIssueSection(){
        $(byText("Issues")).should(Condition.visible);
    }
}
//msheme was here
