package com.lxw.btree.service;

import com.lxw.btree.model.BF;

import java.util.List;

public interface BTreeService {
    // 初始化根目录
    List<BF> init(String path);

    // 进入文件夹
    List<BF> getDirChildren(String path);

    // 根据type获取
    List<BF> getByType(Integer type);

    // 根据name获取(精确查询)
    List<BF> getByName(String name);

    List<BF> getByFuzzyName(String name);
}
