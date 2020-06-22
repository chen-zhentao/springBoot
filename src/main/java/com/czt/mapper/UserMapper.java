package com.czt.mapper;


import com.czt.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 加密登录
     * @param username
     * @return
     */
    @Select("select * from tb_user where username=#{username}")
    User findByName(String username);

    /**
     * 查询所有用户信息
     * @param name
     * @return
     */
    List<User> userAlls(String name);

    /**
     * 逻辑删除用户
     * @param userid
     * @return
     */
    @Update("update tb_user set status=2 where userid=#{userid}")
    Integer deleteUser(Integer userid);

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Update("update tb_user set username=#{username},deptid=#{deptid},email=#{email},phonenum=#{phonenum},status=#{status},name=#{name} where userid=#{userid}")
    int updateUser(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("insert into tb_user(username,deptid,email,phonenum,status,name) values(#{username},#{deptid},#{email},#{phonenum},#{status},#{name})")
    int addUser(User user);
}