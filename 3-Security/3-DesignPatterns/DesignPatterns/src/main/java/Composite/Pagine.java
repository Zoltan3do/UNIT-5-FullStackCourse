package Composite;

import java.util.List;

public class Pagine implements Interfaccio {

    private String contenuto;
    private int numero;

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getNumero() {
        return 1;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String show() {
        return "";
    }

    @Override
    public int count() {
        return this.getNumero();
    }
}
