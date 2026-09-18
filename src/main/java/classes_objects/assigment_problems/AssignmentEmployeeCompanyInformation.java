class AssignmentCompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount;

    AssignmentCompanyEmployee(String name, double salary) {
        empName = name;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyInformation {
    public static void main(String[] args) {
        new AssignmentCompanyEmployee("Ayan", 50000);
        new AssignmentCompanyEmployee("Ravi", 60000);
        new AssignmentCompanyEmployee("Priya", 55000);

        AssignmentCompanyEmployee.printCompanyInfo();
    }
}