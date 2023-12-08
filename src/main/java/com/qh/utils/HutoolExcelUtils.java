package com.qh.utils;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.qh.annotation.HutoolExcelAlias;
import lombok.SneakyThrows;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @author mayue
 * @create 2023/11/22 10:45 PM
 */
public class HutoolExcelUtils {
    public static <T> Map<String, String> field2Alias(Class<T> myClass) {
        Field[] fields = ReflectUtil.getFields(myClass);
        Map<String, String> map = new LinkedHashMap<>();
        for (Field f : fields) {
            if (AnnotationUtil.hasAnnotation(f, HutoolExcelAlias.class)) {
                HutoolExcelAlias annotation = AnnotationUtil.getAnnotation(f, HutoolExcelAlias.class);
                map.put(f.getName(), annotation.alias());
            }
        }
        return map;
    }

    public static <T> Map<String, String> alias2Field(Class<T> myClass) {
        Field[] fields = ReflectUtil.getFields(myClass);
        Map<String, String> map = new LinkedHashMap<>();
        for (Field f : fields) {
            if (AnnotationUtil.hasAnnotation(f, HutoolExcelAlias.class)) {
                HutoolExcelAlias annotation = AnnotationUtil.getAnnotation(f, HutoolExcelAlias.class);
                map.put(annotation.alias(), f.getName());
            }
        }
        return map;
    }

    @SneakyThrows
    public static void download(HttpServletResponse response, List<?> list, Map<String, String> aliasMap, String fileName) {
        // 创建Excel写入器
        ExcelWriter writer = ExcelUtil.getWriter();

        writer.setHeaderAlias(aliasMap);

        // 写入数据
        writer.write(list, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String utf8Encoded = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
        response.setHeader("Content-Disposition", "attachment;filename=" + utf8Encoded + ".xls");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        // 关闭写入器
        writer.close();
        IoUtil.close(out);
    }
}
