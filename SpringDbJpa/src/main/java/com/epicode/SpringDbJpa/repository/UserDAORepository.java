package com.epicode.SpringDbJpa.repository;

import com.epicode.SpringDbJpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAORepository extends JpaRepository<User, Long> {
    public List<User> findByCity(String city);
    public List<User> findByNameAndLastname(String name, String lastname);
    public List<User> findByAgeBetween(Integer min, Integer max);

    @Query("SELECT u FROM User u WHERE u.age > :x")
    public List<User> miaQuery(Integer x);
}
