class AssignmentEmployee {
    String empId, empName;
    double salary;
    boolean isIntern;

    public AssignmentEmployee(String id, String name, double salary) {
        empId = id;
        empName = name;
        this.salary = salary;
        isIntern = false;
    }

    public AssignmentEmployee(String id, String name) {
        this(id, name, 0);
        isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileCreation {
    public static void main(String[] args) {
        AssignmentEmployee e1 = new AssignmentEmployee("E-101", "Divya", 65000);
        AssignmentEmployee e2 = new AssignmentEmployee("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}