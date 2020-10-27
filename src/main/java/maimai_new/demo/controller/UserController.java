package maimai_new.demo.controller;


import maimai_new.demo.dao.rand.randomUtils;
import maimai_new.demo.impl.UserServiceImpl;
import maimai_new.demo.impl.aliyunUtils.AliYun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController{


    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("/sendPhoneCode")
    public int sendPhoneCode(String phone,String randUserId){
        if(userService.isUserExist(phone)==null){
            userService.registerUser(phone);
        }
        try {
            String code=randomUtils.getPhoneCode();
            AliYun.sendCode(phone, code);
            System.out.println("验证码为:"+code);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }



}
