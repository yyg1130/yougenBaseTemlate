package com.yougen.base.template.system.code.bean;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

/**
 * @author yyg
 */
@Data
public class BaseBean<T>  extends Model<BaseBean<T>> implements Serializable {
   private static final long serialVersionUID = 1L;
    private Date createTime;
    private Date updateTime;
    private String  createBy;
    private String  updateBy;
}
