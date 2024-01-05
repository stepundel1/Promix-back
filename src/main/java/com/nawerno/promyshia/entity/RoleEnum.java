package com.nawerno.promyshia.entity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleEnum {
    ROLE_ADMIN("role_admin"),
    ROLE_CLIENT("role_client");


    private final String id;

    RoleEnum(String id) {
        this.id = id;
    }

    @JsonCreator
    public static RoleEnum fromJson(String json) {
        return RoleEnum.valueOf(json.toUpperCase());
    }

    public static RoleEnum fromId(String id) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getId().equals(id)) {
                return roleEnum;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    @JsonValue
    public String getJson() {
        return this.toString().toLowerCase();
    }
}
