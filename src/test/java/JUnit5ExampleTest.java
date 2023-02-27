import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;

public class JUnit5ExampleTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
     }
    @Test
    void searchJUnit5ExampleTest() {
        // Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // Убедится, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        // Открыть страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        // Проверить что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:\n"+
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();"));
    }
}


