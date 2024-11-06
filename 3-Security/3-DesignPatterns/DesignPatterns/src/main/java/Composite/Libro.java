package Composite;

import java.util.List;

public class Libro implements Interfaccio{

    private List<Interfaccio> sezioni;

    public Libro(List<Interfaccio> sezioni) {
        this.sezioni = sezioni;
    }

    public List<Interfaccio> getSezioni() {
        return sezioni;
    }

    public void setSezioni(List<Interfaccio> sezioni) {
        this.sezioni = sezioni;
    }

    @Override
    public String show() {
        return "";
    }

    @Override
    public int count() {
        int c = 0 ;
        for(Interfaccio i:this.sezioni){
            if(i instanceof Sezione){
                c += i.count();
            }
        }
        return c;
    }
}
