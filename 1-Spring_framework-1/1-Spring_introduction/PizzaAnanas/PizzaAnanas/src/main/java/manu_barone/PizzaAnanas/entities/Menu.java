package manu_barone.PizzaAnanas.entities;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Menu {
    private List<Prodotto> listaProdotti;

    public void getMenu(){
        for(Prodotto p : listaProdotti){
            if(p instanceof Pizza){
                ((Pizza) p).stampaPizza();
            } else if (p instanceof  Bevande) {
                System.out.println(p.toString());
            }else{
                System.out.println("Questo prodotto è illegale!!!!");
            }
        }
    }
}
