package com.yougen.base.template.system.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Sets;
import com.yougen.base.template.system.system.bean.SysRole;
import com.yougen.base.template.system.system.bean.SysUser;
import com.yougen.base.template.system.system.mapper.SysRoleMapper;
import com.yougen.base.template.system.system.mapper.SysUserMapper;
import com.yougen.base.template.system.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
@Resource
private SysUserMapper  userMapper;
    @Override
    public Set<String> selectByUserName(String name) {
        SysUser user=userMapper.selectOne(new QueryWrapper<SysUser>().eq("username",name));
        if(Objects.nonNull(user)){
          List<SysRole> roleList = this.list(Wrappers.<SysRole>lambdaQuery().eq(SysRole::getUserId,user.getId()));
            return Sets.newHashSet(roleList.stream().map(e->e.getName()).collect(Collectors.toList()));
        }
        return null;
    }
}
