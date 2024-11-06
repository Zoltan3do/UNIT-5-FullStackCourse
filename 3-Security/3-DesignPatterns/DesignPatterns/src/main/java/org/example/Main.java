package org.example;

import Adapter.Info;
import Adapter.InfoAdapter;
import Adapter.UserData;

import java.util.Calendar;
import java.util.Date;


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
    }


}