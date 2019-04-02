package SuiTangYanYi;

/**
 * 军队线程，模拟做战双方的行为
 */
public class AmyRunnable implements Runnable {
    //volatile保证了线程可以正确的读取线程写入的值
    //可见性 参考JMM happens-before原则
    volatile boolean keepRunning = true;
    @Override
    public void run() {
        while (keepRunning){
            //发动5连击
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
                //让出了处理器时间，下次谁进攻还不一定呢！
                Thread.yield();
            }
        }
        //下面的操作，现实的开发中，可以用来处理资源
        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
