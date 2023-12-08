package com.qh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qh.mapper.TestMapper;
import com.qh.model.TestModel;
import com.qh.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangdanshi
 * @date 2023/05/21 5:02 PM
 */
@Slf4j
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestModel> implements TestService {
}
