package com.jy.common.utils;

import com.aliyun.oss.event.ProgressEvent;
import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.event.ProgressListener;
import com.jy.common.redis.JedisClient;

/**
 * @Description :
 * @Author : cheng fei
 * @Date : 2019/1/18 09:16
 */
public class PutObjectProgressListener implements ProgressListener {

    /**
     * OSS进度条-上传状态前缀
     */
    public static final  String PROGRESS_BAR_STATUS = "PROGRESS_BAR_STATUS:";
    /**
     * OSS进度条-文件大小前缀
     */
    public static final  String PROGRESS_BAR_TOTAL = "PROGRESS_BAR_TOTAL:";
    /**
     * 上传进度
     */
    public static final  String PROGRESS_BAR_PERCENT = "PROGRESS_BAR_PERCENT:";
    /**
     * 已上传字节数
     */
    public static final  String PROGRESS_BAR_UPLOAD_SIZE = "PROGRESS_BAR_UPLOAD_SIZE:";

    /**
     * 是否上传完成
     */
    public static final  String PROGRESS_BAR_SUCCEED = "PROGRESS_BAR_SUCCEED:";

    private long bytesWritten = 0;
    private long totalBytes = -1;
    private boolean succeed = false;

    private JedisClient jedisClient;

    private Long accountID;

    private String redisPassword;

    private boolean insertRedis_1 = true;
    private boolean insertRedis_2 = true;
    private boolean insertRedis_3 = true;
    private boolean insertRedis_4 = true;


    public PutObjectProgressListener(JedisClient jedisClient,String redisPassword, Long accountID){
        this.jedisClient = jedisClient;
        this.redisPassword = redisPassword;
        this.accountID = accountID;
    }

    @Override
    public void progressChanged(ProgressEvent progressEvent) {
        long bytes = progressEvent.getBytes();
        ProgressEventType eventType = progressEvent.getEventType();
        switch (eventType) {
            case TRANSFER_STARTED_EVENT:
                if (this.insertRedis_1 && !jedisClient.exists(PROGRESS_BAR_STATUS + accountID, redisPassword)){
                    this.insertRedis_1 = false;
                    jedisClient.set(PROGRESS_BAR_STATUS + accountID, "开始上传文件...", redisPassword);
                }
                break;
            case REQUEST_CONTENT_LENGTH_EVENT:
                if (this.insertRedis_2 && !jedisClient.exists(PROGRESS_BAR_TOTAL + accountID, redisPassword)){
                    this.insertRedis_2 = false;
                    this.totalBytes = bytes;
                    jedisClient.set(PROGRESS_BAR_STATUS + accountID, "开始上传文件...", redisPassword);
                    jedisClient.set(PROGRESS_BAR_TOTAL + accountID, this.totalBytes + "", redisPassword);
                }
                break;
            case REQUEST_BYTE_TRANSFER_EVENT:
                this.bytesWritten += bytes;
                if (this.totalBytes != -1) {
                    int percent = (int)(this.bytesWritten * 100.0 / this.totalBytes);
                    jedisClient.set(PROGRESS_BAR_STATUS + accountID, "文件上传中...", redisPassword);
                    jedisClient.set(PROGRESS_BAR_TOTAL + accountID, this.totalBytes + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_PERCENT + accountID, percent + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_UPLOAD_SIZE + accountID, this.bytesWritten + "", redisPassword);
                } else {
                    jedisClient.set(PROGRESS_BAR_STATUS + accountID, "文件上传中...", redisPassword);
                    jedisClient.set(PROGRESS_BAR_UPLOAD_SIZE + accountID, this.bytesWritten + "", redisPassword);
                }
                break;
            case TRANSFER_COMPLETED_EVENT:
                if (this.insertRedis_3 && !jedisClient.exists(PROGRESS_BAR_SUCCEED + accountID, redisPassword)){
                    this.insertRedis_3 = false;
                    this.succeed = true;
                    jedisClient.set(PROGRESS_BAR_STATUS + accountID, "文件上传成功!", redisPassword);
                    jedisClient.set(PROGRESS_BAR_TOTAL + accountID, this.totalBytes + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_PERCENT + accountID, 100 + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_UPLOAD_SIZE + accountID, this.bytesWritten + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_SUCCEED + accountID, true + "", redisPassword);
                }
                break;
            case TRANSFER_FAILED_EVENT:
                if (this.insertRedis_4 && !jedisClient.exists(PROGRESS_BAR_SUCCEED + accountID, redisPassword)){
                    this.insertRedis_4 = false;
                    jedisClient.set(PROGRESS_BAR_STATUS + accountID, "文件上传失败!", redisPassword);
                    jedisClient.set(PROGRESS_BAR_TOTAL + accountID, this.totalBytes + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_PERCENT + accountID, 100 + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_UPLOAD_SIZE + accountID, this.bytesWritten + "", redisPassword);
                    jedisClient.set(PROGRESS_BAR_SUCCEED + accountID, false + "", redisPassword);
                }
                break;
            default:
                break;
        }
    }
}
