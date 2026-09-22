package br.edu.ifspcjo.ads.web2.model;

public class SalariedEmployee extends Employee {

    private double salary;

    public SalariedEmployee(String name, String cpf, double salary) {
        super(name, cpf);
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
        return "SalariedEmployee [name=" + name + ", salary=" + salary + ", cpf=" + cpf + "]";
    }

    @Override
    public double calculateIncome() {
        return salary;
    }

}
