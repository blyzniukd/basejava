package com.blyzniukd.hw.model.description;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Period {

//    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM-YYYY");

    private LocalDate start;
    private LocalDate finish;

    public Period(LocalDate start, LocalDate finish) {
        this.start = start;
        this.finish = finish;
    }

    public Period(LocalDate start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return start.format(DateTimeFormatter.ofPattern("MM/YYYY"))+ "-" + (isNull(finish) ? "Now" : finish.format(DateTimeFormatter.ofPattern("MM/YYYY")));
        //return DATE_FORMATTER.format(start) + " - " + (isNull(finish) ? "Now" : DATE_FORMATTER.format(finish));
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
