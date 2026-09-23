package mercado.loja.vendas.model;

public class Compra {

    private String produto;
    private int quantidade;
    private double precoProduto;

    //construtor
    public Compra(String produto, int quantidade, double precoProduto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoProduto = precoProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    
    

}
