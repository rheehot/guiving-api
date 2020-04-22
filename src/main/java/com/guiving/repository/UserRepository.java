package com.guiving.repository;

import com.guiving.domain.entity.Guiver;
import com.guiving.domain.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAll();

}
