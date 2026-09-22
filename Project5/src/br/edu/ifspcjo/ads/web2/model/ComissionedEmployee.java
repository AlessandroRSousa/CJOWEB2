package br.edu.ifspcjo.ads.web2.model;

public class ComissionedEmployee extends Employee {

    protected double salesValue;
    protected double comissionPercentege;

    public ComissionedEmployee(String name, String cpf, double salesValue, double comissionPercentege) {
        super(name, cpf);
        this.salesValue = salesValue;
        this.comissionPercentege = comissionPercentege;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public double getComissionPercentege() {
        return comissionPercentege;
    }

    public void setComissionPercentege(double comissionPercentege) {
        this.comissionPercentege = comissionPercentege;
    }

    @Override
    public String toString() {
        return "ComissionedEmployee [name=" + name + ", salesValue=" + salesValue + ", cpf=" + cpf
                + ", comissionPercentege=" + comissionPercentege + "]";
    }

    @Override
    public double calculateIncome() {
        return salesValue * comissionPercentege / 100;
    }
    
}
