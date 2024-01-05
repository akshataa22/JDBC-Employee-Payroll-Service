package com.bl;

import java.sql.*;
import java.util.List;

public class Payroll_Service {
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to Payroll Service JDBC connection Program.");

        //create a connection
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service","root","Aggre#22gate");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded.");
        } catch (ClassNotFoundException e){
            throw new IllegalStateException("Driver not found!", e);
        }

        System.out.println("Connection established!");

        List<EmployeePayrollData> employeePayrolls = EmployeePayrollData.retrieveEmployeePayrollData(c);

        System.out.println("Employee Payroll Data:");
        for (EmployeePayrollData employeePayroll : employeePayrolls) {
            System.out.println("Employee ID: " + employeePayroll.getId());
            System.out.println("Employee Name: " + employeePayroll.getName());
            System.out.println("Employee Phone Number: " + employeePayroll.getPhone_number());
            System.out.println("Employee Address: " + employeePayroll.getAddress());
            System.out.println("Employee Department: " + employeePayroll.getDepartment());
            System.out.println("Employee Gender: " + employeePayroll.getGender());
            System.out.println("Employee's Basic Pay: " + employeePayroll.getBasic_pay());
            System.out.println("Employee Deductions: " + employeePayroll.getDeductions());
            System.out.println("Employee Taxable Pay: " + employeePayroll.getTaxable_pay());
            System.out.println("Employee Income Tax: " + employeePayroll.getIncome_tax());
            System.out.println("Employee Net Pay: " + employeePayroll.getNet_pay());
            System.out.println("Employee's Start Date: " + employeePayroll.getStart_date());
            System.out.println("------------------------------");
        }

        //close the connection
        c.close();
    }
}
