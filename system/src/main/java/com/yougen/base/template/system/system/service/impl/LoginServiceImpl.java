package com.yougen.base.template.system.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.yougen.base.template.system.security.realm.common.LoginResult;
import com.yougen.base.template.system.system.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author yyg
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public LoginResult loginByNameAndPassword(String userName,String password,Boolean isRemember) {
        LoginResult  loginResult=new LoginResult();
          if(StrUtil.isEmpty(userName)){
              loginResult.setIsLogin(false);
              loginResult.setResult("用户名为空");
              return  loginResult;
          }
        UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
        token.setRememberMe(isRemember);
        String  msg="";
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("userName",userName);
            loginResult.setIsLogin(true);
            return loginResult;
        }catch (UnknownAccountException e){
            e.printStackTrace();
            msg = "账号不存在";
        } catch (IncorrectCredentialsException e) {
            msg = " 密码不正确";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            msg = "用户验证失败";
        }
        loginResult.setIsLogin(false);
        loginResult.setResult(msg);
        return loginResult;
    }

    @Override
    public void loginOut() {
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
    }
}
