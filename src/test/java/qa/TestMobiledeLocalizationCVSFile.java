package qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.nio.channels.FileChannel;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestMobiledeLocalizationCVSFile {
    @BeforeEach
    void open() {
        Selenide.open("https://www.mobile.de/");

    }


    @CsvFileSource(resources = "/testData.cvs")
    @ParameterizedTest(name = "rubrics must correspond to the language")
    @Tag("Localization-Test")
    void checkRubriksNames(String language, String rubrirks) {
        $(".mde-consent-accept-btn").click();
        $$(".vyfkf").first().scrollIntoView(true).click();
        $$(".vyfkf").first().selectOption(language);
        $(".header").shouldHave(text(rubrirks));


    }
    @AfterEach
    void cooke(){
       Selenide.clearBrowserCookies();
    }
}