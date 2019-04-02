package bianxingjingang;

public class EnergySystemTest {
    //构建能量盒子的数量
    public static final int BOX_AMOUNT =100;
    //每个盒子的初始能量
    public static final double INITIAL_ENERGY=1000;

    public static void main(String[] args) {
        EnergySystem energySystem=new EnergySystem(BOX_AMOUNT,INITIAL_ENERGY);
        for (int i = 0; i < BOX_AMOUNT; i++) {
            EnergyTransferTask task=new EnergyTransferTask(energySystem,i,INITIAL_ENERGY);
            Thread thread=new Thread(task,"TransferThread_"+i);
            thread.start();
        }
    }
}
