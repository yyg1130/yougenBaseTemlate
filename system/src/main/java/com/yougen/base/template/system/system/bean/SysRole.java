package com.yougen.base.template.system.system.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yougen.base.template.system.code.bean.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysRole对象", description="角色表")
public class SysRole extends BaseBean<SysRole> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "role_id", type = IdType.UUID)
    private String roleId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "角色级别")
    private Integer level;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "数据权限")
    private String dataScope;

private  String userId;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
