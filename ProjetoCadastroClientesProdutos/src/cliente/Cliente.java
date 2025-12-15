package cliente;

import usuario.*;



public class Cliente extends Usuario {
    private String nivel;
    private String status;
    

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}


