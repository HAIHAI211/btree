package com.lxw.btree;

import com.lxw.btree.utils.Common;
import com.lxw.btree.utils.FileListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.util.concurrent.TimeUnit;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class BtreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BtreeApplication.class, args);

        System.out.println("*********************************启动成功*********************************");
        // 监控目录
        String rootDir = "C:\\Users\\Administrator\\Desktop\\one";
        // 轮询间隔 5 秒
        long interval = TimeUnit.SECONDS.toMillis(1);
        // 创建过滤器
        IOFileFilter directories = FileFilterUtils.and(
                FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);
        // 使用过滤器
        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir), Common.getFilter());

        //FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir));
        observer.addListener(new FileListener());
        //创建文件变化监听器
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        try{
            monitor.start();
            System.out.println("***************监控中***************");
        }
        catch (Exception e){
            log.error("异常处理",e);
        }
    }

}
