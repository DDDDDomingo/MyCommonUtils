package studio.domingo.common.util;

import org.apache.commons.io.FileUtils;

/**
 * @ClassName: StringUtils
 * @Description: 字符串工具类
 */
public class StringUtils {

    /**
     * 判断是否为空字符串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
