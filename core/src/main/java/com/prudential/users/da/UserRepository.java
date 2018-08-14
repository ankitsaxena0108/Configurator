package com.prudential.users.da;

import org.springframework.data.repository.CrudRepository;

import com.prudential.core.users.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

    public User findByLogin(String login);
    
}
