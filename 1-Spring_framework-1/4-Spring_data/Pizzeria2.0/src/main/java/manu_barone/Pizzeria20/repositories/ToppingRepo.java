package manu_barone.Pizzeria20.repositories;

import manu_barone.Pizzeria20.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToppingRepo extends JpaRepository<Topping, Long> {

     Optional<Topping> findFirstByNome(String name);
}
