package com.yougen.base.template.system.system.service;

import com.yougen.base.template.system.security.realm.common.LoginResult;

/**
 * @author yyg
 */
public interface LoginService {
    /**
     * 用户名密码登录
     * @param
     * @return
     */
    LoginResult loginByNameAndPassword(String userName,String password,Boolean isRemember);

    /**
     * 退出登录
     */
    void loginOut();
}
