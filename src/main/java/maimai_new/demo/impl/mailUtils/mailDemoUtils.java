package maimai_new.demo.impl.mailUtils;

import maimai_new.demo.config.mailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class mailDemoUtils {

    @Autowired
    private MailOperation mailOperation;

    private String user=mailConfig.USERNAME;
    private String password=mailConfig.PASSWORD;
    private String host="smtp.qq.com";
    private String from="1753972608@qq.com";
    private String subject="maimai职场社交平台";

    public void sendMailCode(String to,String user_id,String rand_code)
    {
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                + "<div style='width:950px;font-family:arial;'>亲爱的"+user_id+"用户您好,欢迎绑定邮箱，您的邮箱验证码为"+rand_code+"有效时间为5分钟"+"<br/><h2 style='color:green'></h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>茗少集团科技有限公司</div>"
                +"</div>");
        send(user,password,host,from,to,sb);
    }


    private void send(String user,String password,String host,String from,String to,StringBuffer sb) {
        try {
            String res = this.mailOperation.sendMail(user, password, host, from, to,
                    subject, sb.toString());
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
