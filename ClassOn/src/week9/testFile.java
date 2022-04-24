package week9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testFile {
    public static void main(String[] args) throws FileNotFoundException {
        //create(); //创建一个文件
        //    print(); // 打印 按输入流打印 就是一个字节一个字节
        //   write();
        //  wirte_string(); //按字符串写入
        //  read_string();
        write_object();//按内置类型写入
        read_object();
    }

    public static void create() {
        File f1 = new File("src\\aa.txt");//相对路径，如果没有前面的src，就在当前目录创建文件
        if (f1.exists()) {
            System.out.println("文件已经存在");
        } else {
            try {
                f1.createNewFile();
                System.out.println("文件创建成功");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("文件是否已经存在:" + f1.exists());
        System.out.println("文件的名字:" + f1.getName());
        System.out.println("文件的路径:" + f1.getPath());
        System.out.println("文件的绝对路径:" + f1.getAbsolutePath());
        System.out.println("是目录吗:" + f1.isDirectory());
        System.out.println("文件大小:" + f1.length());
    }

    public static void print() {
        try {
            File file = new File("src\\aa.txt");
            FileInputStream f1 = new FileInputStream(file);//这里需要进行抛出异常处理
            for (int i = 0; i < file.length(); i++) {
                char ch = (char) (f1.read());//循环读取字符
                System.out.print(ch + " ");
            }
            System.out.println();//换行操作
            f1.close();//关闭文件
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("文件打开失败");
        }

    }

    public static void write() throws FileNotFoundException {
        File file = new File("src\\aa.txt");
        FileOutputStream f1 = new FileOutputStream(file);//(file,true)，这里有true的话，代表可以在文件后面追加内容
        String str = "I love coding";
        byte[] buff = str.getBytes();//将字符串转换为字节数组
        try {
            f1.write(buff);//把字节数组的内容写进去文件
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                f1.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void wirte_string() {
        String[] str = {"春眠不觉晓,", "处处闻啼鸟,", "夜来风雨声,", "花落知多少,"};
        File file = new File("src\\cc.txt");//我们在该类的位置创建一个新文件
        FileWriter f = null;//创建文件写入对象
        BufferedWriter f1 = null;//创建字符流写入对象

        try {
            //这里把文件写入对象和字符流写入对象分开写了
            f = new FileWriter("src\\cc.txt");//创建一个名为cc.txt的文件
            f1 = new BufferedWriter(f);
            //通过循环遍历上面的String 数组中的元素
            for (int i = 0; i < str.length; i++) {
                f1.write(str[i]);//把String中的字符写入文件
                f1.newLine();//换行操作
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {//如果没有catch 异常，程序最终会执行到这里
            try {
                f1.close();
                f.close();//关闭文件
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }

    public static void read_string() {
        File file = new File("src\\cc.txt");
        FileReader f = null;//文件读取对象
        BufferedReader f1 = null;//字符流对象
        try {
            f = new FileReader(file);
            f1 = new BufferedReader(f);
            //循环打印cc文件中的每行数据
            String str = null;
            while ((str = f1.readLine()) != null) {
                System.out.println(str);
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                f1.close();
                f.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }

    public static void write_object()
    {
        //数据完成持久化的操作
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        FileOutputStream f1=null;
        ObjectOutputStream f2 =null;
        try
        {
            //第一行省略了前面的 File file = new File(~)的操作，直接创建一个文件
            f1 = new FileOutputStream(new File("src\\dd.txt"));
            f2 = new ObjectOutputStream(f1);
            f2.writeObject(list);
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        finally
        {
            try
            {
                f2.close();
                f1.close();
            }
            catch (Exception e2)
            {
                // TODO: handle exception
            }
        }
    }

    public static void read_object()
    {
            FileInputStream f1 = null;
            ObjectInputStream f2 = null;
            List list = null;
            try
            {
                f1 = new FileInputStream("src\\dd.txt");
                f2 = new ObjectInputStream(f1);
                list = (List<String>) f2.readObject();
            }
            catch (Exception e)
            {
                //TODO::dd
            }
            finally
            {
                try
                {
                    f1.close();
                    f2.close();
                }
                catch (Exception e2)
                {
                    //TODO::dd
                }
            }
            System.out.println(list);
    }
}

