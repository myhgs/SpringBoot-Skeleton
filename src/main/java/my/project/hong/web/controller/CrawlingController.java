package my.project.hong.web.controller;

import my.project.hong.model.code.CommonConst;
import my.project.hong.service.crawling.CrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kiseokhong on 01/03/2020.
 */
@RestController
@RequestMapping(CommonConst.URL_ROOT+"/crawling")
public class CrawlingController {

    private final CrawlingService crawlingService;

    @Autowired
    public CrawlingController(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }

    @GetMapping("")
    public void test(){

        crawlingService.crawlingTest();

    }

}
