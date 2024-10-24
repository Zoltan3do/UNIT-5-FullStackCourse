package com.example.demo.repositories;

import com.example.demo.entites.BlogPost;
import com.example.demo.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {

    List<User> findBySurname(String surname);

    List<User> findByNameAndSurname(String name, String surname);

    List<User> findByNameStartingWithIgnoreCase(String partialName);

    List<User> findByAgeLessThan(int age);

    List<User> findByNameIn(List<String> names);

    List<User> findByEmailIsNull();

    boolean existsByEmail(String email);

    @Query("select u from user u where u.age >= 18 ")
    List<User> filterBySoloMaggiorenni();

    @Query("select u from user u.age >= :age")
    List<User> filterByAge(int age);

    @Query(value = "select * from users where age >= 18", nativeQuery = true)
    List<User> filterBysSoloMaggiorenniNative();
}
