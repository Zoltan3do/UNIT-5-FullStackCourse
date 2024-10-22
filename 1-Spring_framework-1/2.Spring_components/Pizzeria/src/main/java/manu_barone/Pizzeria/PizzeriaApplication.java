package manu_barone.Pizzeria;

import manu_barone.Pizzeria.entities.Menu;
import manu_barone.Pizzeria.entities.Ordine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzeriaApplication {
    private static final Logger logger = LoggerFactory.getLogger(PizzeriaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PizzeriaApplication.class, args);
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("warn");
        logger.error("Errore");
    }
}
