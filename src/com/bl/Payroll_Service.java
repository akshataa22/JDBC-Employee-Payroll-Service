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

        System.out.println("Payroll Data before Update:");
        EmployeePayrollData.displayEmployeePayrollData(employeePayrolls);

        EmployeePayrollData.updateBasicPay(c, "Terisa", 3000000);

        List<EmployeePayrollData> updatedEmployeePayrolls = EmployeePayrollData.retrieveEmployeePayrollData(c);

        System.out.println("Payroll Data after Update:");
        EmployeePayrollData.displayEmployeePayrollData(updatedEmployeePayrolls);

        //close the connection
        c.close();
    }
}
