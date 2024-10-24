package manu_barone.Pizzeria20;

import manu_barone.Pizzeria20.entities.Topping;
import manu_barone.Pizzeria20.services.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {

    @Autowired
    private ToppingService tp;

    @Bean
    public Topping pomodoro(){
        return tp.findByName("pomodoro");
    }

    public Topping mozzarella(){
        return tp.findByName("mozzarella");
    }
}
