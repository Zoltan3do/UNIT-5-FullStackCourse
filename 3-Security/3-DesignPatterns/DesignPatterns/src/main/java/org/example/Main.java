package org.example;

import Adapter.Info;
import Adapter.InfoAdapter;
import Adapter.UserData;
import Composite.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2000, Calendar.MAY, 1);
        Info info = Info.builder()
                .nome("Manuel")
                .cognome("Barone")
                .dataDiNascita(c.getTime())
                .build();
        UserData ud = new UserData();
        ud.getData(new InfoAdapter(info));
        System.out.println(ud.getNomeCompleto() + " " + ud.getEta());

        // -----------------------------------------------------------

        Pagine p1 = new Pagine();
        Pagine p2 = new Pagine();
        Pagine p3 = new Pagine();
        Pagine p4 = new Pagine();
        Pagine p5 = new Pagine();
        List<Interfaccio> pagine = new ArrayList<>() {{
            add(p1);
            add(p2);
            add(p3);
            add(p4);
            add(p5);
        }};
        Sottosezione s1 = new Sottosezione(pagine);
        List<Interfaccio> sottosezioni = new ArrayList<>(){{add(s1);}};
        Sezione s2 = new Sezione(sottosezioni);
        List<Interfaccio> sezioni = new ArrayList<>(){{add(s2);}};
        Libro l = new Libro(sezioni);
        System.out.println(l.count());
    }


}