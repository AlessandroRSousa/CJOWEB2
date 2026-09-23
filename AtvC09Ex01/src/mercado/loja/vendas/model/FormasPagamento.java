package mercado.loja.vendas.model;

public abstract class FormasPagamento {

    private double valorBruto;
    private String codigoTransacao;
    
    public FormasPagamento(double valorBruto, String codigoTransacao) {
        this.valorBruto = valorBruto;
        this.codigoTransacao = codigoTransacao;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    
    

    

}
