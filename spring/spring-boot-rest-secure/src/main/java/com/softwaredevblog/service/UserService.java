package com.softwaredevblog.service;

import com.softwaredevblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component(value="userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

}
