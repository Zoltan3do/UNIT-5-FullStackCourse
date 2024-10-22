package manu_barone.Pizzeria;

import manu_barone.Pizzeria.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeansManager {

    @Bean(name="margherita")
    @Scope("prototype")
    public Pizza margherita() {
        return new Pizza("Margherita", new ArrayList<>());
    }

    @Bean
    @Scope("prototype")
    public Pizza hawaiana() {
        return new Pizza("Hawaiana", new ArrayList<>() {{
            add(new Topping(5, "Ananas", 423.4));
            add(new Topping(3, "Cocco", 4253.76));
        }});
    }

    @Bean
    @Scope("prototype")
    public Pizza salami() {
        return new Pizza("Salami", new ArrayList<>() {{
            add(new Topping(35, "Salame", 432.3));
        }});
    }

    @Bean
    @Scope("prototype")
    public Bevanda cocoCola() {
        return new Bevanda(2, "Coca-Cola", 55.5);
    }

    @Bean
    @Scope("prototype")
    public Bevanda peroni() {
        return new Bevanda(3, "Peroni", 223454.5);
    }

    @Bean
    @Scope("prototype")
    public Bevanda acqua() {
        return new Bevanda(5, "Acqua", 20.3);
    }

    @Bean
    public List<Prodotto> prodotti() {
        ArrayList<Prodotto> p = new ArrayList<>();
        p.add(margherita());
        p.add(peroni());
        p.add(acqua());
        p.add(hawaiana());
        return p;
    }


}
