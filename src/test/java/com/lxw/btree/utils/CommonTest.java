package com.lxw.btree.utils;

import com.lxw.btree.enums.FileTypeEnum;
import com.lxw.btree.model.BF;
import com.lxw.btree.model.BFile;
import com.lxw.btree.model.BplusTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Test
    public void lists() {
        List<BF> container = new ArrayList<>();
        Common.lists("C:\\test",container);
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
        List a = typeTree.get(FileTypeEnum.DOC.getCode());
        Assert.assertNotEquals(0, a.size());
    }

    @Test
    public void lists1() {
    }
}