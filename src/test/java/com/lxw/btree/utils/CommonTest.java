package com.lxw.btree.utils;

import com.lxw.btree.model.BF;
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
        Common.lists("C:\\Users\\16343\\Documents",container);
        Assert.assertNotEquals(0, container.size());
    }

    @Test
    public void lists1() {
    }
}