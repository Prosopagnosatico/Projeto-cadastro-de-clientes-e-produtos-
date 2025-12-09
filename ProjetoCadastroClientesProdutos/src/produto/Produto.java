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
    private String tamanho;
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

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
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
}
