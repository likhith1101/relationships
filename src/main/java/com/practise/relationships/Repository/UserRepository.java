package com.practise.relationships.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.relationships.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
