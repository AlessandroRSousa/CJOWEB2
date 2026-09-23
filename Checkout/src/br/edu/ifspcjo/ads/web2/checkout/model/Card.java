package br.edu.ifspcjo.ads.web2.checkout.model;

public class Card {

    private String titularName;
    private String cardNumber;
    
    public Card(String titularName, String cardNumber) {
        this.titularName = titularName;
        this.cardNumber = cardNumber;
    }

    public String getTitularName() {
        return titularName;
    }

    public void setTitularName(String titularName) {
        this.titularName = titularName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    
}
