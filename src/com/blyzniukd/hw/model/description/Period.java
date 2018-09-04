package com.blyzniukd.hw.model.description;

import com.blyzniukd.hw.model.PrintHtmlInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Period implements PrintHtmlInterface {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM-YYYY");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(start, period.start) &&
                Objects.equals(finish, period.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish);
    }
}