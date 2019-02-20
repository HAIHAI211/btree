package com.lxw.btree.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public class BDirectory extends BF{

    public BDirectory() {
    }

    public BDirectory(String name, String path, String allPath, Long lastModified) {
        super(name,path,allPath,lastModified);
    }

    public BDirectory(String absolutePath, Long lastModified) {
        super(absolutePath, lastModified);
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
