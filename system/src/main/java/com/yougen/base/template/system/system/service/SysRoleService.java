package com.yougen.base.template.system.system.service;

import com.yougen.base.template.system.system.bean.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 通过名字查找角色
     * @param name
     * @return
     */
    Set<String> selectByUserName(String name);

}
