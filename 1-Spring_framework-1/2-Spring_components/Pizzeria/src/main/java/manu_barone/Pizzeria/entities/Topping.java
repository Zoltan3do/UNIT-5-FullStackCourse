package manu_barone.Pizzeria.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Topping extends Prodotto {

    public Topping(double prezzo, String nome, double calorie) {
        super(prezzo, nome, calorie);
    }

    @Override
    public String toString() {
        return "Topping " + super.toString();
    }
}
