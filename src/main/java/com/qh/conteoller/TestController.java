package com.qh.conteoller;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qh.constant.ApiResult;
import com.qh.model.TestModel;
import com.qh.service.TestService;
import com.qh.utils.ApiResultUtil;
import com.qh.utils.HutoolExcelUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/realTimeMonitor")
    public ApiResult<TestModel> realTimeMonitor() {
        return ApiResultUtil.success(testService.list());
    }

    /**
     * 列表下载
     *
     * @param response
     */
    @GetMapping("/download")
    public void downloadBus(HttpServletResponse response) {
        List<TestModel> busInfoList = testService.list();
        Map<String, String> alisMap = HutoolExcelUtils.field2Alias(TestModel.class);
        HutoolExcelUtils.download(response, busInfoList, alisMap, "**列表");
    }

    /**
     * 列表上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    public void uploadBus(@RequestParam("file") MultipartFile file) {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        Map<String, String> aliasMap = HutoolExcelUtils.alias2Field(TestModel.class);
        reader.setHeaderAlias(aliasMap);
        List<TestModel> busInfoList = reader.readAll(TestModel.class);
        testService.remove(Wrappers.emptyWrapper());
        testService.saveOrUpdateBatch(busInfoList);
    }


}
