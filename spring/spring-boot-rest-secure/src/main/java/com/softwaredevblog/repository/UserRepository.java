package com.softwaredevblog.repository;

import com.softwaredevblog.entities.RestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<RestUser, Long> {
    RestUser findByUsername(String username);
}
