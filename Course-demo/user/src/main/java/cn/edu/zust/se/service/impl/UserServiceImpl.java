package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.UserDao;
import cn.edu.zust.se.pojo.User;
import cn.edu.zust.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User getUserById(Integer Id) {
        return userDao.getUserById(Id);
    }
}
