package com.example.demo.services;

import com.example.demo.entites.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsersService {
    @Autowired
    private UsersRepository ur;

    public void saveUser(User u) {
        // 1. controllo che la mail fornita non sia gia nel db.
        if (ur.existsByEmail(u.getEmail())) throw new ValidationException("Email già in uso");

        // 2. effettuo ulteriori controlli di validazione dei campo forniti
        if (u.getName().length() < 2) throw new ValidationException("Il nome non è valido");

        // 3. Aggiungo ulteriori dati Server-Generated
        u.setProfileImg("https://placebear.com/200/300");

        // 4. Salvo l'utente
        ur.save(u);

        // 5. Log di avvenuto salvataggio
        log.info("L'utente " + u.getName() + " è stato salvato correttamente!");
    }

    public void saveMany(List<User> lu) {
        for (User u : lu) {
            try {
                this.saveUser(u);
            } catch (ValidationException ez) {
                log.error(ez.getMessage()); // chiedere come prende questo messaggio
            }
        }
    }

    public List<User> findAll() {
        return ur.findAll();
    }

    public User findById(long userId) {
        return ur.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }

    public void findByIdAndUpdate(long userId, User updatedUser) {
        // 1. Cerchiamo l'utente tramite id.
        User found = this.findById(userId);

        // 2. Aggionriamo i campi dell'utente.
        found.setName(updatedUser.getName());
        found.setSurname(updatedUser.getSurname());
        found.setEmail(updatedUser.getEmail());
        found.setAge(updatedUser.getAge());

        // 3. Risalviamo l'utente modificato
        ur.save(found);

        // 4. Log
        log.info("L'utente con id " + userId + " è stato cancellato correttamente!");
    }

    public void findByIdAndDelete(long id) {
        User found = this.findById(id);
        ur.delete(found);
        log.info("L'utente con id \" + userId + \" è stato cancellato correttamente");
    }

    public List<User> filterBySurname(String surname) {
        return ur.findBySurname(surname);
    }

    public List<User> filterByNameAndSurname(String name, String surname) {
        return ur.findByNameAndSurname(name, surname);
    }

    public List<User> filterByNameStartsWith(String partialName) {
        return ur.findByNameStartingWithIgnoreCase(partialName);
    }

    public List<User> filterByAge(int age) {
        return ur.findByAgeLessThan(age);
    }

    public List<User> filterSoloMaggiorenni() {
        return ur.filterBySoloMaggiorenni();
    }

}
