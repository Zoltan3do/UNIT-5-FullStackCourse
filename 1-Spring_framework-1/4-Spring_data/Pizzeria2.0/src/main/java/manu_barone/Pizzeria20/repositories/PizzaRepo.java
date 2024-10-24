package manu_barone.Pizzeria20.repositories;

import manu_barone.Pizzeria20.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Long> {

}
