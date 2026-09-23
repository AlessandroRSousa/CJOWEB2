package br.edu.ifspcjo.ads.web2.checkout.model;

public class Checkout  {

    private Printer printer;
    private Operator operator;

    public Checkout(Printer printer, Operator operator) {
        this.printer = printer;
        this.operator = operator;
    }

    public void closeBuy(Buy buy, Card card){
        boolean authorized = operator.authorize(buy, card);
        if(authorized){
            printer.print(buy);
        } else {
            System.out.println("Pagamento negado!");
        }
    }
    
}
