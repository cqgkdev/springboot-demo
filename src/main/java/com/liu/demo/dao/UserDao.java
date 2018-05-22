package com.liu.demo.dao;

import com.liu.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao  extends JpaRepository<User, Long> {
    User findByName(String name);
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

    User findByNameAndAge(String name, Integer age);

}
