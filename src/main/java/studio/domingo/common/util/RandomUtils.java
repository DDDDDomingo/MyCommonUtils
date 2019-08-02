package studio.domingo.common.util;

import java.util.Random;

/**
 * @ClassName: OssUtils
 * @Description: 随机CODE生成工具类
 */
public class RandomUtils {
    public static String genHadId() {
        long millis = System.currentTimeMillis();
        Random random = new Random();
        // 从99开始到999
        int end3 = random.nextInt(999) + 99;
        String str = millis + String.format("%03d", end3);
        return str;
    }

    public static long genTwoId() {
        long millis = System.currentTimeMillis();
        Random random = new Random();
        // 从10开始到99
        int end2 = random.nextInt(99) + 10;
        //不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
}
