package swip.ch18datepicker.jquery.v2_5;


import swip.ch15pageflow.framework.Browser;

import java.util.function.Function;

import static swip.ch17jquerydatepicker.locators.JQueryById.DATE_FIELD;

public class Trigger implements Function<Browser,Void> {

    @Override
    public Void apply(Browser browser) {
        browser.click(DATE_FIELD);
        return null;
    }
}