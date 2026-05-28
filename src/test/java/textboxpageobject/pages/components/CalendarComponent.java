package textboxpageobject.pages.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.files.DownloadActions.click;

public class  CalendarComponent {
private final SelenideElement
    calendarYearSelector = element(".react-datepicker__year-select"),
    calendarMonthSelector = element(".react-datepicker__month-select");

    public void calendarSetDate(String day, String month, String year) {
        calendarMonthSelector.selectOption(month);
        calendarYearSelector.selectOption(year);
        calendarDaySelectorBuilder(day).click();
    }

    public SelenideElement calendarDaySelectorBuilder (String value) {
        SelenideElement calendarDaySelector = element(".react-datepicker__day--0" + value + ":not(.react-datepicker__day--outside-month)");

        return calendarDaySelector;
    }
}
