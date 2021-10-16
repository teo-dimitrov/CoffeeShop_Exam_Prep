package com.example.coffeeshop_exam_prep.service;

import com.example.coffeeshop_exam_prep.model.Service.UserServiceModel;
import com.example.coffeeshop_exam_prep.model.entity.User;
import com.example.coffeeshop_exam_prep.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(long id);

    List<UserViewModel> findAllUserAndCountOfOrdersByCountDesc();
}


