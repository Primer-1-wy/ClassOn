package week11;
/*
实现了数据库的连接和资源的释放


*/


import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


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

    //泛型查找
    public static <T> List<T> Select_All(String sql, Class<T> cls, Object... params) {
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        con=JDBC_class.getConnection();//连接数据库
        PreparedStatement ps=null;
        try {//声明预编译语句ps  和获取多余参数params  参数主要是具体的查询条件
            ps = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }

            res = ps.executeQuery();
            //检索此ResultSet对象的列数、类型和字段
            ResultSetMetaData rsd = res.getMetaData();
            List<T> list = new ArrayList<T>();

            while (res.next()) {//向下读一行
                //泛型实例化
                T t = cls.newInstance();

                for (int i = 0; i < rsd.getColumnCount(); i++) {

                    try {
                        //获取指定列的别名，如果sql语句中没有指定别名，则返回值与getColumnName方法相同
                        String column = rsd.getColumnLabel(i + 1);

                        Object value = res.getObject(column);
                        //通过反射获取变量Field对象
                       // if(getParam(column).equals("birth"))    continue;
                    //    if(getParam(column).equals("birth"))    continue;

                        Field field = cls.getDeclaredField(getParam(column));
                        //开启允许访问私有变量的权限
                        field.setAccessible(true);
                        //给变量赋值
                        field.set(t, value);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
                list.add(t);
            }
            return list;
        }
        catch(Exception e){
                e.printStackTrace();
                return null;
            }
        //最后一定要释放资源
        finally {
            JDBC_class.Release(con, sta, res);
        }

    }


    // 数据库字段转变量，例如stu_name转为stuName
    public static String getParam(String column) {
        String[] arr = column.split("_");
        StringBuffer sf = new StringBuffer(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sf.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));
        }
        return sf.toString();
    }


}
