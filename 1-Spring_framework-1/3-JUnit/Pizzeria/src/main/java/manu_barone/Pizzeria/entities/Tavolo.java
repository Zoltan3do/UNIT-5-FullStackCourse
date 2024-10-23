package manu_barone.Pizzeria.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tavolo {

    private static int numero = 1;
    private int numeroCopertiMassimo;
    private StatoTavolo stato = StatoTavolo.LIBERO;

    public Tavolo(int numeroCopertiMassimo) {
        numero++;
        this.numeroCopertiMassimo = numeroCopertiMassimo;
    }
}
