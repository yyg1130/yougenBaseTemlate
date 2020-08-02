package com.yougen.base.template.system.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yougen.base.template.system.system.bean.SysUser;
import com.yougen.base.template.system.system.mapper.SysUserMapper;
import com.yougen.base.template.system.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser selectByName(String name) {
        return this.getOne(Wrappers.<SysUser>lambdaQuery()
        .eq(SysUser::getUsername,name));
    }

}
