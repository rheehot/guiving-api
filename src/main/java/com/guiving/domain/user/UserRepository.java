package com.guiving.domain.user;

import com.guiving.domain.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @EntityGraph(attributePaths ={"cardSet"} )
    @Query("select DISTINCT u from User u ")
    List<User> findAll();

    List<User> findAllByEmail(String email);
}
