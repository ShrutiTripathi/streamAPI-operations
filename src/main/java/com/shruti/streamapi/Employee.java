package com.shruti.streamapi;

import java.util.List;

public class Employee {
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Employee(String firstName, String lastName, Double salary, List<String> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.projects = projects;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getProjects() {
        return projects;
    }


    private String firstName;
    private String lastName;
    private Double salary;
    private List<String> projects;
}
