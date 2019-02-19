package com.lxw.btree.controller;

import com.lxw.btree.model.BF;
import com.lxw.btree.service.BTreeService;


import com.lxw.btree.utils.ResultVoUtils;
import com.lxw.btree.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/btree")
public class BTreeController {

    @Autowired
    private BTreeService bTreeService;


    @GetMapping("/list")
    public ResultVo list(String path) {
        List<BF> list = bTreeService.init(path);
        return ResultVoUtils.success(list);
    }
}
