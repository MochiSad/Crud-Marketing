package com.mochimochi.backcrudmarketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mochimochi.backcrudmarketing.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
