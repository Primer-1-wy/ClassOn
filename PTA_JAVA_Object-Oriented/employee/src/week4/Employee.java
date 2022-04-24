package week4;

public class Employee {
    private String name;
    private int id;
    private String department;
    private double baseSalary;

    //一般用于成员变量初始化
    public Employee() {}

    //重载override：一个类可以有多个同名方法，但参数和返回不完全一样
    public Employee(String name, int id, String department, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    //对每个成员变量的操作无非是读get，或者设置set
    //因此需要对每个成员变量定义相应的get和set方法，权限为public
    public int getId() {
        return id;
    }

    //this表示本类
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void updateSalary() {
        baseSalary = baseSalary * 1.035;
    }

    public void displayEmployee() {
        System.out.println("id=" + id + ",name = " + name + ",department = " + department + ",baseSalary=" + baseSalary);
    }
}

