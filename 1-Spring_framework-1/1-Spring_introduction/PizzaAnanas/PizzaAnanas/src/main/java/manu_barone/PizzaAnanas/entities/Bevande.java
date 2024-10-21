package manu_barone.PizzaAnanas.entities;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
public class Bevande extends Prodotto{

    public Bevande(double prezzo, String nome, double calorie) {
        super(prezzo, nome, calorie);
    }

    @Override
    public String toString() {
        return super.toString() + "\n--------------------------------------------------";
    }
}
