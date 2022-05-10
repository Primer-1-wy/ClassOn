package week11;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Driver_JDBC {
    static String global_id;
    static String global_name;
    static String global_gender;
    static String global_birth;

    public static void main(String args[])
    {
        String id="1";
        String sql="select * from tstudent where id=? ";
        /*测试专用
        //Add_to_Database();
       // Update_to_Database();

        //Select_From_Database();
       // Delete_From_Database();
       // Select_From_Database();
        //Select_From_Database_By_id();
         */
        List<Student> stu = JDBC_class.Select_All(sql,Student.class,id);

        for (Student temp:stu) {
            System.out.println(temp);
        }
        /*
        Scanner sc = new Scanner(System.in);
        int choice=0;
        MainMenu();
        choice=sc.nextInt();
        while(choice!=3)
        {
                switch(choice)
                {
                    case 1:Add_to_Database();break;
                    case 2:Select_From_Database_By_id();break;
                    default:break;
                }
            MainMenu();
            choice=sc.nextInt();
        }
        */
    }

    public static void MainMenu()
    {
        System.out.println(" 1.输入学生各项信息，保存到数据库");
        System.out.println("2.输入学生学号，查询显示该学号学生的所有记录");
        System.out.println("3.退出");
        System.out.println("请输入你的选择");

    }

    public static void Add_to_Database()
    {
        Scanner sc = new Scanner(System.in);
        String id=null;
        String name=null;
        String gender=null;
        String time=null;
        double score=0;

        System.out.println("请输入你要添加的id");
        id= sc.next();
        System.out.println("请输入你要添加的姓名");
        name= sc.next();
        System.out.println("请输入你要添加的性别");
        gender= sc.next();
        System.out.println("请输入你要添加的出生时间(格式如2019-09-19：)");
        time= sc.next();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("请输入成绩");
        score= sc.nextDouble();


        Connection con=null;
       // Statement sta=null;
        PreparedStatement pstm=null;
        try{
            java.util.Date date = (java.util.Date) ft.parse(time);//转换为date型
            java.sql.Date birth=new java.sql.Date(date.getTime());

            con= JDBC_class.getConnection();
           // sta=con.createStatement();

            int add_num=0;

          //  String sql_insert="insert into tstudent values('1','test1','男','9999-12-31',60)";
            String sql_pre_insert="insert into tstudent values(?,?,?,?,?)";
            pstm=con.prepareStatement(sql_pre_insert);
            pstm.setString(1,id);
            pstm.setString(2,name);
            pstm.setString(3,gender);
            pstm.setDate(4,birth);
            pstm.setBigDecimal(5, BigDecimal.valueOf(score));

            //  add_num=sta.executeUpdate(sql_insert);
            add_num= pstm.executeUpdate();
            if(add_num==1)
            {
                System.out.println("插入成功");
            }
            else
            {
                System.out.println("插入失败");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //最后一定要释放资源
        finally{
        //    JDBC_class.Release(con,sta,null);
            JDBC_class.Release(con,pstm,null);
        }
    }


    public static void Delete_From_Database()
    {
        Scanner sc = new Scanner(System.in);
        String id=null;
        System.out.println("请输入你要删除的id");
        id= sc.next();

        Connection con=null;
        //Statement sta=null;
        PreparedStatement pstm = null;
        try{
            con= JDBC_class.getConnection();
         //   sta=con.createStatement();
            int del_num=0;

            String sql_del="delete from tstudent where id=?";
            pstm=con.prepareStatement(sql_del);
            pstm.setString(1,id);
         //   del_num=sta.executeUpdate(sql_insert);
            del_num=pstm.executeUpdate();
            if(del_num==1)
            {
                System.out.println("删除成功");
            }
            else
            {
                System.out.println("删除失败");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //最后一定要释放资源
        finally{
            //JDBC_class.Release(con,sta,null);
            JDBC_class.Release(con,pstm,null);
        }
    }


    public static void Update_to_Database()
    {
        Scanner sc = new Scanner(System.in);
        String id=null;
        String name=null;


        System.out.println("请输入你要需要修改人的id");
        id= sc.next();
        System.out.println("请输入你修改后的姓名");
        name= sc.next();




        Connection con = null;
        PreparedStatement pstm= null;

        try{
            con = JDBC_class.getConnection();
            String sql = "update tstudent set name=? where id=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,name);
            pstm.setString(2,id);
            int i = pstm.executeUpdate();
            if(i > 0){
                System.out.println("修改成功");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBC_class.Release(con,pstm,null);
        }

    }


    public static void Select_From_Database() {
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        try {
            con = JDBC_class.getConnection();
            sta = con.createStatement();
            res = null;
            //  boolean IfSelect=false;

            String sql_select = "select * from tstudent";
            res = sta.executeQuery(sql_select);
            while (res.next()) {
                System.out.println("id:" + res.getString("id"));
                System.out.println("name:" + res.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //最后一定要释放资源
        finally {
            JDBC_class.Release(con, sta, res);
        }

    }

    public static void Select_From_Database_By_id() {
        Connection con = null;
        PreparedStatement pstm = null;
        String id;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的id");
        id = sc.next();

        ResultSet res = null;
        try {
            con = JDBC_class.getConnection();
            res = null;
            //  boolean IfSelect=false;

            String sql_select = "select * from tstudent where id=?";
            pstm = con.prepareStatement(sql_select);
            pstm.setString(1, id);
            res = pstm.executeQuery();
            ;
            while (res.next()) {
                System.out.println("id:" + res.getString("id"));
                System.out.println("name:" + res.getString("name"));
                System.out.println("gender:" + res.getString("gender"));
                System.out.println("birth:" + res.getString("birth"));
                System.out.println("score:" + res.getString("score"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //最后一定要释放资源
        finally {
            JDBC_class.Release(con, pstm, res);
        }
    }


}
