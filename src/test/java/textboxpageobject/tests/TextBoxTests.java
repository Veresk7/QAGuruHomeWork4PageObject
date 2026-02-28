package textboxpageobject.tests;

import textboxpageobject.pages.components.ResultFormComponent;
import textboxpageobject.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends textboxpageobject.tests.TestBase {
    RegistrationPage testPage = new RegistrationPage();
    ResultFormComponent modalWindowTestCheck = new ResultFormComponent();

    @Test
    void successfulAllFieldsFillCheck() {
        testPage.openPage()
                //.removeBanners() /Скрипт отключен, т.к. блокирует прохождения теста
                .setFirstName("Guns")
                .setLastName("'n Roses")
                .setEmail("one@two.com")
                .setGender("Male")
                .setPhoneNumber("8946146168")
                .setDateOfbirth("01", "September", "1999")
                //.removeBanners()
                .setSubject("Hi")
                .setHobbies("Sports")
                .uploadTestPicture("example_image_hw3.jpg")
                .setAddress("Surviver Shtrasse 1")
                .chooseState("Uttar Pradesh")
                .chooseCity("Agra")
                .doSubmit();
        modalWindowTestCheck.checkResult("Student Name", "Guns 'n Roses")
                .checkResult("Student Email", "one@two.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8946146168")
                .checkResult("Date of Birth", "01 September,1999")
                .checkResult("Subjects", "Hindi")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "example_image_hw3.jpg")
                .checkResult("Address", "Surviver Shtrasse 1")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }

    @Test
    void fillingInOnlyNecessaryFields() {
        testPage.openPage()
                //.removeBanners() /Скрипт отключен, т.к. блокирует прохождения теста
                .setFirstName("Guns")
                .setLastName("'n Roses")
                .setGender("Male")
                .setPhoneNumber("8946146168")
                .setDateOfbirth("01", "September", "2000")
                .doSubmit();
        modalWindowTestCheck.checkResult("Student Name", "Guns 'n Roses")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8946146168")
                .checkResult("Date of Birth", "01 September,2000");

    }

    @Test
    void negativTest() {
        testPage.openPage()
                // .removeBanners() /Скрипт отключен, т.к. блокирует прохождения теста
                .setFirstName("Guns")
                .setLastName("'n Roses")
                .setGender("Male")
                .doSubmit();
        modalWindowTestCheck.checkResult("negativeCheck");

    }

}
