
package com.api.restApi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.restApi.exceptions.UserNotFoundException;
import com.api.restApi.models.UserModel;
import com.api.restApi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getListUsers() {
        return this.userService.getListUser();
    }

    @PostMapping()
    public UserModel createNewUser(@RequestBody UserModel newUser) {
        return this.userService.createNewUser(newUser);
    }

    @GetMapping(path = "/{id}")
    public UserModel findUserById(@PathVariable("id") Long id) {
        return this.userService.findOneById(id);
    }

    @GetMapping(path = "/{name}")
    public ArrayList<UserModel> getFilterByName(@PathVariable("name") String name) {
        return this.userService.getByName(name);
    }

    @PatchMapping()
    public UserModel editUser(@RequestBody UserModel user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping()
    public boolean deleteUser(@RequestBody Long id) {
        return this.userService.deleteUser(id);
    }
}
