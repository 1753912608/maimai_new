package maimai_new.demo.service;

import maimai_new.demo.dao.user;

public interface UserService {


    /**
     *
     * @param phone
     * @return
     * 判断用户是否存在
     */
    String isUserExist(String phone);



    /**
     *
     * @param phone
     * 新用户注册
     */
    void registerUser(String phone);




    /**
     *
     * @param user_id
     * @return
     * 根据用户id获取用户信息
     */
    user getMyUserInfo(String user_id);




    /**
     *
     * @param realName
     * @param sex
     * @param company
     * @param position
     * @param user_id
     * 更新用户基本信息
     */
    int updateBasicInfo(String realName,String sex,String company,String position,String work_direction,String user_id);





    /**
     *
     * @param workTag
     * @param user_id
     * @return
     * 更新用户标签
     */
    int updateWorkTag(String workTag,String user_id);





    /**
     *
     * @param education
     * @param expect_Salary
     * @param user_id
     * @return
     * 更新用户求职信息
     */
    int updateJobInfo(String education,String expect_Salary,String user_id);




    /**
     *
     * @param mail
     * @param workBase
     * @param user_id
     * @return
     * 更新用户联系方式信息
     */
    int updateContactInfo(String mail,String workBase,String user_id);




    /**
     *
     * @param user_resume_url
     * @param resume_name
     * @param resume_upload_time
     * @param user_id
     * @return
     * 更新用户简历的存储url
     */
    int uploadResume(String user_resume_url,String resume_name,String resume_upload_time,String user_id);
}
