package cliente;

public class Cliente {

    private int id;
    private String nome;
    private String telefone;
    private String identificador;
    private String genero;
    private String email;
    private String status;
    private String nivel;

    public Cliente() {}

    public Cliente(int id, String nome, String telefone, String identificador, String genero,
                   String email, String status, String nivel) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.identificador = identificador;
        this.genero = genero;
        this.email = email;
        this.status = status;
        this.nivel = nivel;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getIdentificador() { return identificador; }
    public String getGenero() { return genero; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }
    public String getNivel() { return nivel; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setEmail(String email) { this.email = email; }
    public void setStatus(String status) { this.status = status; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}
