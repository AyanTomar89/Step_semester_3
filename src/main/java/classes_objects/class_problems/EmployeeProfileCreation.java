class Employee {
    String empId, empName;
    double salary;
    boolean isIntern;

    public Employee(String id, String name, double salary) {
        empId = id;
        empName = name;
        this.salary = salary;
        isIntern = false;
    }

    public Employee(String id, String name) {
        this(id, name, 0);
        isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileCreation {
    public static void main(String[] args) {
        Employee e1 = new Employee("E-101", "Divya", 65000);
        Employee e2 = new Employee("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}