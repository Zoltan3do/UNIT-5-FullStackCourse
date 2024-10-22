package manu_barone.Pizzeria;

import manu_barone.Pizzeria.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class MenuInitializr implements CommandLineRunner {

    @Autowired
    Menu menu;

    @Autowired
    List<Prodotto> prodotti;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzeriaApplication.class);

        Ordine o1 = new Ordine(prodotti, 2, (Tavolo) ctx.getBean("tavolo1"), (Double) ctx.getBean("costoCoperto"));

        System.out.println(o1);
    }
}
