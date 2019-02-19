package com.lxw.btree.model;

import java.io.Serializable;

public interface BF extends Serializable {
    Boolean isFile();
    Boolean isDirectory();
    String getName();
    String getPath();
    Long getLastModified();
}
