package bianxingjingang;

/**
 * 宇宙的能量系统
 * 遵循能量守恒定律
 * 能量不会凭空创生或消失，只会从一处转移到另一处
 */

public class EnergySystem {
    //能量盒子，能量储存的地方
    private final double[] energyBoxes;

    private final Object lockObj=new Object();



    /**
     * n 能量盒子的数量
     * initialEnergy 每个能量盒子初始含有的能量值
     */
    public EnergySystem(int n,double initialEnergy){
        energyBoxes=new double[n];
        for (int i=0;i<energyBoxes.length;i++){
            energyBoxes[i]=initialEnergy;
        }
    }
    /**
     * 能量的转移
     * from 转移来源
     * to 能量终点
     * amount 能量值
     */
    public void transfer(int from,int to,double amount){
        //表明要对synchronized方法体内的代码进行互斥操作，保证互斥的实现
        synchronized (lockObj){
//            if (energyBoxes[from]<amount){
//                return;
//            }
            //while循环，保证条件不满足时任务都会被条件阻挡，
            //而不是继续竞争CPU资源
            //Wait set
            while (energyBoxes[from]<amount){
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            energyBoxes[from]-=amount;
            System.out.printf("从%d转移%10.2f单位能量到%d",from,amount,to);
            energyBoxes[to]+=amount;
            System.out.printf("能量总和：%10.2f%n",getTotalEnergies());

            //唤醒所有在lockObj对象上等待的线程
            lockObj.notifyAll();

        }
    }

    /**
     * 获取能量世界的能量总和
     */
    public double getTotalEnergies(){
        double sum=0;
        for (double amount:energyBoxes){
            sum+=amount;
        }
        return sum;
    }

    /**
     * 返回能量盒子的长度
     */
    public int getBoxAmount(){
        return energyBoxes.length;
    }
}
