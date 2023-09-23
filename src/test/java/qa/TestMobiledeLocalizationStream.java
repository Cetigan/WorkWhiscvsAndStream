package qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestMobiledeLocalizationStream {
   

    static Stream<Arguments> MobiledeShowldHaveText(){
        Stream<Arguments> argumentsStream = Stream.of(
                Arguments.of("Español", List.of("Pie de imprenta","Privacidad","Configuración de privacidad","Declaración sobre el uso de cookies","Conducta para publicar anuncios en línea","Feedback")),
                Arguments.of("Русский", List.of("О компании","Конфиденциальность","настройки конфиденциальности","Заявление об использовании файлов cookie","Интерактивная реклама, зависящая от поведения","Обратная связь"))
        );
        return argumentsStream;
    }
@MethodSource

@ParameterizedTest
    void MobiledeShowldHaveText(String language,List<String> buttons) {
    Selenide.open("https://www.mobile.de/");
    $(".mde-consent-accept-btn").click();
    $$(".vyfkf").first().scrollIntoView(true).click();
    $$(".vyfkf").first().selectOption(language);
    $$(".u-margin-top-18 a").filter(visible).shouldHave(texts(buttons));



    }
    @AfterEach
    void cooke(){
        Selenide.clearBrowserCookies();
    }

}
