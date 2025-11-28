package usuario;

enum TipoA{
    CPF, CNPJ;
}

enum Gen{
    FEMININO, MASCULINO, OUTROS;
}
enum est{
    AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO;
}

public class Usuario{
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String senha1;
    private String senha2;
    private int telefone;
    private TipoA tipo;
    private String identificador;
    private Gen genero;
    private String gen = "";
    private String rua;
    private String cidade;
    private est estado;
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

    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public TipoA getTipo() {
        return tipo;
    }
    public void setTipo(TipoA tipo) {
        this.tipo = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Gen getGenero() {
        return genero;
    }
    public void setGenero(Gen genero) {
        this.genero = genero;


    }

    public String getGen() {
        return gen;
    }
    public void setGen(String gen) {
        this.gen = gen;}

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

    public est getEstado() {
        return estado;
    }
    public void setEstado(est estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public void armazenarGenero() {
        if (genero == Gen.MASCULINO) {
            gen = "Masculino";
        } else if (genero == Gen.FEMININO) {
            gen = "Feminino";
        } else if (genero == Gen.OUTROS) {
            gen = "Outros";
        }
    }

    public boolean confirmarSenha() {
        return senha1.equals(senha2);
    }
}

