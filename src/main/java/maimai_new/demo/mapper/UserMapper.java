package maimai_new.demo.mapper;


import maimai_new.demo.dao.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {


    /**
     *
     * @param phone
     * @return
     * 判断用户是否存在
     */
    @Select("select user_id from user where user_id=#{phone}")
    String isUserExist(String phone);



    /**
     *
     * @param phone
     * @return
     * 新用户注册
     */
    @Insert("insert into user(user_id) values(#{phone})")
    void registerUser(String phone);



    /**
     *
     * @param user_id
     * @return
     * 根据用户id获取用户信息
     */
    @Select("select * from user where user_id=#{user_id}")
    user getMyUserInfo(String user_id);


    /**
     *
     * @param realName
     * @param sex
     * @param company
     * @param position
     * @param work_direction
     * @param user_id
     * 更新用户的基本信息
     */
    @Update("update user set user_real_name=#{realName},user_sex=#{sex},user_position=#{position},user_company=#{company},user_work_direction=#{work_direction} where user_id=#{user_id}")
    void updateBasicInfo(String realName,String sex,String company,String position,String work_direction,String user_id);





    /**
     *
     * @param workTag
     * @param user_id
     * 更新用户职业标签
     */
    @Update("update user set user_tag=#{workTag} where user_id=#{user_id}")
    void updateWorkTag(String workTag,String user_id);





    /**
     *
     * @param education
     * @param expect_Salary
     * @param user_id
     * 更新用户求职信息
     */
    @Update("update user set user_education=#{education},user_expect_Salary=#{expect_Salary} where user_id=#{user_id}")
    void updateJobInfo(String education,String expect_Salary,String user_id);




    /**
     *
     * @param mail
     * @param workBase
     * @param user_id
     * 更新用户联系方式
     */
    @Update("update user set user_mail=#{mail},user_work_base=#{workBase} where user_id=#{user_id}")
    void updateContactInfo(String mail,String workBase,String user_id);




    /**
     *
     * @param user_resume_url
     * @param resume_name
     * @param time
     * @param user_id
     * 更新用户简历的存储url
     */
    @Update("update user set user_resume_url=#{user_resume_url},user_resume_name=#{resume_name},user_resume_upload_time=#{time} where user_id=#{user_id}")
    void uploadResume(String user_resume_url,String resume_name,String time,String user_id);
}
