
package com.api.restApi.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.restApi.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long>{
    public abstract ArrayList<UserModel> findByName(String name);
}
