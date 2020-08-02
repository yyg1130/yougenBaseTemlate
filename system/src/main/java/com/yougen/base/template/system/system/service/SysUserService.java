package com.yougen.base.template.system.system.service;

import com.yougen.base.template.system.system.bean.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 通过名字查找
     * @param name
     * @return
     */
    SysUser selectByName(String name);



}
