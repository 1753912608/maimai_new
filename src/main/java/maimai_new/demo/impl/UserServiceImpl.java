package maimai_new.demo.impl;

import maimai_new.demo.dao.user;
import maimai_new.demo.mapper.UserMapper;
import maimai_new.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;


    @Override
    public String isUserExist(String phone) {
        return userMapper.isUserExist(phone);
    }

    @Override
    public void registerUser(String phone) {
        userMapper.registerUser(phone);
    }

    @Override
    public int updateBasicInfo(String realName, String sex, String company, String position, String work_direction,String user_id) {
        try{
            userMapper.updateBasicInfo(realName,sex,company,position,work_direction,user_id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public user getMyUserInfo(String user_id) {
        return userMapper.getMyUserInfo(user_id);
    }

    @Override
    public int updateWorkTag(String workTag, String user_id) {
        try{
            userMapper.updateWorkTag(workTag,user_id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int updateJobInfo(String education, String expect_Salary, String user_id) {
        try{
            userMapper.updateJobInfo(education,expect_Salary,user_id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int updateContactInfo(String mail, String workBase, String user_id) {
        try{
            userMapper.updateContactInfo(mail,workBase,user_id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int uploadResume(String user_resume_url, String resume_name, String resume_upload_time, String user_id) {
        try{
            userMapper.uploadResume(user_resume_url,resume_name,resume_upload_time,user_id);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
