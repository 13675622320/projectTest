package SuiTangYanYi;

/**
 * 隋唐演义的舞台
 */
public class Stage extends Thread {

    @Override
    public void run(){
        System.out.println("隋唐演义，即将开始，请准备观看~");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开~~~");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        AmyRunnable armyTaskOfSuiDynasty=new AmyRunnable();
        AmyRunnable armyTaskOfSuiRevolt=new AmyRunnable();

        //使用Runnable接口创建线程
        Thread armyOfSuiDanaty = new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt=new Thread(armyTaskOfSuiRevolt,"农民起义军");

        //启动线程，让军队开始做战
        armyOfSuiDanaty.start();
        armyOfRevolt.start();

        //舞台线程休眠，大家专心观看军队的厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("半路杀出了个陈程咬金！！！");
        Thread mrCheng=new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("我是程咬金，我的理想是推掉对方水晶！");

        //停止军队做战(即停止线程的方法)
        armyTaskOfSuiDynasty.keepRunning=false;
        armyTaskOfSuiRevolt.keepRunning=false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //历史大戏留给关键人物
        mrCheng.start();
        //万众瞩目，所有线程等待程先生完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，敌方水晶已被摧毁");
        System.out.println("谢谢观看隋唐演义，再见！！！");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
