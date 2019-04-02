package othertest;

/**
 * 线程的调度-合并
 */
public class Test {
    public static void main(String[] args) {
        Thread myJoinThread=new MyJoinThread();
        myJoinThread.setName("MyJoinThread");
        myJoinThread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第"+"["+i+"]"+"次执行~");
            if (i > 3) {
                try {
                    myJoinThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyJoinThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":第"+"["+i+"]"+"次执行~");
            try {
                MyJoinThread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}