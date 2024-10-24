package com.example.demo.runners;


import com.example.demo.entites.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.services.UsersService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@Slf4j
public class UsersRunner implements CommandLineRunner {

    @Autowired
    private UsersService us;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);

        List<User> newUsers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            User nu = new User(faker.lordOfTheRings().character(),
                    faker.name().lastName(),
                    faker.internet().emailAddress(),
                    faker.random().nextInt(100));
            newUsers.add(nu);
        }


        // add
        try{
            us.saveMany(newUsers);
        }catch(ValidationException x){
            log.error(x.getMessage());
        }


        // delete
        try{
            us.findByIdAndDelete(5);
        }catch(NotFoundException ex){
            log.error(ex.getMessage());
        }

        // query
        System.out.println("Solo Maggiorenni: \n");
        us.filterSoloMaggiorenni().forEach(System.out::println);




    }
}
