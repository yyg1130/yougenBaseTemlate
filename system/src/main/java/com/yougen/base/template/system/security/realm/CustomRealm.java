package com.yougen.base.template.system.security.realm;

import com.yougen.base.template.system.system.bean.SysPermission;
import com.yougen.base.template.system.system.bean.SysUser;
import com.yougen.base.template.system.system.service.SysPermissionService;
import com.yougen.base.template.system.system.service.SysRoleService;
import com.yougen.base.template.system.system.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.Objects;

/**
 * @author yyg
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private SysUserService userService;
    @Autowired
    @Lazy
    private SysRoleService roleService;
    @Autowired
    @Lazy
    private SysPermissionService permissionService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();

        SysUser user = userService.selectByName(userName);
        if (Objects.isNull(user)) {
            throw new UnknownAccountException();
        }
        if (user.getEnabled() == 0) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getUsername()), getName());
        return authenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleService.selectByUserName(name));
        authorizationInfo.setStringPermissions(permissionService.selectByUserName(name));
        return authorizationInfo;
    }
}
