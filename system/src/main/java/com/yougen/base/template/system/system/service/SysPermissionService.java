package com.yougen.base.template.system.system.service;

import com.yougen.base.template.system.system.bean.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
public interface SysPermissionService extends IService<SysPermission> {
    /**
     *
     * @param name
     * @return
     */
    Set<String> selectByUserName (String name);

}
