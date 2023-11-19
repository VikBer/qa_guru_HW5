import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class HoverTest {
    @BeforeAll
    public static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void hoverGithubSolutionTest(){
        open("https://github.com");
        $(".d-lg-flex.list-style-none").$(byText("Solutions")).hover();
        $("[href='/team']").click();
        $(".h1-mktg").shouldHave(text("Build like the best"));
    }

}

