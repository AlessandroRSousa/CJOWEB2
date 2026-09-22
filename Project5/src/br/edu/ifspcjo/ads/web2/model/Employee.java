package br.edu.ifspcjo.ads.web2.model;

public abstract class Employee {

    protected String name;
    protected String cpf;

    public Employee(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", cpf=" + cpf + "]";
    }
    
    public abstract double calculateIncome();
    
}
