package week11;



import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC_class {
    //提取到全局作用域：
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String passwd = null;

    //静态块  里面包含驱动名 url名 localhost登录等。。  最后连接驱动
    static{
        try{
            InputStream in=JDBC_class.class.getClassLoader().getResourceAsStream("db.properties");//将源文件读取流
            Properties properties=new Properties();//创建一个源文件类对象
            properties.load(in);//给对象赋入流

            driver=properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            passwd = properties.getProperty("passwd");

            //加载驱动
            Class.forName(driver);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //定义连接数据库的方法
    public static Connection getConnection()
    {
        Connection con=null;
        try {
            con = DriverManager.getConnection(url, username, passwd);//
            //return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    //定义释放资源的方法  资源：数据库链接connection   sql操作语句statement     查询结果ResultSet
    public static void Release(Connection con, Statement sta, ResultSet res)
    {
        //释放 数据库链接
        try{
            if(con != null){
                con.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        //释放sql操作语句对象
        try{
            if(sta != null){
                sta.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        //释放查询对象结果集对象
        try{
            if(res != null){
                res.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }




}
