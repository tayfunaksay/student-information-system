package com.studentinformationsystem.detailservice.model;

public enum AddressType {
    HOME(1, "Ev"),
    WORK(2, "İş");
    public final int addressTypeValue;
    public final String addressTypeName;

    AddressType(int addressTypeValue, String addressTypeName) {
        this.addressTypeValue = addressTypeValue;
        this.addressTypeName = addressTypeName;
    }

    public int getAddressTypeValue() {
        return addressTypeValue;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }
}
