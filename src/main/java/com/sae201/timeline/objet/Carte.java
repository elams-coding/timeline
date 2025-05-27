package com.sae201.timeline.objet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Carte {
    private static final int JOUR_PAR_DEFAUT = 1;
    private static final DateTimeFormatter formatDeDate = DateTimeFormatter.ofPattern("yyyy mm");

    private String titre;
    private static LocalDate date;

    public static void main(String[] args) {
        Carte.date = LocalDate.of(2010, 12, JOUR_PAR_DEFAUT);
        String dateFormatee = date.format(formatDeDate);

        System.out.println(dateFormatee);
    }
}
