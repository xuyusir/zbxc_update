package com.jy.common.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.*;
import com.jy.common.redis.JedisClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description : 阿里云OSS工具类
 * @Author : cheng fei
 * @Date : 2018/12/24 09:43
 */
public class AliyunOSSClientUtil {




    /**
     * log日志
     */
    private static Logger logger = Logger.getLogger(AliyunOSSClientUtil.class);

    /**
     * 阿里云API的内网域名
     */
    private String intranetEndpoint;

    /**
     * 阿里云API的外网域名
     */
    private String outerNetEndpoint;
    /**
     * 阿里云API的密钥Access Key ID
     */
    private String accessKeyID;
    /**
     * 阿里云API的密钥Access Key Secret
     */
    private String accessKeySecret;
    /**
     * 阿里云API的bucket名称
     */
    private String bucketName;

    /**
     * url有效时间
     */
    private long expiration;

    /**
     * 阿里云外网连接
     */
    private OSSClient ossClientByOuterNet;

    /**
     * 阿里云内网连接
     */
    private OSSClient ossClientByIntranet;

    /**
     * 当前环境是否能连接OSS内网
     */
    private boolean clientIntranetEndpoint;

    /**
     * 是否使用nginx反向代理
     */
    private boolean useNginx;

    /**
     * nginx反向代理地址
     */
    private String nginxUrl;

    /**
     * 视频点播服务接入区域
     */
    private String regionId;

    private JedisClient jedisClient;

    private String redisPassword;

    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    public JedisClient getJedisClient() {
        return jedisClient;
    }

