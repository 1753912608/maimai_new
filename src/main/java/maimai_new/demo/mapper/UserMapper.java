package maimai_new.demo.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
