package com.blyzniukd.hw.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Objects.isNull;

public class Period implements PrintHtmlInterface {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/yyyy");
    private Date start;
    private Date finish;

    public Period(Date start, Date finish) {
        this.start = start;
        this.finish = finish;
    }

    public Period(Date start) {
        this.start = start;
    }

    @Override
    public String printHtml() {
        return DATE_FORMATTER.format(start) + " - " + (isNull(finish) ? "Now" : DATE_FORMATTER.format(finish));
    }
}
