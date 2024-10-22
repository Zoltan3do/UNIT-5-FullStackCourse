package manu_barone.Pizzeria.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Menu {

    private int costoCoperto;

    private List<Prodotto> prodotti;

    @Autowired
    public Menu(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public void getMenu() {
        for (Prodotto p : prodotti) {
            if (p instanceof Pizza) {
                ((Pizza) p).stampaPizza();
            } else if (p instanceof Bevanda) {
                System.out.println(p.toString());
            } else {
                System.out.println("Questo prodotto è illegale!!!!");
            }
        }
    }

}
