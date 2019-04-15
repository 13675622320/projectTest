package student;

import util.DateUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * @author wxl
 * @date 2019-04-10 10:01
 */
public class studentTest {
    public static void exportTest(){
        studentBean student=new studentBean();
        String tmks="\\128364782930851\\,\\99856231\\,\\wexckSJEW32973CE89D\\,\\CEDWVC3REFD32E3FERVR4GF45V4V\\,\\DWEQD32DF32xed3S3Dd3dcqd2\\";
        ByteArrayInputStream stream = new ByteArrayInputStream(tmks.getBytes());
        student.setFileName(DateUtil.getDefaultDateStr(new Date())+"-tmk.txt");
        student.setTmkCsvStream(stream);
        System.out.println(student);
    }


    public static void main(String[] args) {
        String name="张三";
        String sex="男";
        studentBean stu=new studentBean(name,sex);
        System.out.println(stu.getSex());

        exportTest();
    }
}
