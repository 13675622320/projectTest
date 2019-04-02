package ThreadModel;

/**
 * 生产者-消费者模型：
 * 1、生产者仅仅在仓储未满时候生产，仓满则停止生产。
 * 2、消费者仅仅在仓储有产品时候才能消费，仓空则等待。
 * 3、当消费者发现仓储没产品可消费时候会通知生产者生产。
 * 4、生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 */

/**
 * Java线程：并发协作-生产者消费者模型
 */
public class produceAndcustomerModel {
    public static void main(String[] args) {
    }
}

/**
 * 仓库类
 */
class Godown {
    public static final int MAX_SIZE = 100;//最大库存量
    public int curnum;    //当前库存量
    Godown() {
    }
    Godown(int curnum) {
        this.curnum = curnum;
    }
}