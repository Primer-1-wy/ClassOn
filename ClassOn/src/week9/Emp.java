package week9;
public class Emp {
    private Integer empNo;
    private String ename;
    private double sal;

    public Emp(){}
    public Emp(Integer empNo, String ename, double sal) {
        this.empNo = empNo;
        this.ename = ename;
        this.sal = sal;
    }
    public Integer getEmpNo() {
        return empNo;
    }
    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
}