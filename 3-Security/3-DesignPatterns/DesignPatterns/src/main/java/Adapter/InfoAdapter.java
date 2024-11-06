package Adapter;

import java.time.LocalDate;

public class InfoAdapter implements DataSource {

    private Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return this.info.getNome()+" "+this.info.getCognome();
    }

    @Override
    public int getEta() {
        return LocalDate.now().getYear() - this.info.getDataDiNascita().getYear() - 1900;
    }


}
