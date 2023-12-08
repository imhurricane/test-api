package com.qh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qh.model.TestModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangdanshi
 * @date 2023/05/21 2:46 PM
 */
@Mapper
public interface TestMapper extends BaseMapper<TestModel> {
}
