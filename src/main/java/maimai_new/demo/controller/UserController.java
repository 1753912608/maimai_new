package maimai_new.demo.controller;


import maimai_new.demo.dao.SessionInfo;
import maimai_new.demo.dao.rand.randomUtils;
import maimai_new.demo.dao.user;
import maimai_new.demo.impl.UserServiceImpl;
import maimai_new.demo.impl.aliyunUtils.AliYun;
import maimai_new.demo.impl.mailUtils.mailDemoUtils;
import maimai_new.demo.impl.redisUtils.RedisServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class UserController{


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RedisServiceImpl redisService;

    @Autowired
    private mailDemoUtils mailDemo;

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
            redisService.saveUserInfo(phone,userService.getMyUserInfo(phone));
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
        return redisService.getUserInfo(user_id);
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
        if(userService.updateBasicInfo(realName,sex,company,position,work_direction,user_id)==1){
            redisService.saveUserInfo(user_id,userService.getMyUserInfo(user_id));
        }else{
            return 0;
        }
        return 1;
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
        if(userService.updateWorkTag(workTag,user_id)==1){
            redisService.saveUserInfo(user_id,userService.getMyUserInfo(user_id));
        }else{
            return 0;
        }
        return 1;
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
        if(userService.updateJobInfo(education,expect_Salary,user_id)==1){
            redisService.saveUserInfo(user_id,userService.getMyUserInfo(user_id));
        }else{
            return 0;
        }
        return 1;
    }




    /**
     *
     * @param rand_uuid
     * @param mail
     * @return
     * 绑定邮箱发送邮箱验证码
     */
    @ResponseBody
    @RequestMapping("/sendMailCode")
    public int sendMailCode(String rand_uuid,
                            String mail,
                            HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);
        try{
            String code=randomUtils.getPhoneCode();
            mailDemo.sendMailCode(mail,user_id,code);
            redisService.savePhoneCode(rand_uuid,code);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }



    /**
     *
     * @param rand_uuid
     * @param mailCode
     * @param mail
     * @param workBase
     * @param request
     * @return
     * 校验邮箱验证码
     */
    @ResponseBody
    @RequestMapping("/checkMailCode")
    public int checkMailCode(String rand_uuid,
                             String mailCode,
                             String mail,
                             String workBase,
                             HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);
        if(!redisService.getPhoneCode(rand_uuid).equals(mailCode)){
            return 0;
        }else{
            userService.updateContactInfo(mail,workBase,user_id);
        }
        return 1;
    }




    /**
     *
     * @param resume
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "uploadResume",method = RequestMethod.POST)
    public int uploadResume(@RequestParam("resume")MultipartFile resume,
                            @RequestParam("resume_name")String resume_name,
                            @RequestParam("resume_upload_time")String resume_upload_time,
                            HttpServletRequest request)
            throws IOException
    {
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);
        String fileSrc="";
        fileSrc="file/"+resume.getOriginalFilename();
        FileUtils.copyInputStreamToFile(resume.getInputStream(),new File("src/main/resources/static/"+fileSrc));
        if(userService.uploadResume(fileSrc,resume_name,resume_upload_time,user_id)==1){
            redisService.saveUserInfo(user_id,userService.getMyUserInfo(user_id));
        }else{
            return 0;
        }
        return 1;
    }




    /**
     *
     * @param request
     * @return
     * 将用户上传的简历附件删除
     */
    @ResponseBody
    @RequestMapping("/removeResume")
    public int removeResume(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String user_id=(String)session.getAttribute(SessionInfo.USER_ID);

        return 1;
    }

}
