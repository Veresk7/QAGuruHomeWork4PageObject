package TextBoxPageObject.Pages;

import TextBoxPageObject.Pages.Components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = element("#firstName"),
            lastNameInput = element("#lastName"),
            emailInput = element("#userEmail"),
            genderCheckBox = element("#genterWrapper"),
            phoneNumber = element("#userNumber"),
            setDateOfBirth = element("#dateOfBirthInput"),
            subjectsInput = element("#subjectsInput"),
            hobbiesSelector = element("#hobbiesWrapper"),
            uploadPicture = element("#uploadPicture"),
            addressInputField = element("#currentAddress"),
            stateSelector = element("#state"),
            inputStateWindow = element("#react-select-3-input"),
            citySelector = element("#city"),
            inputCityWindow = element("#react-select-4-input"),
            stateCityVaueSelector = element(".css-26l3qy-menu"),
            submitButton = element("#submit");
    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
//    element(byText("Forms")).click(); /Альтернативный сценарий открытия формы. Был период, когда форма не открывалась по прямой ссылке
//    element(byText("Practice Form")).click();


        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail (String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderCheckBox.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value);
        element(".subjects-auto-complete__option").scrollTo();
        element(".subjects-auto-complete__menu-list").$(byText("Hindi")).click();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesSelector.$(byText("Sports")).click();

        return this;
    }

    public RegistrationPage uploadTestPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInputField.click();
        addressInputField.setValue(value);

        return this;
    }

    public RegistrationPage chooseState(String value) {
        stateSelector.click();
        inputStateWindow.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage chooseCity(String value) {
        citySelector.click();
        inputCityWindow.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage doSubmit() {
        submitButton.scrollTo();
        submitButton.click();

        return this;
    }

    public RegistrationPage setDateOfbirth(String day, String month, String year) {
        setDateOfBirth.click();
        calendarComponent.calendarSetDate(day, month, year);

        return this;
    }

}
