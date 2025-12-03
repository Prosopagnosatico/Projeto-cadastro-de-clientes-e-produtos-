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
    private String telefone;
    private TipoA tipo;
    private String identificador;
    private Gen genero;
    private String gen = "";
    private String rua;
    private String cidade;
    private est estado;
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

    public void armazenarGenero() {
        switch (genero) {
            case MASCULINO:
                gen = "Masculino";
                break;

            case FEMININO:
                gen = "Feminino";
                break;

            case OUTROS:
                gen = "Outros";
                break;
        }
    }

    public void armazenarEstado() {
        switch (estado) {
            case AC:
                estado2 = "AC";
            case AL:
                estado2 = "AL";
            case AP:
                estado2 = "AP";
            case AM:
                estado2 = "AM";
            case BA:
                estado2 = "BA";
            case CE:
                estado2 = "CE";
            case DF:
                estado2 = "DF";
            case ES:
                estado2 = "ES";
            case GO:
                estado2 = "GO";
            case MA:
                estado2 = "MA";
            case MT:
                estado2 = "MT";
            case MS:
                estado2 = "MS";
            case MG:
                estado2 = "MG";
            case PA:
                estado2 = "PA";
            case PB:
                estado2 = "PB";
            case PR:
                estado2 = "PR";
            case PE:
                estado2 = "PE";
            case PI:
                estado2 = "PI";
            case RJ:
                estado2 = "RJ";
            case RN:
                estado2 = "RN";
            case RS:
                estado2 = "RS";
            case RO:
                estado2 = "RO";
            case RR:
                estado2 = "RR";
            case SC:
                estado2 = "SC";
            case SP:
                estado2 = "SP";
            case SE:
                estado2 = "SE";
            case TO:
                estado2 = "TO";
        }
    }

    public boolean confirmarSenha() {
        return senha1.equals(senha2);
    }

}

