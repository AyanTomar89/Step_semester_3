class AssignmentPayrollAccount {
    private double basicSalary, bonus;

    public AssignmentPayrollAccount(double salary) {
        if (salary < 0) {
            System.out.println("Warning: Negative salary");
            salary = 0;
        }
        basicSalary = salary;
    }

    public void creditBonus(double amount) {
        if (amount <= 0)
            System.out.println("Invalid bonus");
        else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100)
            System.out.println("Invalid tax");
        else {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class PayrollSalaryManagement {
    public static void main(String[] args) {
        AssignmentPayrollAccount p = new AssignmentPayrollAccount(50000);
        p.creditBonus(5000);
        p.deductTax(10);
        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}