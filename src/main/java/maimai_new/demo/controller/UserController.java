package maimai_new.demo.controller;


import maimai_new.demo.dao.SessionInfo;
import maimai_new.demo.dao.rand.randomUtils;
import maimai_new.demo.dao.user;
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



    /**
     *
     * @param request
     * @return
     * 获取当前用户的个人信息
     */
    @ResponseBody
    @RequestMapping("/getMyUserInfo")
    public user getMyUserInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);
        return userService.getMyUserInfo(user_id);
    }




    /**
     *
     * @param realName
     * @param sex
     * @param company
     * @param position
     * @param work_direction
     * @param request
     * @return
     * 更新用户中心的基本信息
     */
    @ResponseBody
    @RequestMapping("/updateBasicInfo")
    public int updateBasicInfo(String realName,
                               String sex,
                               String company,
                               String position,
                               String work_direction,
                               HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);
        return userService.updateBasicInfo(realName,sex,company,position,work_direction,user_id);
    }




    /**
     *
     * @param workTag
     * @param request
     * @return
     * 更新用户的职业标签
     */
    @ResponseBody
    @RequestMapping("/updateWorkTag")
    public int updateWorkTag(String workTag,
                             HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);
        return userService.updateWorkTag(workTag,user_id);
    }




    /**
     *
     * @param education
     * @param expect_Salary
     * @param request
     * @return
     * 更新用户求职信息
     */
    @ResponseBody
    @RequestMapping("/updateJobInfo")
    public int updateJobInfo(String education,
                             String expect_Salary,
                             HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);
        return userService.updateJobInfo(education,expect_Salary,user_id);
    }





}
