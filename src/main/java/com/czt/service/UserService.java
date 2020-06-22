package com.czt.service;

import com.czt.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

public interface UserService {
    /**
     * 加密登录
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 查询所有员工
     * @param currentPage
     * @param pageSize
     * @param key
     * @return
     */
    PageInfo userAlls(Integer currentPage, Integer pageSize, String key);

    /**
     * 逻辑删除用户
     * @param userid
     * @return
     */
    int deleteUser(Integer userid);

    /**
     * 修改和添加用户
     * @param user
     * @return
     */
    int updateOradd(User user);

}
