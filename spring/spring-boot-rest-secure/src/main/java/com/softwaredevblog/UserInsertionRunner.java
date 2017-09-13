package com.softwaredevblog;

import com.softwaredevblog.entities.RestUser;
import com.softwaredevblog.repository.RestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserInsertionRunner implements CommandLineRunner {

    @Autowired
    private RestUserRepository restUserRepository;

    @Override
    public void run(String... strings) throws Exception {
        // Create a user with the ROLE_USER role
        RestUser user = new RestUser("user", "password", Arrays.asList("ROLE_USER"));
        // Create a user with the ROLE_ADMIN role
        RestUser admin = new RestUser("admin", "password", Arrays.asList("ROLE_ADMIN"));

        // Only save the users if they are not already in the DB
        if (restUserRepository.findByUsername(user.getUsername()) == null) {
            restUserRepository.save(user);
        };
        if (restUserRepository.findByUsername(admin.getUsername()) == null) {
            restUserRepository.save(admin);
        };
    }
}
