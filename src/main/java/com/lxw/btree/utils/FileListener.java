package com.lxw.btree.utils;
import com.lxw.btree.model.BplusTree;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.util.Assert;

import java.io.*;

/**
 *
 * 文件变化监听器
 *
 * 在Apache的Commons-IO中有关于文件的监控功能的代码. 文件监控的原理如下：
 * 由文件监控类FileAlterationMonitor中的线程不停的扫描文件观察器FileAlterationObserver，
 * 如果有文件的变化，则根据相关的文件比较器，判断文件时新增，还是删除，还是更改。（默认为1000毫秒执行一次扫描）
 *
 *
 */
@Slf4j
public class FileListener extends FileAlterationListenerAdaptor {

    private BplusTree allTree = new BplusTree(6);
    private BplusTree docTree = new BplusTree(6);
    private BplusTree musicTree = new BplusTree(6);
    private BplusTree picTree = new BplusTree(6);
    private BplusTree videoTree = new BplusTree(6);
    private int count = 0;

    /**
     * 文件创建执行
     */
    public void onFileCreate(File file) {
        log.info("[新建]:" + file.getAbsolutePath() + ",名称" + file.getName() + ",路径" + file.getPath());
        allTree.insertOrUpdate(file.getAbsolutePath(), file);
        count++;
        System.out.println(count);
        if (count == 6) {
            Object a = allTree.get("C:\\test\\ff.txt");
            System.out.println("哈哈哈");
            System.out.println(a);
        }
    }

    /**
     * 文件创建修改
     */
    public void onFileChange(File file) {
        log.info("[修改]:" + file.getAbsolutePath() + ",名称" + file.getName() + ",路径" + file.getPath());
        BufferedReader buf = null;
        try {
            buf = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
            BufferedReader br = new BufferedReader(buf);
            String line = null;
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 这里释放系统 IO 资源
            try {if (buf != null){buf.close();}}catch (Exception e){}
        }
    }

    /**
     * 文件删除
     */
    public void onFileDelete(File file) {
        log.info("[删除]:" + file.getAbsolutePath() + ",名称" + file.getName() + ",路径" + file.getPath());

    }

    /**
     * 目录创建
     */
    public void onDirectoryCreate(File directory) {
        log.info("[新建]:" + directory.getAbsolutePath());
    }

    /**
     * 目录修改
     */
    public void onDirectoryChange(File directory) {
        log.info("[修改]:" + directory.getAbsolutePath());
    }

    /**
     * 目录删除
     */
    public void onDirectoryDelete(File directory) {
        log.info("[删除]:" + directory.getAbsolutePath());
    }

    public void onStart(FileAlterationObserver observer) {
        // TODO Auto-generated method stub
        super.onStart(observer);
    }

    public void onStop(FileAlterationObserver observer) {
        // TODO Auto-generated method stub
        super.onStop(observer);
    }
}
