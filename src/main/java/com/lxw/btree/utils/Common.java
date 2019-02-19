package com.lxw.btree.utils;

import com.lxw.btree.model.BDirectory;
import com.lxw.btree.model.BF;
import com.lxw.btree.model.BFile;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.util.*;

public class Common {

    private static final String[] filterName = new String[] {"txt","doc","docx",
            "xls","xlsx","mp4","avi",
            "rmvb","wmv","mp3","ncm",
            "ppt","pptx","js","html",
            "css","json","png","jpg"}; // 11

    /**
    * 创建文件过滤器
    * */
    public static IOFileFilter getFilter () {
        IOFileFilter directories = FileFilterUtils.and(
                FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);
        IOFileFilter[] ioFileFilters = new IOFileFilter[filterName.length + 1];
        ioFileFilters[0] = directories;
        for (int i = 0; i < filterName.length; i++) {
            IOFileFilter ioFileFilter = FileFilterUtils.and(
                    FileFilterUtils.fileFileFilter(),
                    FileFilterUtils.suffixFileFilter("." + filterName[i]));
            ioFileFilters[i+1] = ioFileFilter;
        }
        return FileFilterUtils.or(ioFileFilters);
    }

    /**
    * 遍历某个文件夹
    * */
    public static void lists(File file, List<BF> container) {
        if (file.isDirectory()) { // 判断是否为文件夹
            File[] list = file.listFiles(); // 使用数组接收带有完整路径的文件夹
            if (list != null) {
                // 循环遍历文件
                for (int i = 0; i < list.length; i++) {
                    lists(list[i], container);
                }
            }
            container.add(new BDirectory(file.getAbsolutePath(), file.lastModified()));
        } else {
            container.add(new BFile(file));
        }

    }
    /**
    * 遍历路径
    * */
    public static void lists(String path, List<BF> container) {
        File file = new File(path);
        lists(file, container);
    }
}
