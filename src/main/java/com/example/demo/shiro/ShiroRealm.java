package com.example.demo.shiro;

import com.example.demo.comm.RetData;
import com.example.demo.one.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> permission = (Set<String>) SecurityUtils.getSubject().getSession().getAttribute("permission");
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String userPwd = token.getPassword().toString();

        RetData retData = loginService.userLogin(userName, userPwd);
        Map map = (Map) retData.getRetData();
        return new SimpleAuthenticationInfo(map.get("user_name"), map.get("user_pwd"), "");
    }

}
