package dev.javafeatures.j8.functional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTrials {

    private static final List<Employee> listEmployees = List.of(
            new Employee("Abc def", 20_000),
            new Employee("Def ghi", 35_000),
            new Employee("Ghi lmn", 47_000),
            new Employee("Ijk lmn", 59_000),
            new Employee("Lmn Opq", 72_000),
            new Employee("Opq rst", 65_000),
            new Employee("Rst xyz", 95_000)
    );

    /*
        Stateless operations in stream
     */
    List<Employee> updateSalary(List<Employee> employees, long salaryLimit, float percentage)   {
        return employees.stream()
                        .filter(emp -> emp.getSalary() < salaryLimit)
                        .map(emp -> new Employee(emp.getName(), emp.getSalary()*percentage))
                        .collect(Collectors.toList());
    }

    /*
        Stateless operations in stream (verbose)
     */
    List<Employee> updateSalaryVerbose(List<Employee> employees, long salaryLimit, float percentage)   {
        return employees.stream()
                .filter(emp -> {
                    System.out.println("Filtering Employee:" + emp.getName());
                    return emp.getSalary() < salaryLimit;
                })
                .map(emp -> {
                    System.out.println("Updating salary for:" + emp.getName());
                    return new Employee(emp.getName(), emp.getSalary()*percentage);
                })
                .collect(Collectors.toList());
    }

    /*
        Stateful operations in stream (verbose)
     */
    List<Employee> updateSalaryStatefulVerbose(List<Employee> employees, long salaryLimit, float percentage)   {
        return employees.stream()
                .filter(emp -> {
                    System.out.println("Filtering Employee:" + emp.getName());
                    return emp.getSalary() < salaryLimit;
                })
                .sorted()
                .map(emp -> {
                    System.out.println("Updating salary for:" + emp.getName());
                    return new Employee(emp.getName(), emp.getSalary()*percentage);
                })
                .collect(Collectors.toList());
    }

    /*
       Removes duplicate characters from the given string.
     */
    String removeDuplicatesReturnSameOrder(String inputString)  {
        return Arrays.stream(inputString.split(""))
                     .distinct()
                     .collect(Collectors.joining());
    }

    /*
        Returns a list of words with
     */
    List<String> getWordsWithMaxNumberOfVowels(String inputString)  {
        return Arrays.stream(inputString.split(" "))
                    .filter(e -> e.replaceAll("[^aeiouAEIOU]", "").length() >= 2)
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {

        StreamTrials trial = new StreamTrials();
        // Stateless
        trial.updateSalary(listEmployees, 75000, 1.08f);
        trial.updateSalaryVerbose(listEmployees, 75000, 1.08f);

        //Stateful
        trial.updateSalaryStatefulVerbose(listEmployees, 75000, 1.08f);

        List<Integer> list1 = Stream.of(4, 5, 6, 5, 4).dropWhile(n -> n < 6).collect(Collectors.toList());
        System.out.println("Drop:" + list1);

        List<Integer> list2 = Stream.of(4, 5, 6, 5, 4).takeWhile(n -> n < 6).collect(Collectors.toList());
        System.out.println("Take:" + list2);
/*
        int[] a = new int[10];
        int i = 5;
        a[i++] = ++i+i++;
        System.out.println(a[5] + ", " + a[6]);*/
    }

}

final class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    Employee(String name, double salary)  {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee e) {
        return this.getName().compareTo(e.getName());
    }
}
