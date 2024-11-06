package Composite;

import java.util.List;

public class Sezione implements Interfaccio {

    private List<Interfaccio> sottosezioni;

    public Sezione(List<Interfaccio> sottosezioni) {
        this.sottosezioni = sottosezioni;
    }

    public List<Interfaccio> getSottosezioni() {
        return sottosezioni;
    }

    public void setSottosezioni(List<Interfaccio> sottosezioni) {
        this.sottosezioni = sottosezioni;
    }

    @Override
    public String show() {
        return "";
    }

    @Override
    public int count() {
        int c = 0;
        for (Interfaccio i : this.sottosezioni) {
            if (i instanceof Sottosezione) {
                c += i.count();
            }
        }
        return c;
    }
}
