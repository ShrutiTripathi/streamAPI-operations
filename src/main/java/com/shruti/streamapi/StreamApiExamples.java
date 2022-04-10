package com.shruti.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExamples {
    public static void main(String[] args) {
        List<Employee> employees =  Arrays.asList(
                new Employee("Shruti", "Tripathi", 50000.0, List.of("Project1", "Project2")),
                new Employee("Nikhil", "Gupta", 80000.0, List.of("Project1", "Project3")),
                new Employee("Shivam", "Kumar", 90000.0, List.of("Project3", "Project4"))
        );
        System.out.println(Stream.of(employees));// converting collection object to stream object
        System.out.println(employees.stream());// converting collection object to stream object

        //foreach
        employees.stream().forEach(emp -> System.out.println(emp));

        //map
        List<Employee> empWIthIncreasedSal= employees.stream().map(emp -> new Employee(
                emp.getFirstName(), emp.getLastName(), emp.getSalary()*1.10, emp.getProjects()
        )).collect(Collectors.toList());
        System.out.println(empWIthIncreasedSal);

        //filter
        List<Employee> empWithFilter = employees.stream().filter(emp->emp.getSalary()>50000.0)
                .map(emp -> new Employee(
                        emp.getFirstName(), emp.getLastName(), emp.getSalary()*1.10, emp.getProjects()
                )).collect(Collectors.toList());
        System.out.println(empWithFilter);

        //FindFirst
        Employee empWithFindFirst = employees.stream().filter(emp->emp.getSalary()>50000.0)
                .map(emp -> new Employee(
                        emp.getFirstName(), emp.getLastName(), emp.getSalary()*1.10, emp.getProjects()
                )).findFirst().orElse(null);
        System.out.println(empWithFindFirst);

        //flatmap
        String projects= employees.stream().map(emp->emp.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));
        System.out.println(projects);

        //short circuit operations

        List<Employee> employees1 = employees.stream().skip(1).limit(1).collect(Collectors.toList());
        System.out.println(employees1);

        //Finite data from infinite data
        Stream.generate(Math::random).limit(1).forEach(value-> System.out.println(value));

        //sorting
        List<Employee> employees2= employees.stream().sorted((o1,o2)-> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList());
        System.out.println(employees2);

        //min or max
        Employee maxEmp = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow();
        System.out.println(maxEmp);

        //reduce
        Double totalSal = employees.stream().map(emp -> emp.getSalary()).reduce(0.0,Double::sum);
        System.out.println(totalSal);

    }

}
