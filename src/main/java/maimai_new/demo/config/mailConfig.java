package maimai_new.demo.config;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class mailConfig extends Authenticator {
    public static String USERNAME = "1753972608@qq.com";
    public static String PASSWORD = "gonpkriokdnhfdej";

    public mailConfig() {
    }
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, PASSWORD);
    }
}