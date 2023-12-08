package com.qh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_model")
public class TestModel {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_name")
    private String userName;

    @TableField("age")
    private Integer age;

    @TableField("sex")
    private Integer sex;
}
