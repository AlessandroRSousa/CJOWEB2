package br.edu.ifspcjo.ads.web2.checkout.model;

public class EpsonPrinter implements Printer {

    @Override
    public void print(Printable printable) {
       System.out.println("********************");
       System.out.println(printable.getPageHeader());
       System.out.println("********************");
       System.out.println(printable.getPageBody());
       System.out.println("********************");
       System.out.println("===Epson===");
       System.out.println("********************");

    }





}
