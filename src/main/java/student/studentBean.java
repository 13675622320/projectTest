package student;

import java.io.InputStream;

/**
 * @author wxl
 * @date 2019-04-10 09:59
 */
public class studentBean {
    private String name;
    private String age;
    private String sex;
    private String fileName;
    public studentBean(String name) {
        this.name = name;
    }

    public studentBean() {
    }

    public studentBean(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    private InputStream tmkCsvStream;

    public InputStream getTmkCsvStream() {
        return tmkCsvStream;
    }

    public void setTmkCsvStream(InputStream tmkCsvStream) {
        this.tmkCsvStream = tmkCsvStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "studentBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", fileName='" + fileName + '\'' +
                ", tmkCsvStream=" + tmkCsvStream +
                '}';
    }
}
