package promocao;

import java.sql.Date;
import java.time.LocalDate;

public class Promocao {
    private double precoPromo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public double getPrecoPromo() {
        return precoPromo;
    }
    public void setPrecoPromo(double precoPromo) {
        this.precoPromo = precoPromo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
