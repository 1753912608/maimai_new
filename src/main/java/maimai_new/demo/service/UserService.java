package maimai_new.demo.service;

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
}
