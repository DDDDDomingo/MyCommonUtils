package studio.domingo.common.spring;

/**
 * @ClassName: AssertUtils
 * @description: 方法入参校验工具类，仿造Spring4.3.7的org.springframework.util.Assert
 * @date: 2019/8/20 10:48
 */
public abstract class AssertUtils {

    /**
     * 验证一个表达式。如果表达式为false，则抛出{IllegalStateException}异常
     *
     * @param expression 布尔表达式
     * @param msg
     * @throws IllegalArgumentException 如果expression是false
     */
    public static void state(boolean expression, String msg) {
        if (!expression) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 不建议使用，建议使用state(boolean, String)
     *
     * @param expression
     */
    @Deprecated
    public static void state(boolean expression) {
        state(expression, "[Assertion failed] - this state invariant must be true");
    }

    /**
     * 验证一个表达式。如果表达式为false，则抛出{IllegalStateException}异常
     *
     * @param expression 布尔表达式
     * @param msg
     * @throws IllegalArgumentException 如果expression是false
     */
    public static void isTrue(boolean expression, String msg) {
        if (!expression) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 不建议使用，建议使用isTrue(boolean, String)
     *
     * @param expression
     */
    @Deprecated
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * 验证一个对象不为null。
     * @param obj
     * @param msg
     * @throws IllegalArgumentException 如果obj是null
     */
    public static void isNull(Object obj, String msg){
        if(obj!=null){
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 不建议使用，建议使用isNull(Object, String)
     * @param obj
     */
    public static void isNull(Object obj){
        isNull(obj, "[Assertion failed] - the object argument must be null");
    }

    /**
     * 验证
     * @param obj
     * @param msg
     */
    public static void notNull(Object obj, String msg){
        if(obj==null){
            throw new IllegalArgumentException(msg);
        }
    }

    @Deprecated
    public static void notNull(Object obj){
        notNull(obj, "[Assertion failed] - this argument is required; it must not be null");
    }
}
