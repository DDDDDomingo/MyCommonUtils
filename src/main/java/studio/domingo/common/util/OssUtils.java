package studio.domingo.common.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.LogUtils;
import com.aliyun.oss.model.ObjectMetadata;
import org.apache.commons.lang.time.DateUtils;

import java.io.InputStream;
import java.util.Date;

/**
 * @ClassName: OssUtils
 * @Description: [官方文档]https://help.aliyun.com/document_detail/31827.html
 */
public class OssUtils {

    //OSS 的地址
    private final static String OSS_END_POINT = "endPoint";
    //OSS 的key值
    private final static String OSS_ACCESS_KEY_ID = "OSSKEY";
    //OSS 的secret值
    private final static String OSS_ACCESS_KEY_SECRET = "OSSSECRET";
    //OSS 的bucket名字
    private final static String OSS_BUCKET_NAME = "BUCKET_NAME";
    //设置URL过期时间为10年
    private final static Date OSS_URL_EXPIRATION = DateUtils.addDays(new Date(), 365 * 10);

    private static volatile OSSClient ossClient;

    private OssUtils() {

    }

    private static OSSClient initOssClient() {
        if (ossClient == null) {
            synchronized (OSSClient.class) {
                if (ossClient == null) {
                    ossClient = new OSSClient(OSS_END_POINT, OSS_ACCESS_KEY_ID, OSS_ACCESS_KEY_SECRET, OSS_BUCKET_NAME);
                }
            }
        }
        return ossClient;
    }

    public static boolean uploadFile(String fileKey, InputStream content){
        if(StringUtils.isEmpty(fileKey)){
            return false;
        }
        try {
            initOssClient();
            ObjectMetadata meta = new ObjectMetadata();
            ossClient.putObject(OSS_BUCKET_NAME, fileKey, content, meta);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String uploadImg(String fileName, InputStream content){
        if(StringUtils.isEmpty(fileName)){
            return null;
        }
        String file = "images/" + fileName.substring(0, fileName.indexOf(".")) + "/" + fileName;
        uploadFile(file, content);
        return null;
    }
}
