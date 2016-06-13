package com.src.main.enums.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mj on 24/5/16.
 */
public enum UserStatus {
//    ACTIVE, INACTIVE, IN_TRANSIT, FAILED, SENT;

    ACTIVE(1, "${item.active.status}"),

    INACTIVE(2, "${item.inactive.status}"),

    BLOCKED(3, "${user.blocked}");

    Integer value;
    String description;

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    UserStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    static Map<Integer, UserStatus> authoritiesMap = new HashMap<>();

    static {
        for (UserStatus generalStatus : UserStatus.values()) {
            authoritiesMap.put(generalStatus.getValue(), generalStatus);
        }
    }

    public static UserStatus valueOf(Integer enumValue) {
        return authoritiesMap.get(enumValue);
    }
}
