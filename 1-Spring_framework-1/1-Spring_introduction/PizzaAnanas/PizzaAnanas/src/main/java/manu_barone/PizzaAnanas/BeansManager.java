package manu_barone.PizzaAnanas;

import manu_barone.PizzaAnanas.entities.Bevande;
import manu_barone.PizzaAnanas.entities.Menu;
import manu_barone.PizzaAnanas.entities.Pizza;
import manu_barone.PizzaAnanas.entities.Prodotto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Configuration
public class BeansManager {

    @Bean
    @Scope("prototype")
    public Pizza margherita() {
        return new Pizza(2.50, "Margherita", new HashMap<>());
    }

    @Bean
    @Scope("prototype")
    public Pizza hawaiana() {
        return new Pizza(5.00, "Hawaiana", new HashMap<>(){{
            put("Ananas", 3245.3);
            put("Salame", 35.3);
        }});
    }

    @Bean
    @Scope("prototype")
    public Pizza salami() {
        return new Pizza(5.00, "Salami", new HashMap<>(){{
            put("Salame", 354.3);
        }});
    }

    @Bean
    @Scope("prototype")
    public Bevande cocoCola(){
        return new Bevande(2, "Coca-Cola", 55.5);
    }

    @Bean
    @Scope("prototype")
    public Bevande peroni(){
        return new Bevande(3, "Peroni", 223454.5);
    }

    @Bean
    @Scope("prototype")
    public Bevande acqua(){
        return new Bevande(5, "Acqua", 20.3);
    }

    @Bean
    @Scope("prototype")
    public Menu menu() {
        List<Prodotto> lista = new ArrayList<>() {{
            add(margherita());
            add(acqua());
            add(peroni());
            add(acqua());
            add(hawaiana());
            add(salami());
        }};
        return new Menu(lista);
    }
}
