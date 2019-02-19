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
    @Override
    public List<BF> init(String path) {
        List<BF> container = new ArrayList<>();

        // 扫盘
        Common.lists(path,container);
        BplusTree pathTree = new BplusTree(6);
        BplusTree nameTree = new BplusTree(6);
        BplusTree timeTree = new BplusTree(6);
        BplusTree typeTree = new BplusTree(6);
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
}
