package com.nawerno.promyshia.controller;

import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
@Tag(name = "users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "id")
    public User getById(@PathVariable("id")int id){
        return userService.getById(id);
    }
}
