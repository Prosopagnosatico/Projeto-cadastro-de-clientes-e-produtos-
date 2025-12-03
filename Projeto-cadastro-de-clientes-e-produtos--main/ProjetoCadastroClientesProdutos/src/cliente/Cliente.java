package cliente;

import usuario.*;

enum Nivel{
    NORMAL, ESPECIAL, VIP;
}

public class Cliente extends Usuario {
    private Nivel nivel;
    private String nivel2;
    private String observacao;
    private boolean statusAtivo;
    private String status2;

    public Nivel getNivel() {
        return nivel;
    }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getNivel2() {
        return nivel2;
    }
    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isStatusAtivo() {
        return statusAtivo;
    }
    public void setStatusAtivo(boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public String getStatus2() {
        return status2;
    }
    public void setStatus2(String status2) {
        status2 = status2;
    }

    public void armazenarStatus() {
        if (statusAtivo == true) {
            status2 = "Ativo";
        } else if(statusAtivo == false){
            status2 = "Inativo";
        }
    }

    private void armazenarNivel() {
        switch (nivel){
            case NORMAL ->
                nivel2 = "Normal";
            case ESPECIAL ->
                nivel2 = "Especial";
            case VIP ->
                nivel2 = "VIP";
        }
    }

    public void mudarStatus() {
        statusAtivo = !statusAtivo;
    }
}


