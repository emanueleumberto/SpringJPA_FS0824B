package com.epicode.SpringDbJpa.service;

import com.epicode.SpringDbJpa.model.User;
import com.epicode.SpringDbJpa.repository.UserDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserDAORepository db;

    @Autowired @Qualifier("FakeUserBean") private ObjectProvider<User> fakeUserProvider;
    @Autowired @Qualifier("AdminUserBean") private ObjectProvider<User> adminUserProvider;
    @Autowired @Qualifier("CustomUserBean") private ObjectProvider<User> customUserProvider;

    public User createFakeUser() {
        return fakeUserProvider.getObject();
    }

    public User createAdminUser() {
        return adminUserProvider.getObject();
    }

    public User createCustomUser() {
        return customUserProvider.getObject();
    }

    // JPA method
    public void insertUser(User user) {
        db.save(user);
        System.out.println("User inserito nel DB!");
    }

    public void updateUser(User user) {
        db.save(user);
        System.out.println("User modificato nel DB!");
    }

    public void deleteUser(User user) {
        db.delete(user);
        //db.deleteById(user.getId());
        System.out.println("User cancellato dal DB!");
    }

    public User getUser(long id) {
        return db.findById(id).get();
    }

    public List<User> getAll() {
        return db.findAll();
    }

}
