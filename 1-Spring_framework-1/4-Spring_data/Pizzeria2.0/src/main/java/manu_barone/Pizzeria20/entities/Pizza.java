package manu_barone.Pizzeria20.entities;

import jakarta.persistence.*;
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
@Entity
@Table(name = "pizze")
public class Pizza extends Prodotto {

    @ManyToMany
    @JoinTable(name = "toppings_pizze",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String nome) {
        super(nome);
    }

    public Pizza(String nome, List<Topping> toppings) {
        super(nome);
        this.toppings.add(new Topping(0.50, "Pomodoro", 43.4));
        this.toppings.add(new Topping(2.00, "Mozzarella", 5435.543));
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

    public void addProdotto(Topping t){
        this.toppings.add(t);
        setCalorie(this.toppings);
        setPrezzo(this.toppings);
    }

}
