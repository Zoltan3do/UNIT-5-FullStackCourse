package manu_barone.Pizzeria20.services;

import lombok.extern.slf4j.Slf4j;
import manu_barone.Pizzeria20.entities.Pizza;
import manu_barone.Pizzeria20.entities.Topping;
import manu_barone.Pizzeria20.repositories.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {

    @Autowired
    private PizzaRepo pr;

    @Autowired
    @Qualifier("mozzarella")
    private Topping mozzarella;

    @Autowired
    @Qualifier("pomodoro")
    private Topping pomodoro;

    public void savePizza(Pizza p){
        p.getToppings().add(pomodoro);
        p.getToppings().add(mozzarella);
        pr.save(p);
        log.info("La pizza " + p.getNome() +"é stata salvata correttamente!");
    }

    public void saveManyPizzas(List<Pizza> pizzas){
        for(Pizza p :pizzas){
            this.savePizza(p);
        }
    }
}
