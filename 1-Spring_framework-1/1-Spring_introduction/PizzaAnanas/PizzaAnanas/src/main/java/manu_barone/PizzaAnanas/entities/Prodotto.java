package manu_barone.PizzaAnanas.entities;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public abstract class Prodotto {
    private double prezzo;
    private String nome;

    @Setter(AccessLevel.NONE)
    private double calorie;

    public Prodotto(double prezzo, String nome) {
        this.prezzo = prezzo;
        this.nome = nome;
    }

    public void setCalorie(Map<String, Double> toppings) {
        double cal = 0;
        for (String s : toppings.keySet()) {
            cal += toppings.get(s);
        }
        this.calorie = cal;
    }

}
