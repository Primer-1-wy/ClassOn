package week11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
    /**
     * 使用JDBC连接并操作mysql数据库
     */
    public static void main(String[] args) {
        // 数据库驱动类名的字符串
        String driver = "com.mysql.cj.jdbc.Driver";
        // 数据库连接串
        String url = "jdbc:mysql://127.0.0.1:3306/classondb";
        // 用户名
        String username = "root";
        // 密码
        String password = "123456";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean rs1=false;
        try {
            // 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）
            Class.forName(driver);
            // 2、获取数据库连接
            conn = DriverManager.getConnection(url, username, password);
            // 3、获取数据库操作对象
            stmt = conn.createStatement();
            // 4、定义操作的SQL语句
                String sql_create_database="create database mis";
                rs1 = stmt.execute(sql_create_database);
                url = "jdbc:mysql://127.0.0.1:3306/mis";
                conn = DriverManager.getConnection(url, username, password);
                stmt = conn.createStatement();
                String sql_create_table = "create table tstudent(" +
                        "id varchar(20) not null," +
                        "name varchar(20) not null," +
                        "gender varchar(20) not null," +
                        "birth date not null," +
                        "score decimal(9,1)not null" +
                        "); ";
                String sql_insert="insert into tstudent values('1','test1','男','9999-12-31',60)";
                String sql_select="select * from tstudent";
            // 5、执行数据库操作
            rs1 = stmt.execute(sql_create_table);
            rs1 = stmt.execute(sql_insert);
            rs = stmt.executeQuery(sql_select);
            // 6、获取并操作结果集
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7、关闭对象，回收数据库资源
            if (rs != null) { //关闭结果集对象
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) { // 关闭数据库操作对象
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) { // 关闭数据库连接对象
                try {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//main

    public static void create()
    {


    }
}

