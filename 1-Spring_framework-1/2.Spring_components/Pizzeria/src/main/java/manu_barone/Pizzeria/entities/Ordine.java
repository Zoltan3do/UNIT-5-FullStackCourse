package manu_barone.Pizzeria.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
@PropertySource("application.properties")
public class Ordine {

    private List<Prodotto> elementiMenu = new ArrayList<>();
    private static int numeroOrdine = 1;
    private StatoOrdine stato = StatoOrdine.IN_CORSO;
    private int numeroCoperti;
    private LocalDate oraAcquisizione = LocalDate.now();
    private double importoTotale = 0;
    private Tavolo tavolo;

    @Value("${tavolo.costoCoperto}")
    private double prezzoCoperto;

    public Ordine(List<Prodotto> elementiMenu, int numeroCoperti, Tavolo tavolo) {
        this.elementiMenu = elementiMenu;
        numeroOrdine++;
        this.numeroCoperti = numeroCoperti;

        setImportoTotale(elementiMenu);
        this.tavolo = tavolo;
    }

    public void setImportoTotale(List<Prodotto> pr) {
        for (Prodotto p : pr) {
            this.importoTotale += p.getPrezzo();
        }
        for (int i = 0; i < numeroCoperti; i++) {
            this.importoTotale += prezzoCoperto;
        }
    }

    public void setElementiMenu(List<Prodotto> elementiMenu) {
        this.elementiMenu = elementiMenu;
    }

    public void setNumeroOrdine(int numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public void setNumeroCoperti(int numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }


}
