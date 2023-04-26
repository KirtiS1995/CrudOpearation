package com.bikkadit.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.crudoperation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
