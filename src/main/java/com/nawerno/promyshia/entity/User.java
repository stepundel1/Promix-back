package com.nawerno.promyshia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String email;
    private String name;
    private RoleEnum role;
    private String password;
}
