package com.techelevator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public List<Department> departments = new ArrayList<>();
    public List<Employee> employees = new ArrayList<>();
    public Map<String, Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     *
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        employees.get(1).raiseSalary(10);
        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();

        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        departments.add(new Department(1, "Marketing"));
        departments.add(new Department(2, "Sales"));
        departments.add(new Department(3, "Engineering"));
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department name : departments) {
            System.out.println(name.getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee deanJohnson = new Employee();
        deanJohnson.setEmployeeId(1);
        deanJohnson.setFirstName("Dean");
        deanJohnson.setLastName("Johnson");
        deanJohnson.seteMail("djohnson@teams.com");
        deanJohnson.setSalary(60000);
        deanJohnson.setDepartment(departments.get(2));
        deanJohnson.setHireDate(deanJohnson.getHireDate());

        employees.add(deanJohnson);

        employees.add(new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020"));

        employees.add(new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020"));


    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + "( " + currency.format(employee.getSalary()) + ") " + employee.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        List <Employee> projectEmployees = new ArrayList<>();

        Project project = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");

        for (Employee engineering: employees) {
            if (engineering.getDepartment().getName().equals("Engineering")) {
                projectEmployees.add(engineering);
            }

        }
        project.setTeamMembers(projectEmployees);
        projects.put(project.getName(), project);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        List<Employee> marketingEmployees = new ArrayList<>();
        Project project = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");

        for (Employee marketing: employees) {
            if (marketing.getDepartment().getName().equals("Marketing")) {
                marketingEmployees.add(marketing);
            }
        }
        project.setTeamMembers(marketingEmployees);
        projects.put(project.getName(), project);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (Map.Entry<String, Project> entry : projects.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getTeamMembers().size());
        }
    }
}

