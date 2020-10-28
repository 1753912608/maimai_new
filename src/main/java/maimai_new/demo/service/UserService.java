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
}
