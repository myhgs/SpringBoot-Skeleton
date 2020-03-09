package my.project.hong.web.controller;

import my.project.hong.model.code.CommonConst;
import my.project.hong.service.excel.ExcelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by kiseokhong on 2020/03/09.
 */
@RestController
@RequestMapping(CommonConst.URL_ROOT+"/excel")
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }


    @GetMapping("/{type}")
    public void test(HttpServletResponse response, @PathVariable(value = "type") String type){
        excelService.excelDownload(response, type);
    }

}
