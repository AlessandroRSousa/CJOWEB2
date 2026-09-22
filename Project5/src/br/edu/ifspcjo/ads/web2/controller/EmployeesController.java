package br.edu.ifspcjo.ads.web2.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifspcjo.ads.web2.model.Employee;

public class EmployeesController {

    private List<Employee> employeesList;

    public EmployeesController(){
        employeesList = new ArrayList<>();
    }

    public boolean save(Employee employee){
        if(employee != null){
            employeesList.add(employee);
            return true;
        }
        return false;
    }

    public List<Employee> getEmployeesList(){
        return employeesList;
    }

}
