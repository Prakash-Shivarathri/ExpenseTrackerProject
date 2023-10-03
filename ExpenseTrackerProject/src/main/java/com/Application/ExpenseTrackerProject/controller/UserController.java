package com.Application.ExpenseTrackerProject.controller;


import com.Application.ExpenseTrackerProject.request.CreateUserRequest;
import com.Application.ExpenseTrackerProject.response.CreateUserResponse;
import com.Application.ExpenseTrackerProject.response.GenericResponse;
import com.Application.ExpenseTrackerProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/expenseTracker")
public class UserController {

    @Autowired
    private UserService userService;

    // creation part
    @PostMapping("/addUser")
    public GenericResponse<CreateUserResponse> addUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        CreateUserResponse createUserResponse = userService.addUser(createUserRequest);
        GenericResponse genericResponse = GenericResponse.builder().
                code(HttpStatus.OK.value()).
                message("user details has been saved").
                statusCode(0).data(createUserResponse)
                .build();
        return genericResponse;

    }
}