package com.dlsu.joshua;

public class UserSession {
    private String idNumber;

    public UserSession(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
