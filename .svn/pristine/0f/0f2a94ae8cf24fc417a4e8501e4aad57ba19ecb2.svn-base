package com.jy.common.utils.sendMail;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MailSSLSocketFactory;
/**
 * 

 * @ClassName: SendEmailUtil

 * @Description: 发送邮件工具类不带附件

 * @author: chenye

 * @date: 2018.8.3
 */

public class SendEmailUtil {
    /**
     * 
     * 
     * @Title: sendEmail
     * 
     * @Description: 发送邮件工具类方法
     * 
     * @param server 邮件服务器
     * 
     * @param port 端口号
     * 
     * @param sendEmail
     *            发件人地址
     * @param sendEmailPwd
     *            授权码代替密码（更安全） 授权码的获取：进入个人邮箱，点击设置–>账户， SMTP服务选项 默认情况下这个选项是不开启的。
     *            点击开启腾讯会进行身份验证，身份验证通过以后，会收到一个用于使用SMTP的16位口令，
     *            验证身份的过程中把收到的口令保存下来，因为后面要使用SMTP功能必须要用到这个口令。
     * @param title
     *            邮件标题
     * @param content
     *            邮件内容
     * @param toEmilAddress
     *            收件人地址
     * @throws Exception
     * 
     * @return: void
     */
    public static void sendEmail(String server,Integer port, String sendEmail, String sendEmailPwd, String title, String content,
    		List<File> FileList,String[] toEmilAddress) throws Exception {
        Properties props = new Properties();
        // 开启debug调试，以便在控制台查看
        props.setProperty("mail.debug", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");

        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);
        Message msg = new MimeMessage(session);
        // 发送的邮箱地址
        msg.setFrom(new InternetAddress(sendEmail));
        // 设置标题
        msg.setSubject(title);
        
     // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        Multipart multipart = new MimeMultipart();

        // 添加邮件正文
        if (content != null) {
        	BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(content, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);
        }
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setContent("", "text/html;charset=UTF-8");
        multipart.addBodyPart(contentPart);

        // 添加附件的内容
        if (FileList != null) {
        	for (int i = 0; i < FileList.size(); i++) {
        		File file = FileList.get(i);
        		BodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(file);
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                attachmentBodyPart.setFileName(MimeUtility.encodeWord(file.getName()));
                multipart.addBodyPart(attachmentBodyPart);
			}
            
        }

        // 将multipart对象放到message中
        msg.setContent(multipart);
        // 保存邮件
        msg.saveChanges();
        
        Transport transport = session.getTransport();
        // 设置服务器 端口以及账号和密码
        transport.connect(server,port, sendEmail, sendEmailPwd);
        // 发送到的邮箱地址
        transport.sendMessage(msg, getAddress(toEmilAddress));

        if(transport!=null){
             try {
                 transport.close();
             } catch (MessagingException e) {
                 e.printStackTrace();
             }
         }
    }

     /**
     * 

     * @Title: getAddress

     * @Description: 遍历收件人信息

     * @param emilAddress
     * @return
     * @throws Exception

     * @return: Address[]
     */
    private static Address[] getAddress(String[] emilAddress) throws Exception {
        Address[] address = new Address[emilAddress.length];
        for (int i = 0; i < address.length; i++) {
            address[i] = new InternetAddress(emilAddress[i]);
        }
        return address;
    }

    /**
     * 
     * 
     * @Title: main
     * 
     * @Description: 测试
     * 
     * @param args
     * @throws Exception
     * 
     * @return: void
     */
    public static void main(String[] args) throws Exception {
        /**
         * * @param sendEmail 发件人地址
         * 
         * @param sendEmailPwd
         *            授权码代替密码 //使用第三方登录必须使用授权码,不然会报AuthenticationFailedException: 535 Error
         * @param title
         *            邮件标题
         * @param content
         *            邮件内容
         * @param toEmilAddress
         *            收件人地址
         */
    	File attached = new File("path");
    	List<File> FileList = new ArrayList<File>();
    	FileList.add(attached);
        SendEmailUtil.sendEmail("邮箱服务器",465,"发送者邮箱", "密码", "标题", "内容",FileList,
                new String[] { "xxxx@qq.com"});
    }
}

