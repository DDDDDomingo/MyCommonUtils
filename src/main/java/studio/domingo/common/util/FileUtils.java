package studio.domingo.common.util;

import java.io.*;

//https://www.cnblogs.com/aeolian/p/9484247.html#autoid-2-0-0

/**
 * @ClassName: FileUtils
 * @Description: 文件操作工具类
 */
public class FileUtils {

    /**
     * 仅判断文件是否存在
     *
     * @param file
     * @return
     */
    public static boolean isFileExists(File file) {
        return isFileExists(file, false);
    }

    /**
     * 判断文件是否存在，不存在则创建新文件
     *
     * @param file   文件对象
     * @param doMake 是否新建该文件
     * @return
     */
    public static boolean isFileExists(File file, boolean doMake) {
        if (file.exists()) {
            return true;
        } else {
            if (doMake) {
                try {

                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    /**
     * 仅判断文件夹是否存在
     *
     * @param dir
     * @return
     */
    public static boolean isDirExists(File dir) {
        return isDirExists(dir, false);
    }

    /**
     * 判断文件夹是否存在，不存在则创建新文件夹
     *
     * @param dir
     * @param doMake
     * @return
     */
    public static boolean isDirExists(File dir, boolean doMake) {
        if (dir.exists()) {
            return true;
        } else {
            if (doMake) {
                dir.mkdir();
            }
            return false;
        }
    }

    /**
     * 通过filePath获取File对象并转换为byte[]
     *
     * @param filePath
     * @return
     */
    public static byte[] file2byte(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return null;
        }
        byte[] buffer = null;
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * File对象转换为byte[]
     *
     * @param file
     * @return
     */
    public static byte[] file2byte(File file) {
        if (file == null) {
            return null;
        }
        byte[] buffer = null;
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 字节数组输出为文件
     *
     * @param bytes
     * @param filePath
     * @param fileName
     */
    public static void writeToFile(byte[] bytes, String filePath, String fileName) {
        File dir = new File(filePath);
        isDirExists(dir, true);
        File file = new File(filePath + "\\" + fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos);) {
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从byte[]数组中读取Object
     *
     * @param objBytes
     * @return
     */
    public Object getObjFromBytes(byte[] objBytes) {
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ObjectInputStream oi = null;
        try (ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ) {
            oi = new ObjectInputStream(bi);
            return oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
