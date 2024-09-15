package homework.employee;

import homework.employee.model.Employee;
import homework.employee.storage.EmployeeStorage;

import java.util.Scanner;

public class CompaniesApp implements CompainsCommands
{
    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employees = new EmployeeStorage();

    public static void main(String[] args)
    {
        boolean run = true;
        CompainsCommands.printCommands();
        while(run)
        {
            switch(scanner.nextLine())
            {
                case EXIT:
                    run = false;
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL_EMPLOYEES:
                    employees.print();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEE_ID:
                    searchEmployeeByEmployeeId();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEE_COMPANY_NAME:
                    searchEmployeeByEmployeeCompanyName();
                    break;
                default:
                    System.out.println("Wrong command");
            }

        }

    }

    private static void searchEmployeeByEmployeeCompanyName()
    {
        System.out.println("Please input the employee company name");
        String companyName = scanner.nextLine();
        employees.printEmployeeByEmployeeCompanyName(companyName);
    }

    private static void searchEmployeeByEmployeeId()
    {
        System.out.println("Please input the employee ID");
        Employee employee = employees.getEmployeeById(scanner.nextLine());

    }

    private static void addEmployee()
    {
        System.out.println("Please input name");
        String name = scanner.nextLine();
        System.out.println("Please input surname");
        String surname = scanner.nextLine();
        System.out.println("Please input employeeID");
        String employeeID = scanner.nextLine();
        System.out.println("Please input salary");
        double salary = 0.0;
        try
        {
            salary = Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Please input only numbers");
            salary = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("Please input company name");
        String companyName = scanner.nextLine();
        System.out.println("Please input position");
        String position = scanner.nextLine();
        employees.add(new Employee(name, surname, employeeID, salary, companyName, position));

    }
}
