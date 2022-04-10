package com.shruti.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParallelStreamExample {

    public static void main(String[] args) {
        long start =0;
        long end =0;

        List<Employee> employees = new ArrayList<Employee>();
        for(int i=0; i<=10000; i++){
            employees.add(new Employee("employee"+i,"A",Double.valueOf(new Random().nextDouble()), List.of("Project1", "Project2")));
        }

        //calculate average salary of the employees

        //normal processing
        start=System.currentTimeMillis();
        employees.stream()
                .map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        end=System.currentTimeMillis();

        System.out.println("Normal stream execution time : "+(end-start));

        // parallel processing
        start=System.currentTimeMillis();
        employees.parallelStream()
                .map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();

        end=System.currentTimeMillis();

        System.out.println("Parallel stream execution time : "+(end-start));
    }
}
