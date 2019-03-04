package com.lxw.btree.service.impl;

import com.lxw.btree.enums.FileTypeEnum;
import com.lxw.btree.model.BF;
import com.lxw.btree.model.BFile;
import com.lxw.btree.model.BplusTree;
import com.lxw.btree.service.BTreeService;
import com.lxw.btree.utils.Common;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BTreeServiceImpl implements BTreeService {

    private static List<BF> container;
    private static BplusTree pathTree;
    private static BplusTree nameTree;
    private static BplusTree timeTree;
    private static BplusTree typeTree;


    @Override
    public List<BF> init(String path) {
        container = new ArrayList<>();

        // 扫盘
        Common.lists(path,container);
        pathTree = new BplusTree(6);
        nameTree = new BplusTree(6);
        timeTree = new BplusTree(6);
        typeTree = new BplusTree(6);
        for (int i = 0; i < container.size(); i++) {
            BF bf = container.get(i);
            pathTree.insertOrUpdate(bf.getPath(), bf);
            nameTree.insertOrUpdate(bf.getName(), bf);
            timeTree.insertOrUpdate(bf.getLastModified(), bf);
            if (bf.isFile()) {
                BFile bFile = (BFile) bf;
                typeTree.insertOrUpdate(bFile.getType(), bf);
            }
        }
        List a = pathTree.get(path);
        return a;
    }

    @Override
    public List<BF> getDirChildren(String path) {
        return pathTree.get(path);
    }

    @Override
    public List<BF> getByType(Integer type) {
        return typeTree.get(type);
    }

    @Override
    public List<BF> getByName(String name) {
        return nameTree.get(name);
    }

    /**
    *
    * 模糊查询，全通配，无法使用索引，只能扫盘
    * */
    @Override
    public List<BF> getByFuzzyName(String name) {
        List<BF> result = new ArrayList<>();
        for (int i = 0; i < container.size(); i++) {
            BF bf = container.get(i);
            if (bf.getName().contains(name)) {
                result.add(bf);
            }
        }
        return result;
    }

    /**
    *获得最近使用的文件
    * */
    @Override
    public List<BF> getRecent() {
        List<BF> result = new ArrayList<>();
        return null;
    }
}
