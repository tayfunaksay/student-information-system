package com.studentinformationsystem.courseschedulingservice.model.enums;

public enum Branch {
    I(1, "Birinci Şube"),
    II(2, "İkinci Şube"),
    III(3, "Üçüncü Şube"),
    IV(4, "Dördüncü Şube");
    private final int branchValue;
    private final String branchName;

    Branch(int branchValue, String branchName) {
        this.branchValue = branchValue;
        this.branchName = branchName;
    }

    public int getBranchValue() {
        return branchValue;
    }

    public String getBranchName() {
        return branchName;
    }
}
