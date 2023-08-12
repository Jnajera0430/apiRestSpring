
package com.api.restApi.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.restApi.exceptions.UserNotFoundException;
import com.api.restApi.models.UserModel;
import com.api.restApi.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getListUser() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel createNewUser(UserModel newUser) {
        return (UserModel) userRepository.save(newUser);
    }

    public UserModel findOneById(Long id) throws UserNotFoundException {
        return this.userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        /*
         * Optional<UserModel> optonialUser = this.userRepository.findById(id);
         * if(optonialUser.isPresent()){
         * throw new UserPrincipalNotFoundException("User with ID " + id +
         * " not found");
         * }
         * return optonialUser.get();
         */
    }

    public UserModel deleteUser(Long id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException();
        }

        UserModel foundUser = optionalUser.get();
        // foundUser.setState(false);
        // change state
        foundUser.deleteUser();
        userRepository.save(foundUser);
        return foundUser;
        /*
         * UserModel foundUser = this.userRepository.findById(id)
         * .orElseThrow(UserNotFoundException::new);
         * foundUser.setState(false);
         * return foundUser;
         */
    }

    public UserModel updateUser(UserModel user) {
        Long id = user.getId();
        Optional<UserModel> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException();
        }

        UserModel foundUser = optionalUser.get();
        foundUser.updateUser(user);
        return this.userRepository.save(foundUser);
    }
}
