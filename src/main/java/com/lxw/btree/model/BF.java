package com.lxw.btree.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public abstract class BF implements Serializable {

    protected String name; // 文件夹名称
    protected String path; // 路径
    protected String allPath; // 全路径
    protected Long lastModified; // 修改时间

    public BF(String name, String path, String allPath, Long lastModified) {
        this.name = name;
        this.path = path;
        this.allPath = allPath;
        this.lastModified = lastModified;
    }

    public BF(String absolutePath, Long lastModified) {
        this(StringUtils.substringAfterLast(absolutePath, "\\"), StringUtils.substringBeforeLast(absolutePath,"\\"), absolutePath, lastModified);
    }

    public BF() {

    }


    public abstract Boolean isFile();

    public abstract Boolean isDirectory();
}
