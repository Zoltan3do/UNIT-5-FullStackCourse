package manu_barone.Pizzeria20.services;

import lombok.extern.slf4j.Slf4j;
import manu_barone.Pizzeria20.entities.Pizza;
import manu_barone.Pizzeria20.entities.Topping;
import manu_barone.Pizzeria20.repositories.PizzaRepo;
import manu_barone.Pizzeria20.repositories.ToppingRepo;
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
    private ToppingService tr;

    public void savePizzaStandard(Pizza p){
        p.addProdotto(tr.findByName("Pomodoro"));
        p.addProdotto(tr.findByName("Mozzarella"));
        pr.save(p);
        log.info("La pizza " + p.getNome() +"é stata salvata correttamente!");
    }

    public void savePizzaCustom(Pizza p, List<String> toppings){
        p.addProdotto(tr.findByName("Pomodoro"));
        p.addProdotto(tr.findByName("Mozzarella"));
        for(String t: toppings){
            p.addProdotto(tr.findByName(t));
        }
        pr.save(p);
        log.info("La pizza " + p.getNome() +"é stata salvata correttamente!");
    }

    public void saveManyPizzas(List<Pizza> pizzas){
        for(Pizza p :pizzas){
            this.savePizzaStandard(p);
        }
    }
}
