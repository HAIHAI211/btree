package com.lxw.btree.service;

import com.lxw.btree.model.BF;

import java.util.List;

public interface BTreeService {
    // 初始化扫盘
    List<BF> init(String path);
}
