package swip.ch18datepicker.jquery.v5;


import swip.ch15pageflow.framework.Browser;
import swip.ch18datepicker.datepicker.Calendar;
import swip.ch18datepicker.datepicker.CalendarPicker;
import swip.ch18datepicker.datepicker.Datepicker;

import java.time.Month;

import static swip.ch17jquerydatepicker.JQueryById.DATE_FIELD;
import static swip.ch18datepicker.jquery.v5.JQueryCalendarControls.*;
import static swip.ch18datepicker.jquery.v5.JQueryCalendarDisplayValue.DISPLAY_MONTH;
import static swip.ch18datepicker.jquery.v5.JQueryCalendarDisplayValue.DISPLAY_YEAR;


public class JQueryDatepickerPage {

    private final Browser browser;

    private final Datepicker datepicker;

    public JQueryDatepickerPage(Browser browser) {
        this.browser = browser;
        this.datepicker = new Datepicker(  //<1>
            new Calendar(browser, TRIGGER),        //<2>
            new CalendarPicker(browser, PREVIOUS_YEAR, NEXT_YEAR, DISPLAY_YEAR),     //<3>
            new CalendarPicker(browser, PREVIOUS_MONTH, NEXT_MONTH, DISPLAY_MONTH),  //<4>
            new JQueryDayPicker(browser)      //<5>
        );
    }

    public void pick(Month month, int day, int year) {           //<6>
        datepicker.pick(month, day, year);
    }

    public String getDate() {                                  //<7>
        return browser.getInputText(DATE_FIELD);
    }
}