package usuario;



public class Usuario{
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String senha1;
    private String senha2;
    private String telefone;
    private String tipo;
    private String identificador;
    private String gen;
    private String rua;
    private String cidade;
    private String estado2;
    private String cep;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha1() {
        return senha1;
    }
    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }
    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getGen() {
        return gen;
    }
    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado2() {
        return estado2;
    }
    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }


    public boolean confirmarSenha() {
        return senha1.equals(senha2);
    }

}

