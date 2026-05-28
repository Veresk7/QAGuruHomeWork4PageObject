package textboxpageobject.pages.components;

import com.codeborne.selenide.SelenideElement;
import textboxpageobject.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.element;

public class ResultFormComponent {
    private final SelenideElement
        tableResponsive = element(".table-responsive"),
        modalDialog = element(".modal-dialog"),
        modalDialogName = element(".modal-title");

    public ResultFormComponent checkResult(String fieldName, String checkValue) {
        tableResponsive.$(byText(fieldName)).parent().shouldHave(text(checkValue));

        return this;
    }

    public ResultFormComponent checkResult(String value) {
        if(value.equals("negativeCheck")) {
            modalDialog.shouldNotBe(visible);
        }

        return this;
    }


    public ResultFormComponent modalDialogOpen () {
        modalDialog.should(appear);

        return this;
    }

    public ResultFormComponent modalDialogName (String value) {
        modalDialogName.shouldHave(text(value));

        return this;
    }
}
