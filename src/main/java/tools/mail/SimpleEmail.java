package tools.mail;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @author lihaoyu
 * @date 2019/12/31 15:53
 */
public class SimpleEmail {

    /**
     * 发件服务器地址
     */
    public static final String SMTP_SERVER = "smtp.qq.com";
    /**
     * 端口
     */
    public static final String SMTP_SERVER_PORT = "587";
    /**
     * 帐号
     */
    public static final String ACCOUNT = "825091124@qq.com";
    /**
     * 密码
     */
    public static final String PASSWORD = "ossoeayfwipdbfej"; // qq邮箱 需要以授权码为准
    /**
     * 收信人地址
     */
    public static final String TO_USER = "lihaoyu20151613@163.com";

    private static HtmlEmail getEmail() {
        HtmlEmail htmlEmail = new HtmlEmail();
        // 配置发件信息
        htmlEmail.setSmtpPort(Integer.parseInt(SMTP_SERVER_PORT));
        htmlEmail.setHostName(SMTP_SERVER);
        htmlEmail.setAuthentication(ACCOUNT, PASSWORD);
        htmlEmail.setSSLOnConnect(true);
        htmlEmail.setCharset("UTF-8");
        return htmlEmail;
    }
    public static void sendSimpleEmail(String addTo , String subject , String msg) throws EmailException {
        HtmlEmail htmlEmail = getEmail();
        htmlEmail.setFrom(ACCOUNT);
        htmlEmail.addTo(addTo);
        htmlEmail.setSubject(subject);
        htmlEmail.setHtmlMsg(msg);
        htmlEmail.send();
    }


    public static void sendAttachmentEmail(String path ,String attachmentName,String addTo , String subject , String msg) throws Exception {
        EmailAttachment attachment = new EmailAttachment();
        // 也可以发送本地文件作为附件
          attachment.setPath(path);
//        attachment.setURL(new URL(path));
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("图片描述zzz");
        // 附件名称
        attachment.setName(attachmentName);

        HtmlEmail htmlEmail = getEmail();
        // 添加附件
        htmlEmail.attach(attachment);

        htmlEmail.setFrom(ACCOUNT);
        htmlEmail.addTo(addTo);
        htmlEmail.setSubject(subject);
        htmlEmail.setHtmlMsg(msg);
        htmlEmail.send();
    }
    public static void main(String[] args) throws Exception {
//        sendSimpleEmail("TO_USER","test","this is my test");
        sendAttachmentEmail("C:\\Users\\Administrator\\Desktop\\test","folder",TO_USER,"test","haha");
    }
}
