package maimai_new.demo.impl;

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
}
