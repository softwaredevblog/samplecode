package com.softwaredevblog.repository;

import com.softwaredevblog.entities.RestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestUserRepository extends CrudRepository<RestUser, Long> {
    RestUser findByUsername(String username);
}
