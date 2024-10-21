package manu_barone.PizzaAnanas;

import manu_barone.PizzaAnanas.entities.Bevande;
import manu_barone.PizzaAnanas.entities.Menu;
import manu_barone.PizzaAnanas.entities.Pizza;
import manu_barone.PizzaAnanas.entities.Prodotto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzaAnanasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaAnanasApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansManager.class);
		Menu menu = (Menu) context.getBean("menu");
		menu.getMenu();
	}

}
