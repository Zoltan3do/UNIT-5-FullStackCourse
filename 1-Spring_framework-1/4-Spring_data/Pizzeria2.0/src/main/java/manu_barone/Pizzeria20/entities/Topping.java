package manu_barone.Pizzeria20.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "toppings")
@NoArgsConstructor
@Setter
@Getter
public class Topping extends Prodotto {


    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizze;

    public Topping(double prezzo, String nome, double calorie) {
        super(prezzo, nome, calorie);
    }

    @Override
    public String toString() {
        return "Topping " + super.toString();
    }


}
