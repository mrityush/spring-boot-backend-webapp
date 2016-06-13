package com.src.main.enums.exceptions;

public enum CustomExceptionEnum {

    GENERIC_EXCEPTION("GENERIC_EXCEPTION", "Generic Exception here"),
    USER_NOT_AUTHENTICATED("USER_NOT_AUTHENTICATED_EXCEPTION", "User Not Authenticated"),
    TEST_EXCEPTION("TEST_EXCEPTION", "Test Exception"),
    INVALID_USER_EXCEPTION("INVALID_USER_EXCEPTION", "Invalid User"),
    NO_TAG_BY_THIS_ID_EXCEPTION("NO_TAG_BY_THIS_ID_EXCEPTION", "No Tag By This Id");
    private final String key;
    private final String name;

    CustomExceptionEnum(String name, String code) {
        this.name = name;
        this.key = code;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
