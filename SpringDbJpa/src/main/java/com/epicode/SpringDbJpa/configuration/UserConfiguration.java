package com.epicode.SpringDbJpa.configuration;

import com.epicode.SpringDbJpa.model.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class UserConfiguration {

    @Value("${user.admin.name}") private String adminName;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.age}") private int adminAge;
    @Value("${user.admin.email}") private String adminEmail;
    @Value("${user.admin.password}") private String adminPassword;

    @Bean("AdminUserBean")
    @Scope("singleton")
    public User adminUser() {
        return new User(
                adminName,
                adminLastname,
                adminCity,
                adminAge,
                adminEmail,
                adminPassword
        );
    }

    @Bean("FakeUserBean")
    @Scope("prototype")
    public User fakeUser() {
        Faker fake = Faker.instance(new Locale("it-IT"));
        /*User u = new User();
        u.setName(fake.name().firstName());
        u.setLastname(fake.name().lastName());
        u.setCity(fake.address().city());
        u.setAge(fake.number().numberBetween(18,70));
        u.setEmail(fake.internet().emailAddress());
        u.setPassword(fake.internet().password());
        return u;*/
        return new User(
                fake.name().firstName(),
                fake.name().lastName(),
                fake.address().city(),
                fake.number().numberBetween(18,70),
                fake.internet().emailAddress(),
                fake.internet().password()
                );
    }

    @Bean("CustomUserBean")
    @Scope("prototype")
    public User customUser() {
        return new User();
    }

}
