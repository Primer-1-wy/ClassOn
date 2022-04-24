package week4;

public class Driver {
    public static void main(String[] args) {
        Employee emp1 = new Employee("smith",1001,"sale",8000);
        Employee emp2 = new Employee("smith2",1002,"manage",10000);
        System.out.println("员工1工资="+emp1.getBaseSalary());
        System.out.println("员工2工资="+emp2.getBaseSalary());
    }
}
