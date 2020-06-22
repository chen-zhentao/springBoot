package com.czt.realm;

import com.czt.entity.User;
import com.czt.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
   private UserService userService;
    /**
     * 验证用户
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取前端传过来的token信息
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //从token中获取用户名
        String username = token.getUsername();
        User tUser = userService.findByName(username);
        if (tUser == null){
            throw new UnknownAccountException("该用户:"+tUser.getUsername()+"不存在");
        }
        //返回一个认证信息的实例，认证的过程：交给Shiro的认证器去完成
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(tUser.getUsername(), tUser.getPassword(), ByteSource.Util.bytes(tUser.getUsername()), this.getName());
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
