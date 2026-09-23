package br.edu.ifspcjo.ads.web2.checkout.view;

import br.edu.ifspcjo.ads.web2.checkout.model.Buy;
import br.edu.ifspcjo.ads.web2.checkout.model.Card;
import br.edu.ifspcjo.ads.web2.checkout.model.Checkout;
import br.edu.ifspcjo.ads.web2.checkout.model.CieloOPerator;
import br.edu.ifspcjo.ads.web2.checkout.model.EpsonPrinter;
import br.edu.ifspcjo.ads.web2.checkout.model.Operator;
import br.edu.ifspcjo.ads.web2.checkout.model.Printer;

public class App {
    public static void main(String[] args) throws Exception {
    Operator operator = new RedeCArdOPerator();
    Printer printer = new XinglingPrinter();
    Card card = new Card("JULIANA SILVA",
        "1234.5678");
    Buy buy = new Buy("Juliana Silva",
    40 , "Hamburguer Especial");
    Checkout checkout = new Checkout(printer, operator);
    checkout.closeBuy(buy, card);

    }
}
