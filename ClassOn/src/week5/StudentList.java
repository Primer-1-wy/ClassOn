package week5;


public class StudentList {
    //自己实现的学生集合类
    private int count;//集合的目前大小
    private Student stu[];//学生数组
    //构造方法来指定数组的大小
    public StudentList(int maxLength) {
        count = 0;
        stu=new Student[maxLength];//创建大小为maxLength的数组
    }
    public boolean add(Student student) {
        if(student==null) {
            return false;
        }
        if( count>=stu.length) {
            return false;
        }
        stu[ count]=student;
        count++;
        return true;
    }

    public int indexOf(String id) {
        for(int i=0;i<stu.length && stu[i] !=null;i++) {
            if(stu[i].getID().equals(id)) {//满足条件，直接返回元素的下标
                return i;

            }
        }
        return -1;//循环执行完毕，依然没找到，表示没有，返回-1
    }


    public boolean remove(int index)
    {
        if(index>=count||index<0)
        {
            return false;
        }
        for(int i = index;i<count;i++)
        {
            stu[index]=stu[index+1];
        }
        //stu[index]=null;
        count--;
        return true;
    }
    public Student get(int index) {return stu[index];}

    //返回的是集合目前元素的个数（集合的大小)
    public int size( ) {return count;}
    public String toString()
    {
        String str=null;


        for(int i=0;i<stu.length && stu[i] !=null;i++) {
            str=str + stu[i].toString() + "\n";
        }
        return str;
    }
/*
    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}
    public Student[] getStu() {return stu;}
    public void setStu(Student[] stu) {this.stu = stu;}
 */
}

