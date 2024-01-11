package streasapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRunner {

  public static void main(String[] args) {
    List<Employee> employeeList = new ArrayList<Employee>();

    employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
    employeeList.add(
        new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
    employeeList.add(
        new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
    employeeList.add(
        new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
    employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
    employeeList.add(
        new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
    employeeList.add(
        new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
    employeeList.add(
        new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
    employeeList.add(
        new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
    employeeList.add(
        new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
    employeeList.add(
        new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
    employeeList.add(
        new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
    employeeList.add(
        new Employee(223, "Nitika", 24, "Female", "Product Development", 2016, 38200.0));

    employeeList.add(
        new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
    employeeList.add(
        new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
    employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
    employeeList.add(
        new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
    employeeList.add(
        new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

// 1- How many male and female employees are there in the organization?
    // select from Employee where department
    Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getGender,
            Collectors.counting()));

    System.out.println("No Of Male And Female Employees--->" + noOfMaleAndFemaleEmployees);
    System.out.println("Total Employees--->" + employeeList.size());
    // 2- Print the name of all departments in the organization?
    // select distinct department from employee
    List<String> theNameOfAllDepartments = employeeList.stream().map(Employee::getDepartment)
        .distinct().toList();
    System.out.println("The Name Of All Departments---> " + theNameOfAllDepartments);

    // 3-What is the average age of male and female employees?

    Map<String, Double> averageAgeOfMaleAndFemaleFmployees = employeeList.stream().collect(
        Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

    System.out.println(
        "The average age of male and female employees--->" + averageAgeOfMaleAndFemaleFmployees);

    //4- Get the details of highest paid employee in the organization?
    Optional<Employee> highestPaidEmployee = employeeList.stream()
        .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
    System.out.println("The highest paid employee in the organization--->" + highestPaidEmployee);

    //4-1- Get the details of lowest paid employee in the organization?
    Optional<Employee> lowestPaidEmployee = employeeList.stream()
        .collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
    System.out.println("The lowestr paid employee in the organization--->" + lowestPaidEmployee);

    //5-  Get the names of all employees who have joined after 2015?
    List<String> theNamesOfAllEmployeesAfter2015 = employeeList.stream()
        .filter(Employee -> Employee.getYearOfJoining() > 2015).map(Employee::getName).toList();
    System.out.println(
        "The Names Of All Employees joined after 2015-->" + theNamesOfAllEmployeesAfter2015);

    List<String> theNamesOfAllEmployees = employeeList.stream().map(Employee::getName).toList();
    System.out.println("The Names Of All Employees -->" + theNamesOfAllEmployees);

    //6- Count the number of employees in each department?
    Map<String, Long> noOfEmployeesInEachDep = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    System.out.println("the number of employees in each department--->" + noOfEmployeesInEachDep);

    // 7- What is the average salary of each department?
    Map<String, Double> averageSalaryInEachDep = employeeList.stream().collect(
        Collectors.groupingBy(Employee::getDepartment,
            Collectors.averagingDouble(Employee::getSalary)));
    System.out.println("the average salary of each departmen--->" + averageSalaryInEachDep);

    //8 Get the details of youngest male employee in the product development department?

    Optional<Employee> youngestEmployee = employeeList.stream().filter(
            employee1 -> employee1.getGender().equalsIgnoreCase("Male") && employee1.getDepartment()
                .equalsIgnoreCase("Product Development"))
        .min(Comparator.comparingDouble(Employee::getAge));
    ;
    System.out.println("the details of youngest male employee in the product development department"
        + youngestEmployee);

    // 9 : Who has the most working experience in the organization?

    Optional<Employee> employee = employeeList.stream()
        .sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
    Optional<Employee> employee1 = employeeList.stream()
        .min(Comparator.comparing(Employee::getYearOfJoining));
    Optional<Employee> employee2 = employeeList.stream()
        .collect(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining)));
    System.out.println("employee--->" + employee);
    System.out.println("employee1--->" + employee1);
    System.out.println("employee2--->" + employee2);

    // 10 : How many male and female employees are there in the sales and marketing team?
    Map<String, Long> totalMaleAndFemaleEmployees = employeeList.stream()
        .filter(employee11 -> employee11.department.equalsIgnoreCase("Sales And Marketing"))
        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    System.out.println("totalMaleAndFemaleEmployees--->" + totalMaleAndFemaleEmployees);
    //11-What is the average salary of male and female employees?
    Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getGender,
            Collectors.averagingDouble(Employee::getSalary)));
    System.out.println("avgSalaryOfMaleAndFemaleEmployees-->" + avgSalaryOfMaleAndFemaleEmployees);

    //12 : List down the names of all employees in each department?

    Map<String, List<Employee>> namesOfAllEmployeesInEachDepartment = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));

    System.out.println("namesOfAllEmployeesInEachDepartment-->"+namesOfAllEmployeesInEachDepartment);

    // 13 : What is the average salary and total salary of the whole organization?

    DoubleSummaryStatistics employeeSalaryStatistics=
        employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
    System.out.println("the average salary of the whole organization--->"+employeeSalaryStatistics.getAverage());
    System.out.println("the total salary of the whole organization---->"+employeeSalaryStatistics.getSum());

    //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

    Map<Boolean, List<Employee>> partitionEmployeesByAge=
        employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

    System.out.println("partitionEmployeesByAge-->"+partitionEmployeesByAge);

    // 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
    Optional<Employee> employee3 = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
    System.out.println(""+employee3.get().getName());
    System.out.println(""+employee3.get().getAge());
    System.out.println(""+employee3.get().getDepartment());




    List<String> names = Arrays.asList("John", "Jane", "Adam", "Eve", "Mike");

    List<String> filteredNames = names.stream()
        .filter(name -> name.startsWith("J"))
        .map(String::toUpperCase)
        .collect(Collectors.toList());

    System.out.println(filteredNames); // Output: [JOHN, JANE]

  }


}
