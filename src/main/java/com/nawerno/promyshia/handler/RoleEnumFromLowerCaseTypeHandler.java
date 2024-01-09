package com.nawerno.promyshia.handler;

import com.nawerno.promyshia.entity.RoleEnum;

public class RoleEnumFromLowerCaseTypeHandler extends EnumFromLowerCaseTypeHandler<RoleEnum> {

    public RoleEnumFromLowerCaseTypeHandler(Class<RoleEnum> type) {
        super(type);
    }
}