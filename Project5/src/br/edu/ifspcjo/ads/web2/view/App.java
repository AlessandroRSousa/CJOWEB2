package br.edu.ifspcjo.ads.web2.view;

import javax.swing.JOptionPane;

import br.edu.ifspcjo.ads.web2.controller.EmployeesController;
import br.edu.ifspcjo.ads.web2.model.Employee;
import br.edu.ifspcjo.ads.web2.model.SalariedEmployee;

public class App {

    private static EmployeesController employeesController = new EmployeesController();

    private static int menu(){
        return Integer.parseInt(JOptionPane.showInputDialog(null, 
            "Escolha uma opção:" +
            "\n1- Cadastrar um empregado" +
            "\n2- Gerar Folha de Pagamento" +
            "\n3- Sair"
        ));
    }

    private static int submenu(){
        return Integer.parseInt(JOptionPane.showInputDialog(null,
            "Escolha um tipo de empregado:" +
            "\n1- Empregado Assalariado" +
            "\n2- Empregado Horista" +
            "\n3- Empregado Comissionado" +
            "\n4- Empregado Comissionado e Assalariado" +
            "\n5- Voltar"
        ));
    }
    public static void main(String[] args) throws Exception {
        int option, employeeType;
        do{
            option = menu();
            switch (option) {
                case 1:
                    employeeType = submenu();
                    switch (employeeType) {
                        case 1:
                            addSalariedEmployee();
                            break;
                    
                        default:
                            JOptionPane.showMessageDialog(null, 
                                "Tipo de empregado inválido. Tente novamente."
                            );
                            break;
                    }
                    break;

                case 2:
                    generatePayroll();
                    break;
            
                default:
                    break;
            }

        }while(option != 3);
    }

    private static void generatePayroll() {
        String message = "";
        for(Employee employee : employeesController.getEmployeesList()){
            message += employee + 
                "\nRendimentos: R$ " + employee.calculateIncome() +
                "\n-------------------------------------------\n";
        }
        JOptionPane.showConfirmDialog(null, message);
    }

    private static void addSalariedEmployee() {
        String name = JOptionPane.showInputDialog("Informe o nome:");
        String cpf = JOptionPane.showInputDialog("Informe o CPF:");
        double salary = Double.parseDouble(
            JOptionPane.showInputDialog("Informe o salário:"));
        if(employeesController.save(new SalariedEmployee(name, cpf, salary))){
            JOptionPane.showMessageDialog(null,
                "Empregado cadastrado com sucesso.");
        }else{
            JOptionPane.showMessageDialog(null,
                "Erro ao cadastrar o empregado.");
        }
    }
}
