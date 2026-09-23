package br.edu.ifspcjo.ads.web2.checkout.model;

public class Buy implements Authorizable, Printable{

    private String clientName;
    private double total;
    private String productName;
    
    public Buy(String clientName, double total, String productName) {
        this.clientName = clientName;
        this.total = total;
        this.productName = productName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override 
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String getPageBody() {
        return productName + " = R$ " + total;
    }

    @Override
    public String getPageHeader() {
       
        return clientName;
    }
    
    


}
