package manu_barone.Pizzeria.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pizza extends Prodotto {

    private List<Topping> toppings = new ArrayList<>() {{
        add(new Topping(0.50, "Pomodoro", 43.4));
        add(new Topping(2.00, "Mozzarella", 5435.543));
    }};

    public Pizza(String nome, List<Topping> toppings) {
        super(nome);
        this.toppings.addAll(toppings);
        setCalorie(this.toppings);
        setPrezzo(this.toppings);
    }

    @Override
    public String toString() {
        return "Pizza: " + super.toString();
    }

    public void stampaPizza() {
        System.out.println("Nome: " + getNome());
        System.out.println("Prezzo: " + getPrezzo());
        System.out.println("Calorie: " + getCalorie());
        System.out.println("Toppings:");
        for (Topping t : toppings) {
            System.out.println("    " + t.toString());
        }
        System.out.println("-----------------------------------------");
    }

}
