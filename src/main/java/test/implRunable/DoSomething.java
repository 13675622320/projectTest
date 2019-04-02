package test.implRunable;

/**
 *  实现Runnable接口的类
 */
public class DoSomething implements Runnable {

    private String name1;

    public DoSomething(String name) {
        this.name1 = name;
    }

    @Override
    public void run() {
        for (int i=0;i<4;i++){
            for (long k=0;k<10;k++){
                System.out.println(name1+":"+i);
            }
        }
    }
}
