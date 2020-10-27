package maimai_new.demo.controller;


import maimai_new.demo.dao.SessionInfo;
import maimai_new.demo.dao.rand.randomUtils;
import maimai_new.demo.impl.UserServiceImpl;
import maimai_new.demo.impl.aliyunUtils.AliYun;
import maimai_new.demo.impl.redisUtils.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController{


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RedisServiceImpl redisService;


    /**
     *
     * @param phone
     * @param rand_uuid
     * @return
     * 发送手机验证码
     */
    @ResponseBody
    @RequestMapping("/sendPhoneCode")
    public int sendPhoneCode(String phone,String rand_uuid){
        if(userService.isUserExist(phone)==null){
            userService.registerUser(phone);
        }
        try {
            String code=randomUtils.getPhoneCode();
            //AliYun.sendCode(phone, code);
            redisService.savePhoneCode(rand_uuid,code);
            System.out.println("验证码为:"+code);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    /**
     *
     * @param phone
     * @param rand_uuid
     * @param code
     * @param request
     * @return
     * 校验验证码
     */
    @ResponseBody
    @RequestMapping("/checkPhoneCode")
    public int checkPhoneCode(String phone,
                              String rand_uuid,
                              String code,
                              HttpServletRequest request){
        if(redisService.getPhoneCode(rand_uuid).equals(code)){
            HttpSession session=request.getSession();
            session.setAttribute(SessionInfo.USER_ID,phone);
            return 1;
        }
        return 0;
    }



    /**
     *
     * @param request
     * 退出登录
     */
    @ResponseBody
    @RequestMapping("/logOut")
    public int logOut(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute(SessionInfo.USER_ID);
        return 1;
    }
}
