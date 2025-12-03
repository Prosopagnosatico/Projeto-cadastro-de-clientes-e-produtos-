package produto;

enum TamanhoV{
    PP, P, M, G, GG;
};

public class Produto {
    private int idProd;
    private String nome;
    private double precoUnitario;
    private double precoLote;
    private double custoProducao;
    private String categoria;
    private TamanhoV tamanho;
    private String tamanho2;
    private String fornecedor;
    private String descricao;

    public int getIdProd() {
        return idProd;
    }
    public void setIdProd(int id) {
        this.idProd = idProd;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getPrecoLote() {
        return precoLote;
    }
    public void setPrecoLote(double precoLote) {
        this.precoLote = precoLote;
    }

    public double getCustoProducao() {
        return custoProducao;
    }
    public void setCustoProducao(double custoProducao) {
        this.custoProducao = custoProducao;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public TamanhoV getTamanho() {
        return tamanho;
    }
    public void setTamanho(TamanhoV tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho2() {
        return tamanho2;
    }
    public void setTamanho2(String tamanho2) {
        this.tamanho2 = tamanho2;
    }

    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void armazenarTamanho(){
        switch (tamanho){
            case PP ->
                tamanho2 = "PP";
            case P ->
                tamanho2 = "P";
            case M ->
                tamanho2 = "M";
            case G ->
                tamanho2 = "G";
            case GG ->
                tamanho2 = "GG";
        };
    };
}
