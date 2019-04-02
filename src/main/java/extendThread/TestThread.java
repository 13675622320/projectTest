package extendThread;

/**
 * 测试扩展Thread类实现的多线程程序
 * @author xianglei.wang
 */

public class TestThread extends Thread {
    @Override
    public void run() {
        for(int i = 0;i<5;i++){
            for(long k= 0; k <100;k++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName()+" :"+i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new TestThread();
        t1.setName("阿猫");
        Thread t2 = new TestThread();
        t2.setName("阿狗");
        t1.start();
        t2.start();
    }
}
