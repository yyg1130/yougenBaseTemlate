package com.yougen.base.template.system.system.controller;

import com.yougen.base.template.system.security.realm.common.LoginResult;
import com.yougen.base.template.system.system.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yyg
 */
@Api(tags = "用户登录、退出")
@RestController
@RequestMapping("/sys/")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    private LoginController(LoginService loginService) {

        this.loginService = loginService;
    }




    @PostMapping("login")
    @ApiOperation("登录")
   public LoginResult login(@RequestParam("userName") String userName, @RequestParam("password") String password,
                            @RequestParam("isRemember") Boolean isRemember) {
     return  loginService.loginByNameAndPassword(userName, password, isRemember);
   }


   @GetMapping("loginOut")
   @ApiOperation("退出")
   public void  loginOut(){
        loginService.loginOut();
   }

}
