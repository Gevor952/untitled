package homework.employee.storage;

import homework.employee.model.Employee;


public class EmployeeStorage
{
    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void add(Employee Employee)
    {
        if(size == employees.length)
        {
            extendStorage();
        }
        employees[size++] = Employee;
    }

    private void extendStorage()
    {
        Employee[] temp = new Employee[size * 2];
        System.arraycopy(employees, 0, temp, 0, size);
        employees = temp;
    }

    public void print()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println(employees[i]);
        }
    }


    public Employee getEmployeeById(String id)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getEmployeeID().equals(id))
            {
                return employees[i];
            }
        }
        return null;
    }

    public Employee getEmployeeByProfession(String commpany)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getCompany().equals(commpany))
            {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(String id)
    {
        for(int i = 0; i < size; i++)
        {
            if(employees[i].getEmployeeID().equals(id))
            {
                Employee[] temp = new Employee[(size - i) + 10];
                System.arraycopy(employees, i + 1, temp, 0, size );
                System.arraycopy(temp, 0, employees, i , size--);
            }
        }
    }


    public void printEmployeeByEmployeeCompanyName(String commpany)
    {
        for(int i = 0; i < size; i++)
        {
            if(employees[i].getCompany().equals(commpany))
            {
                System.out.println(employees[i]);
            }
        }
    }
}