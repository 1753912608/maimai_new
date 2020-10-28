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
}
