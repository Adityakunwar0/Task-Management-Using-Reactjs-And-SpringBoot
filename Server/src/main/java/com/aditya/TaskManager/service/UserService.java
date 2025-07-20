package com.aditya.TaskManager.service;

import com.aditya.TaskManager.dto.Response;
import com.aditya.TaskManager.dto.UserRequest;
import com.aditya.TaskManager.entity.User;

public interface UserService {

    Response<?> signUp(UserRequest userRequest);
    Response<?> login(UserRequest userRequest);
    User getCurrentLoggedInUser();

}
