import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ActionDragAndDropTest {
    @BeforeAll
    public static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void dragAndDropActionHerokuTest(){
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200,0)
                .release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

}

