
package com.api.restApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.restApi.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long>{
    
}
