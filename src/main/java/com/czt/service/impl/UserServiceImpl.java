package com.czt.service.impl;

import com.czt.entity.User;
import com.czt.mapper.UserMapper;
import com.czt.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public PageInfo userAlls(Integer currentPage, Integer pageSize, String key) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> users = userMapper.userAlls(key);
        //根据返回的集合，得到分页相关的属性数据
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public int deleteUser(Integer userid) {
        return userMapper.deleteUser(userid);
    }

    @Override
    public int updateOradd(User user) {
        if (user.getUserid()!=null){
            return userMapper.updateUser(user);
        }else {
            user.setStatus(1);
            return userMapper.addUser(user);
        }
    }
}
