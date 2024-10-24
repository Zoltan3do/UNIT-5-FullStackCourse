package manu_barone.Pizzeria20.runners;

import lombok.extern.slf4j.Slf4j;
import manu_barone.Pizzeria20.entities.Topping;
import manu_barone.Pizzeria20.repositories.ToppingRepo;
import manu_barone.Pizzeria20.services.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class ToppingRunner implements CommandLineRunner {


    @Autowired
    private ToppingService ts;

    @Override
    public void run(String... args) throws Exception {
        ts.saveTopping(new Topping(5.4, "Pomodoro", 432.4));
        ts.saveTopping(new Topping(3.4, "Mozzarella", 432.4));

    }
}
