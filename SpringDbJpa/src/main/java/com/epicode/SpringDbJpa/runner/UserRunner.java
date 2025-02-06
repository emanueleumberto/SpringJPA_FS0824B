package com.epicode.SpringDbJpa.runner;

import com.epicode.SpringDbJpa.model.User;
import com.epicode.SpringDbJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UserRunner...");

        //User u1 = userService.createAdminUser();
        //System.out.println(u1);


        //User u2 = userService.createFakeUser();
        //System.out.println(u2);

        /*User u3 = userService.createCustomUser()
                .builder()
                .name("Giuseppe")
                .lastname("Verdi")
                .city("Milano")
                .age(22)
                .email("g.verdi@example.com")
                .password("qwerty").build();*/
        //System.out.println(u3);

        // Test metodi JPA
        //userService.insertUser(u1);
        //userService.insertUser(u2);
        //userService.insertUser(u3);

        //User u = userService.getUser(52);
        //System.out.println(u);
        //u.setCity("Palermo");
        //userService.updateUser(u);

        //userService.deleteUser(u);

        List<User> lista = userService.getAll();
        lista.forEach(System.out::println);

    }
}
