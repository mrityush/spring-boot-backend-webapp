package com.src.main.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mj on 24/5/16.
 */
public enum ItemGeneralStatus {
    ACTIVE(1, "${item.active.status}"),
    INACTIVE(2, "${item.inactive.status}");

    Integer value;
    String description;

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    ItemGeneralStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    static Map<Integer, ItemGeneralStatus> authoritiesMap = new HashMap<>();

    static {
        for (ItemGeneralStatus generalStatus : ItemGeneralStatus.values()) {
            authoritiesMap.put(generalStatus.getValue(), generalStatus);
        }
    }

    public static ItemGeneralStatus valueOf(Integer enumValue) {
        return authoritiesMap.get(enumValue);
    }
}
