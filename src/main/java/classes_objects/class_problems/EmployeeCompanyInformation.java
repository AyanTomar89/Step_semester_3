class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount;

    CompanyEmployee(String name, double salary) {
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
        new CompanyEmployee("Ayan", 50000);
        new CompanyEmployee("Ravi", 60000);
        new CompanyEmployee("Priya", 55000);

        CompanyEmployee.printCompanyInfo();
    }
}