package com.src.main.enums.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mj on 24/5/16.
 */
public enum Authorities {
    ADMIN(1, "${administrator}"),
    MODERATOR(2, "${moderator}"),
    USER(3, "${user}");

    Integer authorityCode;
    String discription;

    public Integer getAuthorityCode() {
        return authorityCode;
    }

    public String getDiscription() {
        return discription;
    }

    Authorities(int value, String discription) {
        this.authorityCode = value;
        this.discription = discription;
    }

    static Map<Integer, Authorities> authoritiesMap = new HashMap<>();

    static {
        for (Authorities authorities : Authorities.values()) {
            authoritiesMap.put(authorities.getAuthorityCode(), authorities);
        }
    }

    public static Authorities valueOf(Integer enumValue) {
        return authoritiesMap.get(enumValue);
    }
}
