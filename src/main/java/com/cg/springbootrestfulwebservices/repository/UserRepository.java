package com.cg.springbootrestfulwebservices.repository;

import com.cg.springbootrestfulwebservices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
