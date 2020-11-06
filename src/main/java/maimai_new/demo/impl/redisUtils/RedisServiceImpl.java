package maimai_new.demo.impl.redisUtils;


import maimai_new.demo.dao.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl {


    @Autowired
    private RedisTemplate<String,Object>redisTemplate;

    /**
     *
     * @param rand_uuid
     * @param rand_code
     * rand_uuid为前端随机的字符串，防止用户刷验证码
     * rand_code为发送给用户的6位数手机验证码
     */
    public void savePhoneCode(String rand_uuid,String rand_code){
        redisTemplate.opsForValue().set(rand_uuid,rand_code,6000, TimeUnit.SECONDS);
    }


    /**
     *
     * @param rand_uuid
     * @return
     * 根据前端随机生成的字符串获取指定用户的验证码
     */
    public String getPhoneCode(String rand_uuid){
        return (String)redisTemplate.opsForValue().get(rand_uuid);
    }




    /**
     *
     * @param user_id
     * @param u
     * 存储当前用户的个人信息
     */
    public void saveUserInfo(String user_id, user u){
        redisTemplate.opsForValue().set(user_id,u);
    }




    /**
     *
     * @param user_id
     * @return
     * 获取当前用户存储的个人信息
     */
    public user getUserInfo(String user_id){
        return (user) redisTemplate.opsForValue().get(user_id);
    }




    /**
     *
     * @param dynamic_id
     * @param user_id
     * 用户对动态进行点赞
     */
    public void thumbsUp(String dynamic_id,String user_id){
        redisTemplate.opsForSet().add("dianzan:dynamic_id:"+dynamic_id,user_id);
    }



    /**
     *
     * @param dynamic_id
     * @param user_id
     * 用户对动态取消点赞
     */
    public void thumbsDowm(String dynamic_id,String user_id){
        redisTemplate.opsForSet().remove("dianzan:dynamic_id:"+dynamic_id,user_id);
    }
}
