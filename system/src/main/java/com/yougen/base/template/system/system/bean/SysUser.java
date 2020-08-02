package com.yougen.base.template.system.system.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.yougen.base.template.system.code.bean.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author youGen
 * @since 2020-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="系统用户")
public class SysUser extends BaseBean<SysUser> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "部门名称")
    private String deptId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private Long gender;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像地址")
    private String avatarName;

    @ApiModelProperty(value = "头像真实路径")
    private String avatarPath;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "状态：1启用、0禁用")
    private Integer enabled;


    @ApiModelProperty(value = "修改密码的时间")
    private Date pwdResetTime;



}