    public void setJedisClient(JedisClient jedisClient) {
        this.jedisClient = jedisClient;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public boolean isUseNginx() {
        return useNginx;
    }

    public void setUseNginx(boolean useNginx) {
        this.useNginx = useNginx;
    }

    public OSSClient getOssClientByIntranet() {
        return ossClientByIntranet;
    }

    public void setOssClientByIntranet(OSSClient ossClientByIntranet) {
        this.ossClientByIntranet = ossClientByIntranet;
    }

    public String getNginxUrl() {
        return nginxUrl;
    }

    public void setNginxUrl(String nginxUrl) {
        this.nginxUrl = nginxUrl;
    }

    public boolean isClientIntranetEndpoint() {
        return clientIntranetEndpoint;
    }

    public void setClientIntranetEndpoint(boolean clientIntranetEndpoint) {
        this.clientIntranetEndpoint = clientIntranetEndpoint;
    }

    public OSSClient getOssClientByOuterNet() {
        return ossClientByOuterNet;
    }

    public void setOssClientByOuterNet(OSSClient ossClientByOuterNet) {
        this.ossClientByOuterNet = ossClientByOuterNet;
    }

    public String getIntranetEndpoint() {
        return intranetEndpoint;
    }

    public void setIntranetEndpoint(String intranetEndpoint) {
        this.intranetEndpoint = intranetEndpoint;
    }

    public String getOuterNetEndpoint() {
        return outerNetEndpoint;
    }

    public void setOuterNetEndpoint(String outerNetEndpoint) {
        this.outerNetEndpoint = outerNetEndpoint;
    }

    public String getAccessKeyID() {
        return accessKeyID;
    }

    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 17:18
     * 描述 : 获取阿里云OSS客户端连接对象
     *
     * @return
     */
    public OSSClient createOSSClient() {
        if (clientIntranetEndpoint){
            if (this.ossClientByIntranet == null) {
                this.ossClientByIntranet = new OSSClient(intranetEndpoint, accessKeyID, accessKeySecret);
            }
            return this.ossClientByIntranet;
        }else {
            if (this.ossClientByOuterNet == null) {
                this.ossClientByOuterNet = new OSSClient(outerNetEndpoint, accessKeyID, accessKeySecret);
            }
            return this.ossClientByOuterNet;
        }
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/10 15:46
     * 描述 : 获取阿里云OSS客户端外网连接对象
     * @return
     */
    public OSSClient createOSSClientByOuterNet() {
        if (this.ossClientByOuterNet == null) {
            this.ossClientByOuterNet = new OSSClient(outerNetEndpoint, accessKeyID, accessKeySecret);
        }
        return this.ossClientByOuterNet;
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/10 15:46
     * 描述 : 获取阿里云OSS内网连接对象
     * @return
     */
    public OSSClient createOSSClientByIntranet() {
        if (this.ossClientByIntranet == null) {
            this.ossClientByIntranet = new OSSClient(intranetEndpoint, accessKeyID, accessKeySecret);
        }
        return this.ossClientByIntranet;
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 17:43
     * 描述 : 关闭OSS连接
     */
    public void closeOSSClient() {

        if (this.ossClientByOuterNet != null) {
            this.ossClientByOuterNet.shutdown();
            this.ossClientByOuterNet = null;
        }

        if (this.ossClientByIntranet != null) {
            this.ossClientByIntranet.shutdown();
            this.ossClientByIntranet = null;
        }


    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 17:19
     * 描述 : 创建存储空间
     *
     * @param bucketName
     * @return
     */
    public String createBucketName(String bucketName) {

        // 创建存储空间
        Bucket bucket = createOSSClient().createBucket(bucketName);
        logger.info("创建存储空间成功");
        return bucket.getName();
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 17:44
     * 描述 : 删除存储空间buckName
     *
     * @param bucketName
     */
    public void deleteBucket(String bucketName) {
        createOSSClient().deleteBucket(bucketName);
        logger.info("删除" + bucketName + "Bucket成功");
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 16:50
     * 描述 : 创建文件唯一名称
     *
     * @return
     */
    private static String createFileName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 创建模拟文件夹
     *
     * @param folder
     * @return
     */
    public String createFolder(String folder) {
        // 文件夹名
        final String keySuffixWithSlash = folder;
        // 判断文件夹是否存在，不存在则创建
        if (!createOSSClient().doesObjectExist(bucketName, keySuffixWithSlash)) {
            // 创建文件夹
            createOSSClient().putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            logger.info("创建文件夹成功");
            // 得到文件夹名
            OSSObject object = createOSSClient().getObject(bucketName, keySuffixWithSlash);
            String fileDir = object.getKey();
            return fileDir;
        }
        return keySuffixWithSlash;
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 17:12
     * 描述 : 删除文件
     *
     * @param folder
     * @param fileName
     */
    public void deleteFile(String folder, String fileName) {
        createOSSClient().deleteObject(bucketName, folder + fileName);
        logger.info("删除" + bucketName + "下的文件" + folder + fileName + "成功");
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 23:37
     * 描述 : 删除文件
     *
     * @param fullFolder 文件全路径
     */
    public void deleteFile(String fullFolder) {
        //判断是否是视频
        if (!fullFolder.contains("/")){
            deleteVideo(fullFolder);
            logger.info("删除视频成功,视频ID为:" + fullFolder);
        }else {
            createOSSClient().deleteObject(bucketName, fullFolder);
            logger.info("删除" + bucketName + "下的文件" + fullFolder + "成功");
        }
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 17:52
     * 描述 : 拷贝文件
     *
     * @param sourceFileName
     * @param fileName
     */
    public void copyFile(String sourceFolder, String sourceFileName, String folder, String fileName) {
        createFolder(folder);
        createOSSClient().copyObject(bucketName, sourceFolder + sourceFileName, bucketName, folder + fileName);
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 16:55
     * 描述 : 上传文件
     *
     * @param folder   文件夹路径
     * @param fileName 文件名称
     * @param fileSize 文件大小
     * @param is       文件输入流
     * @return
     */
    public String uploadFile(String folder, String fileName, Long fileSize, InputStream is, Long accountID) {
        try {
            String newFileName = createFileName() + fileName.substring(fileName.lastIndexOf("."));
            logger.info("上传到路径" + folder + fileName);
            // 创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            // 上传的文件的长度
            metadata.setContentLength(is.available());
            // 指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            // 指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
//            metadata.setContentType(getContentType(fileName));
            metadata.setContentType("multipart/form-data");
            // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename=" + fileName);
            // 上传文件 (上传文件流的形式)

            //设置进度条
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folder + newFileName, is, metadata).<PutObjectRequest>withProgressListener(new PutObjectProgressListener(this.jedisClient, redisPassword, accountID));

            PutObjectResult putResult = createOSSClient().putObject(putObjectRequest);
            // 解析结果
            String eTag = putResult.getETag();
            if (StringUtils.isBlank(eTag)) {
                return null;
            }
            return folder + newFileName;

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/17 23:14
     * 描述 : 创建视频分类
     * @param parentID
     * @param cateName
     * @return
     * @throws Exception
     */
    public AddCategoryResponse addCategory(Long parentID, String cateName) throws Exception {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        AddCategoryRequest request = new AddCategoryRequest();
        // 父分类ID，若不填，则默认生成一级分类，根节点分类ID为-1
        if (parentID == null){
            parentID = -1L;
        }
        request.setParentId(parentID);
        // 分类名称
        request.setCateName(cateName);
        return client.getAcsResponse(request);
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/20 15:20
     * 描述 : 删除视频分类
     * @param cateID
     * @return
     * @throws Exception
     */
    public DeleteCategoryResponse deleteCategory(Long cateID) throws Exception {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        DeleteCategoryRequest request = new DeleteCategoryRequest();
        // 请设置待删除分类ID
        request.setCateId(cateID);
        return client.getAcsResponse(request);
    }




    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/11 17:33
     * 描述 : 上传视频接口
     * @param title
     * @param fileName
     * @param inputStream
     * @return
     */
    public String uploadVideo(String title, String fileName, InputStream inputStream) {
        UploadStreamRequest request = new UploadStreamRequest(accessKeyID, accessKeySecret, title, fileName, inputStream);
        /* 是否使用默认水印(可选)，指定模板组ID时，根据模板组配置确定是否使用默认水印*/
        //request.setShowWaterMark(true);
        /* 设置上传完成后的回调URL(可选)，建议通过点播控制台配置消息监听事件，参见文档 https://help.aliyun.com/document_detail/57029.html */
        //request.setCallback("http://callback.sample.com");
        /* 自定义消息回调设置，参数说明参考文档 https://help.aliyun.com/document_detail/86952.html#UserData */
        //request.setUserData(""{\"Extend\":{\"test\":\"www\",\"localId\":\"xxxx\"},\"MessageCallback\":{\"CallbackURL\":\"http://test.test.com\"}}"");
        /* 视频分类ID(可选) */
        //request.setCateId(0);
        /* 视频标签,多个用逗号分隔(可选) */
        //request.setTags("标签1,标签2");
        /* 视频描述(可选) */
        //request.setDescription("视频描述");
        /* 封面图片(可选) */
        //request.setCoverURL("http://cover.sample.com/sample.jpg");
        /* 模板组ID(可选) */
        //request.setTemplateGroupId("8c4792cbc8694e7084fd5330e56a33d");
        /* 存储区域(可选) */
        //request.setStorageLocation("outin-6c3a56b5fead11e8a30800163e1a3b4a.oss-cn-shanghai.aliyuncs.com");
        /* 开启默认上传进度回调 */
        // request.setPrintProgress(true);
        /* 设置自定义上传进度回调 (必须继承 VoDProgressListener) */
        // request.setProgressListener(new PutObjectProgressListener());
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        if (response.isSuccess()) {
            return response.getVideoId();
        } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            return "";
        }
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/14 22:08
     * 描述 : 下载视频
     * @param videoID 视频ID
     */
    public InputStream downLoadVideo(String videoID){
        try {
            //获取废品文件地址
            DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
            DefaultAcsClient client = new DefaultAcsClient(profile);
            GetMezzanineInfoRequest request = new GetMezzanineInfoRequest();
            request.setVideoId(videoID);
            request.setAuthTimeout(3600L);
            request.setOutputType("oss");
            GetMezzanineInfoResponse acsResponse = client.getAcsResponse(request);

            //创建http请求获取文件输入流
            CloseableHttpClient httpclient = HttpClients.createDefault();
            String resultString = "";
            CloseableHttpResponse httpResponse = null;

            // 创建uri
            URIBuilder builder = new URIBuilder(acsResponse.getMezzanine().getFileURL());
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            httpResponse = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                return  httpResponse.getEntity().getContent();
            }
            return null;
        }catch (Exception e){
            return null;
        }

    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/14 22:07
     * 描述 : 删除视频
     * @param videoID 视频ID
     * @return
     */
    public boolean deleteVideo(String videoID)  {
        // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        DeleteVideoRequest request = new DeleteVideoRequest();
        //支持传入多个视频ID，多个用逗号分隔
        request.setVideoIds(videoID);
        try {
            DeleteVideoResponse acsResponse = client.getAcsResponse(request);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }


    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/25 1:01
     * 描述 : 下载文件
     *
     * @param fileFullPath
     * @return
     */
    public InputStream downLoadFile(String fileFullPath) {
        //判断是否是视频文件
        if (fileFullPath.contains("/")){
            //判断当前OSS连接网络环境
            if (clientIntranetEndpoint) {
                OSSObject ossObject = createOSSClient().getObject(bucketName, fileFullPath);
                return ossObject.getObjectContent();
            } else {
                OSSObject ossObject = createOSSClientByOuterNet().getObject(bucketName, fileFullPath);
                return ossObject.getObjectContent();
            }
        }else {
            return downLoadVideo(fileFullPath);
        }
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public String getContentType(String fileName) {
        // 文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        /*if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }*/
        if (".mp4".equalsIgnoreCase(fileExtension)) {
            return "video/mp4";
        }
        // 默认返回类型
        return "multipart/form-data";
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/24 21:30
     * 描述 : 获得url链接
     *
     * @param fileName
     * @return
     */
    public String getUrl(String fileName) {
        //判断是否是是视频
        if (!fileName.contains("/")){
            return fileName;
        }else {
            //不是视频
            if (useNginx){
                // 设置URL过期时间
                Date expirationDate = new Date(System.currentTimeMillis() + expiration);
                // 生成URL
                URL url = createOSSClientByIntranet().generatePresignedUrl(bucketName, fileName, expirationDate);
                if (url != null) {
                    String path = url.toString();
                    path =  nginxUrl + path.substring(path.indexOf("/",8),path.length());
                    return path;
                }
                return "获网址路径出错";
            }else {
                // 设置URL过期时间
                Date expirationDate = new Date(System.currentTimeMillis() + expiration);
                // 生成URL
                URL url = createOSSClientByOuterNet().generatePresignedUrl(bucketName, fileName, expirationDate);

                if (url != null) {
                    return url.toString();
                }
                return "获网址路径出错";
            }
        }

    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/17 16:03
     * 描述 : 获取视频基本信息
     * @param videoId
     * @return
     * @throws Exception
     */
    public GetVideoInfoResponse getVideoInfo(String videoId) throws Exception {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        GetVideoInfoRequest request = new GetVideoInfoRequest();
        request.setVideoId(videoId);
        return client.getAcsResponse(request);
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/17 11:10
     * 描述 : 获取视频上传凭证
     * @param videoTitle 视频标题
     * @param videoName 视频名称
     * @param cateId 视频分类ID
     * @return
     * @throws Exception
     */
    public CreateUploadVideoResponse createUploadVideo(String videoTitle, String videoName, Long cateId, String templateGroupID) throws Exception {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle(videoTitle);
        request.setFileName(videoName);
        request.setCateId(cateId);
        request.setTemplateGroupId(templateGroupID);
        return client.getAcsResponse(request);
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/17 13:38
     * 描述 : 刷新视频上传凭证
     * @param videoId
     * @return
     * @throws Exception
     */
    public RefreshUploadVideoResponse refreshUploadVideo(String videoId) throws Exception {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
        request.setVideoId(videoId);
        return client.getAcsResponse(request);
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/20 23:26
     * 描述 : 获取视频播放凭证
     * @param videoId
     * @return
     * @throws Exception
     */
    public GetVideoPlayAuthResponse getVideoPlayAuth(String videoId) throws Exception {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(videoId);
        return client.getAcsResponse(request);
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/11 16:57
     * 描述 : 获取视频播放列表
     * @param videoID
     * @return
     */
    public String getVideoUrl(String videoID) throws ClientException {
        // 点播服务所在的地域ID，中国大陆地域请填cn-shanghai
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(videoID);
        request.setOutputType("cdn");
        // 传入视频ID
        GetPlayInfoResponse response = client.getAcsResponse(request);
        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        // 播放地址
        if (playInfoList == null || playInfoList.size() == 0){
            return null;
        }else {
            return playInfoList.get(0).getPlayURL();
        }
    }

    private GetPlayInfoResponse getVideoInfo(DefaultAcsClient client, String videoId) {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(videoId);
        request.setOutputType("cdn");
        GetPlayInfoResponse response = null;
        try {
            response = client.getAcsResponse(request);
        }  catch (ServerException e) {
            throw new RuntimeException("GetPlayInfoRequest Server failed");
        } catch (ClientException e) {
            throw new RuntimeException("GetPlayInfoRequest Client failed");
        }
        return response;
    }

    public static void main(String[] args) throws Exception {
        AliyunOSSClientUtil aliyunOSSClientUtil = new AliyunOSSClientUtil();
        aliyunOSSClientUtil.setIntranetEndpoint("http://oss-cn-shenzhen-internal.aliyuncs.com");
        aliyunOSSClientUtil.setOuterNetEndpoint("http://oss-cn-shenzhen.aliyuncs.com");
        aliyunOSSClientUtil.setAccessKeyID("LTAIGVHgaxoZo93C");
        aliyunOSSClientUtil.setAccessKeySecret("Ka1k8ijASskYyuGuYrVsfViUbyGZTB");
        aliyunOSSClientUtil.setBucketName("zbxc");
        aliyunOSSClientUtil.setClientIntranetEndpoint(true);
        aliyunOSSClientUtil.setExpiration(86400000l);
        aliyunOSSClientUtil.setRegionId("cn-shanghai");
        aliyunOSSClientUtil.setUseNginx(true);
        aliyunOSSClientUtil.setNginxUrl("http://119.23.95.61:8888");
//        String videoUrl = aliyunOSSClientUtil.getVideoUrl("7b2fd4e68b6b4149884f3ec868505e9a");
//        System.err.println(videoUrl);

        aliyunOSSClientUtil.getUrl("图片库/2018/7199279f6a03457a8a5ec09d629fc7ed.jpg");

    }

}
