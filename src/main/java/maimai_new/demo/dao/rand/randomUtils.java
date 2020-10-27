package maimai_new.demo.dao.rand;

import java.util.Random;

public class randomUtils {


    /**
     *
     * @return
     * 随机产生4位数的手机验证码
     */
    public static String getPhoneCode(){
        StringBuffer buffer=new StringBuffer("");
        Random rand=new Random();
        for(int i=0;i<4;i++){
            buffer.append(rand.nextInt(10));
        }
        return buffer.toString();
    }

}
