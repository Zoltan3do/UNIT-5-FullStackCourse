package Composite;

import java.util.List;

public class Sottosezione implements Interfaccio {

    private List<Interfaccio> pagine;

    public Sottosezione(List<Interfaccio> pagine) {
        this.pagine = pagine;
    }

    public List<Interfaccio> getPagine() {
        return pagine;
    }

    public void setPagine(List<Interfaccio> pagine) {
        this.pagine = pagine;
    }

    @Override
    public String show() {
        return "";
    }

    @Override
    public int count() {
        int c = 0;
        for(Interfaccio i :this.pagine){
            if(i instanceof Pagine){
               c += i.count();
            }
        }
        return 0;
    }
}
