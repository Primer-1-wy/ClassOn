package week9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
/**
 *
 * Dom4j写XML
 *
 * 将JAVA对象，通过Dom4j  API,转换成文档对象（树状结构），通过输出流，将文档对象写入XML文件中
 */
public class Test_Xml {
    public static void main(String[] args) throws IOException {
        List<Emp> emps = findAll();
        //1、通过文档帮助器，创建一个文档对象
        Document doc = DocumentHelper.createDocument();
        //2、添加根元素
        Element root = doc.addElement("emps");
        for (Emp emp : emps) {
            //3、添加子元素，属性，文本
            Element empEle = root.addElement("emp");
            empEle.addAttribute("empNo", emp.getEmpNo()+"");
            Element enameEle = empEle.addElement("ename");
            enameEle.addText(emp.getEname());
            Element salEle = empEle.addElement("sal");
            salEle.addText(emp.getSal()+"");
        }
        //4、创建一个文件输出流
        FileOutputStream fos = new FileOutputStream("emps.xml");
        //装饰者模式  写XML文档的输出流
        XMLWriter writer = new XMLWriter(fos);
        writer.write(doc);
        //writer.flush();
        writer.close();
    }
    public static List<Emp> findAll(){
        List<Emp> emps = new ArrayList<Emp>();
        for (int i = 0; i < 100; i++) {
            Emp emp = new Emp(10001+i,"职员"+i,5000+i);
            emps.add(emp);
        }
        return emps;
    }
}