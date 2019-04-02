package test.implRunable;


/**
 * 测试Runnable类实现的多线程程序
 */
public class TestRunnable {
    public static void main(String[] args) {
        DoSomething ds1=new DoSomething("李白");
        DoSomething ds2=new DoSomething("杜甫");

        Thread thread1=new Thread(ds1);
        Thread thread2=new Thread(ds2);

        thread1.start();
        thread2.start();
    }
}
