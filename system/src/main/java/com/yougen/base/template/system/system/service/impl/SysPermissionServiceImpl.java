package com.yougen.base.template.system.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Sets;
import com.yougen.base.template.system.system.bean.SysPermission;
import com.yougen.base.template.system.system.bean.SysRole;
import com.yougen.base.template.system.system.bean.SysUser;
import com.yougen.base.template.system.system.mapper.SysPermissionMapper;
import com.yougen.base.template.system.system.mapper.SysRoleMapper;
import com.yougen.base.template.system.system.mapper.SysUserMapper;
import com.yougen.base.template.system.system.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yougen.base.template.system.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private SysRoleMapper roleMapper;

    @Override
    public Set<String> selectByUserName(String name) {
        SysUser user=userMapper.selectOne(new QueryWrapper<SysUser>().eq("username",name));
        if(Objects.nonNull(user)) {
            List<SysRole> roleList = roleMapper.selectList(Wrappers.<SysRole>lambdaQuery()
                    .eq(SysRole::getUserId, user.getId()));
           List<SysPermission> permissions =new ArrayList<>();
            roleList.forEach(e->{
                permissions.addAll(this.list(Wrappers.<SysPermission>lambdaQuery()
                .eq(SysPermission::getRoleId,e.getRoleId())));
            });
            return Sets.newHashSet(permissions.stream().map(e->e.getName()).collect(Collectors.toList()));
        }
        return null;
    }
}
