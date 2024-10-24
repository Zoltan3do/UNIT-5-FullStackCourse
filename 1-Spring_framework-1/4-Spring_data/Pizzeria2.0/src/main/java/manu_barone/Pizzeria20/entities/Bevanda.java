package manu_barone.Pizzeria20.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="bevande")
public class Bevanda extends Prodotto {


    public Bevanda(){}
    public Bevanda(double prezzo, String nome, double calorie) {
        super(prezzo, nome, calorie);
    }

    @Override
    public String toString() {
        return "Topping " + super.toString();
    }
}
