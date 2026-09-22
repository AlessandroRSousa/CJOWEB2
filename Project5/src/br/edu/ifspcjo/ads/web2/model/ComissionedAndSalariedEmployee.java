package br.edu.ifspcjo.ads.web2.model;

public class ComissionedAndSalariedEmployee extends ComissionedEmployee {

    private double salary;

    public ComissionedAndSalariedEmployee(String name, String cpf, double salesValue, double comissionPercentege,
            double salary) {
        super(name, cpf, salesValue, comissionPercentege);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ComissionedAndSalariedEmployee [name=" + name + ", salesValue=" + salesValue + ", cpf=" + cpf
                + ", salary=" + salary + ", comissionPercentege=" + comissionPercentege + "]";
    }

    @Override
    public double calculateIncome() {
        return super.calculateIncome() + salary;
    }

}
