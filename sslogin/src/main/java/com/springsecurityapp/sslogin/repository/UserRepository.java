package com.springsecurityapp.sslogin.repository;

import org.springframework.data.repository.CrudRepository;

import com.springsecurityapp.sslogin.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
