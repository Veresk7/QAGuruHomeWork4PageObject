package textboxpageobject.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.element;

public class ResultFormComponent {

    public ResultFormComponent checkResult(String fieldName, String checkValue) {
        element(".table-responsive").$(byText(fieldName)).parent().shouldHave(text(checkValue));

        return this;
    }

    public ResultFormComponent checkResult(String value) {
        if(value.equals("negativeCheck")) {
            element(".modal-dialog").shouldNotBe(visible);
        }

        return this;
    }
}
