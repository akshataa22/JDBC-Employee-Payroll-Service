package com.bl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class EmployeePayrollData {
    private int id;
    private String name;
    private String phone_number;
    private String address;
    private String department;
    private String gender;
    private int basic_pay;
    private int deductions;
    private int taxable_pay;
    private int income_tax;
    private int net_pay;
    private Date start_date;

    public static List<EmployeePayrollData> retrieveEmployeePayrollData(Connection connection) throws SQLException {
        List<EmployeePayrollData> employeePayrollsList = new ArrayList<>();

        // Use a SELECT query to retrieve data from the database
        String sqlQuery = "SELECT * FROM employee_payroll";
        try (Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            while (resultSet.next()) {
                EmployeePayrollData data = new EmployeePayrollData();
                data.setId(resultSet.getInt("id"));
                data.setName(resultSet.getString("name"));
                data.setPhone_number(resultSet.getString("phone_number"));
                data.setAddress(resultSet.getString("address"));
                data.setDepartment(resultSet.getString("department"));
                data.setGender(resultSet.getString("gender"));
                data.setBasic_pay(resultSet.getInt("basic_pay"));
                data.setDeductions(resultSet.getInt("deductions"));
                data.setTaxable_pay(resultSet.getInt("taxable_pay"));
                data.setIncome_tax(resultSet.getInt("income_tax"));
                data.setNet_pay(resultSet.getInt("net_pay"));
                data.setStart_date(resultSet.getDate("start_date"));

                employeePayrollsList.add(data);
            }
        }
        return employeePayrollsList;
    }

    public static void updateBasicPay(Connection connection, String name, int basic_pay) throws SQLException {
        String updateQuery = "UPDATE employee_payroll SET basic_pay = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, basic_pay);
            preparedStatement.setString(2, name);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Base pay updated successfully for " + name);
                System.out.println();
            } else {
                System.out.println("Failed to update base pay for " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List displayEmployeePayrollData(List<EmployeePayrollData> employeePayrolls) {
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
        return employeePayrolls;
    }

    public String getDepartment() {
        return department;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public int getNet_pay() {
        return net_pay;
    }

    public void setNet_pay(int net_pay) {
        this.net_pay = net_pay;
    }

    public int getIncome_tax() {
        return income_tax;
    }

    public void setIncome_tax(int income_tax) {
        this.income_tax = income_tax;
    }

    public int getTaxable_pay() {
        return taxable_pay;
    }

    public void setTaxable_pay(int taxable_pay) {
        this.taxable_pay = taxable_pay;
    }

    public int getDeductions() {
        return deductions;
    }

    public void setDeductions(int deductions) {
        this.deductions = deductions;
    }

    public int getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(int basic_pay) {
        this.basic_pay = basic_pay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}