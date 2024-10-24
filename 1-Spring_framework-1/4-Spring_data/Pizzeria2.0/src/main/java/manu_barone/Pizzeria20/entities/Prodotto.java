package manu_barone.Pizzeria20.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String nome;

    @Setter(AccessLevel.NONE)
    private double calorie;

    private double prezzo;

    public Prodotto(double prezzo,String nome, double calorie) {
        this.nome = nome;
        this.calorie = calorie;
        this.prezzo = prezzo;
    }

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
