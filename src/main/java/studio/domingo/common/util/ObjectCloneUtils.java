package studio.domingo.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description: 对象克隆工具类
 * Date: 2019/7/31 17:57
 */
public class ObjectCloneUtils {
    // TODO: 2019/7/31 https://blog.csdn.net/a907691592/article/details/95318411
    //fast
    //input

    //output


    //normal
    //input
    private static ByteArrayInputStream byteArrayInputStream;
    private static ObjectInputStream objectInputStream;
    //ouput
    private static ByteArrayOutputStream byteArrayOutputStream;
    private static ObjectOutputStream objectOutputStream;

    static {
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

}
