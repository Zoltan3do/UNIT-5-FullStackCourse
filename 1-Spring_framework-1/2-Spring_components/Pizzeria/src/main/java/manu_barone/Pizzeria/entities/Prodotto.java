package manu_barone.Pizzeria.entities;

import lombok.*;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public abstract class Prodotto {

    @Setter(AccessLevel.NONE)
    private double prezzo;

    private String nome;

    @Setter(AccessLevel.NONE)
    private double calorie;

    public Prodotto(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(List<Topping> toppings) {
        double cal = 0;
        for (Topping s : toppings) {
            cal += s.getPrezzo();
        }
        this.prezzo = cal;
    }


    public void setCalorie(List<Topping> toppings) {
        double cal = 0;
        for (Topping s : toppings) {
            cal += s.getCalorie();
        }
        this.calorie = cal;
    }


}
