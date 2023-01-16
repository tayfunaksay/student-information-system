package com.studentinformationsystem.courseschedulingservice.model.enums;

public enum DayName {
    PZT(1, "Pazartesi"),
    SALI(2, "Salı"),
    ÇRŞ(3, "Çarşamba"),
    PER(4, "Perşembe"),
    CUM(5, "Cuma"),
    CTS(6, "Cumartesi"),
    PZR(7, "Pazar");
    private final int dayNameValue;
    private final String dayName;

    DayName(int dayNameValue, String dayName) {
        this.dayNameValue = dayNameValue;
        this.dayName = dayName;
    }

    public int getDayNameValue() {
        return dayNameValue;
    }

    public String getDayName() {
        return dayName;
    }
}
