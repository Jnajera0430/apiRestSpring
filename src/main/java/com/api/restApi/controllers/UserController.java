
package com.api.restApi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.restApi.models.UserModel;
import com.api.restApi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getListUsers(){
        return this.userService.getListUser();
    }

    @PostMapping()
    public UserModel createNewUser(@RequestBody UserModel newUser){
        return this.userService.createNewUser(newUser);
    }
}
