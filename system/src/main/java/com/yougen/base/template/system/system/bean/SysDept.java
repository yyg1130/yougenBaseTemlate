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
 * 部门
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysDept对象", description="部门")
public class SysDept extends BaseBean<SysDept> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "dept_id", type = IdType.UUID)
    private String deptId;

    private String pid;

    @ApiModelProperty(value = "子部门数目")
    private Integer subCount;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer deptSort;

    @ApiModelProperty(value = "状态")
    private Boolean enabled;


    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }

}
