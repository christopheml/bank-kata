package fr.altherac.kata.statement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class PrintableDateFormatter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = createFormatter();

    private static DateTimeFormatter createFormatter() {
        return new DateTimeFormatterBuilder().appendPattern("d/M/y").toFormatter();
    }

    public String printableDate(LocalDate date) {
        return date.format(DATE_TIME_FORMATTER);
    }

}
