package com.lxw.btree.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public class BDirectory implements BF{
    private String name; // 文件夹名称
    private String path; // 路径
    private Long lastModified; // 修改时间

    public BDirectory() {
    }

    public BDirectory(String name, String path, Long lastModified) {
        this.name = name;
        this.path = path;
        this.lastModified = lastModified;
    }

    public BDirectory(String absolutePath, Long lastModified) {
        String path = StringUtils.substringBeforeLast(absolutePath,"\\");
        String name = StringUtils.substringAfterLast(absolutePath, "\\");
        this.name = name;
        this.path = path;
        this.lastModified = lastModified;
    }

    @Override
    public Boolean isFile() {
        return false;
    }

    @Override
    public Boolean isDirectory() {
        return true;
    }
}
