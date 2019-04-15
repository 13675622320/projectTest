import java.util.ArrayList;
import java.util.List;

/**
 * @author wxl
 * @date 2019-04-09 16:35
 */
public class splitTest {
    public static void main(String[] args) {
        String T014ip="10.0.171.25,10.0.171.26,10.0.171.27,10.0.171.28";
        String[] T014ipArray = T014ip.split(",");
//        for (int i = 0; i < T014ipArray.length; i++) {
//            System.out.println(T014ipArray[i]);
//        }
        List<String> T014ipList = new ArrayList<String>(T014ipArray.length);
        for(int i = 0; i < T014ipArray.length; i++){
            T014ipList.add(i,T014ipArray[i]);
            System.out.println(T014ipList.get(i));
        }
    }
}
