package com.lxw.btree.controller;

import com.lxw.btree.utils.ResultVoUtils;
import com.lxw.btree.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
@Slf4j
public class TestController {
    @GetMapping("")
    public ResultVo init(String signature, String timestamp, String nonce, String echostr) {
        log.info("hehe");
        return ResultVoUtils.success();
    }
}
