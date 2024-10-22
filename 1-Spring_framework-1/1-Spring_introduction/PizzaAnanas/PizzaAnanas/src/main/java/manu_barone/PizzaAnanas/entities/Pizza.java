package manu_barone.PizzaAnanas.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pizza extends Prodotto {
    private final static Map<String, Double> VALID_TOPPINGS = new HashMap<>() {{
        put("Pomodoro", 5.5);
        put("Wurstel", 3.4);
        put("Mozzarella", 2.2);
        put("Doppio prosciutto", 5.5);
        put("Ananas", 77.0);
        put("Salame", 435346543.6);
    }};

    private Map<String, Double> toppings = new HashMap<>();

    public Pizza(double prezzo, String nome, Map<String, Double> toppings) {
        super(prezzo, nome);
        toppings.put("Pomodoro", VALID_TOPPINGS.get("Pomodoro"));
        toppings.put("Mozzarella", VALID_TOPPINGS.get("Mozzarella"));
        for (String t : toppings.keySet()) {
            if (VALID_TOPPINGS.containsKey(t)) {
                this.toppings.put(t, toppings.get(t));
            } else {
                System.out.println("Questo topping non è disponibile");
            }
        }
        setCalorie(this.toppings);
    }

    public void stampaPizza(){
        System.out.println("Nome: " + getNome());
        System.out.println("Prezzo: " + getPrezzo());
        System.out.println("Calorie: " + getCalorie());
        System.out.println("Toppings:");
        for(String t: toppings.keySet()){
            System.out.println("    "+t);
        }
        System.out.println("-----------------------------------------");
    }

}
