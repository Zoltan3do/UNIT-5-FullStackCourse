package manu_barone.Pizzeria20.runners;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import manu_barone.Pizzeria20.entities.Pizza;
import manu_barone.Pizzeria20.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@Slf4j
@Order(2)
public class PizzaRunner implements CommandLineRunner {
    @Autowired
    private PizzaService ps;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);

        List<Pizza> pizze =  new ArrayList<>();

        for (int i = 0; i < 10; i++){
            Pizza p = new Pizza(faker.lordOfTheRings().character());
            pizze.add(p);
        }

        ps.saveManyPizzas(pizze);

    }
}
