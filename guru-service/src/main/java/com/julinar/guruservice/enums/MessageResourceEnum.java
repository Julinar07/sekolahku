package com.julinar.siswaservice.enums;

public enum MessageResourceEnum {
    SUCCESS("00"),
    SUCCESS_WITH_MESSAGE("01"),
    FAILED("02"),
    FAILED_WITH_MESSAGE("03"),
    FAILED_AUTH("04");

    private String code;
    private String property;
    private String message;

    MessageResourceEnum(String code) {
        this.code = code;
    }

    MessageResourceEnum(String code, String property) {
        this.code = code;
        this.property = property;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
