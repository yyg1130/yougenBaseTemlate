package com.yougen.base.template.system.system.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yougen.base.template.system.code.bean.BaseBean;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysPermission对象", description="权限表")
public class SysPermission extends BaseBean<SysPermission> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "资源名")
    private String name;

    private Integer type;

    @ApiModelProperty(value = "资源顺序")
    private Integer priority;

    private String parentId;

    @ApiModelProperty(value = "权限字符串")
    private String permission;

    @ApiModelProperty(value = "是否可用")
    private Long available;
private String roleId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
