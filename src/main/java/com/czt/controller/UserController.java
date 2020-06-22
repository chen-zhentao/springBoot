package com.czt.controller;

import com.czt.entity.User;
import com.czt.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            token.setRememberMe(false);
            try {
                //调用登录方法：将token ------------->委托给安全管理器进行认证--------------------->进入认证器，调用Realm获取用户信息进行匹配
                subject.login(token);
                return "loginSuccess";
            } catch (UnknownAccountException uae) { //账号不存在
                throw new UnknownAccountException("账号不存在");
            } catch (IncorrectCredentialsException ice) {//密码不匹配
                throw new IncorrectCredentialsException("密码不匹配");
            } catch (LockedAccountException lae) {//账户锁定
                throw new LockedAccountException("账户锁定异常");
            }
            catch (AuthenticationException ae) { //认证异常
                throw new AuthenticationException("认证异常");
            }
        }
        return "loginError";
    }

    /**
     * 查询所有，根据名字模糊查询
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public PageInfo list(@RequestParam(value ="currentPage",required = false,defaultValue = "1") Integer currentPage,
                         @RequestParam(value ="pageSize",required = false,defaultValue = "5") Integer pageSize, String search){
        return userService.userAlls(currentPage,pageSize,search);
    }

    /**
     * 删除用户
     * @param userid
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public int deleteUser(Integer userid){

        return userService.deleteUser(userid);
    }

    /**
     * 修改和添加用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateOradd")
    public int updateOradd(@RequestBody User user){
        return userService.updateOradd(user);
    }
}
