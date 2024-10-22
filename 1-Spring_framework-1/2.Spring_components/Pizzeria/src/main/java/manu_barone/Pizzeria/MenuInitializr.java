package manu_barone.Pizzeria;

import manu_barone.Pizzeria.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.logging.Logger;

@Component
public class MenuInitializr implements CommandLineRunner {

    @Autowired
    Menu menu;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzeriaApplication.class);

        Ordine o1 = new Ordine(new ArrayList<>() {{
            add((Pizza) ctx.getBean("margherita"));
            add((Bevanda) ctx.getBean("acqua"));
            add((Pizza) ctx.getBean("hawaiana"));
        }}, 2, new Tavolo(3));

        System.out.println(o1);
    }
}
