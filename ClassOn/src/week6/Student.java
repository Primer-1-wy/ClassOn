package week6;
import java.util.ArrayList; // 引入 ArrayList 类
public class Student {
    private String id;
    private String name;
    private String gender;
    private ArrayList<Subject> subj=new ArrayList<Subject>();

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    public ArrayList<Subject> getSubj() {return subj;}
    public void setSubj(ArrayList<Subject> subj) {this.subj = subj;}

    public Student(String id, String name, String gender, ArrayList<Subject> subj) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.subj = subj;
    }
    public Student() {
    }

    @Override
    public String toString() {
        return   id + ' ' +
                 name + ' ' +
                 gender + ' ' +
                my_avg();
    }
    public double my_avg()
    {
        double sum=0;
        for(int j =0;j<this.getSubj().size();j++)
        {
            sum = sum + subj.get(j).getGrade();
        }
      //  System.out.println(sum);
      //  System.out.println(this.getSubj().size());
        return sum/this.getSubj().size();
    }
}
