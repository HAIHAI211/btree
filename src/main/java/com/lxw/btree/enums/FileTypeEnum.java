package com.lxw.btree.enums;

import lombok.Getter;

@Getter
public enum FileTypeEnum {
    MUSIC(0,"音乐"),
    DOC(1,"文档"),
    VIDEO(2,"视频"),
    IMAGE(3,"图片"),
    UNKNOWN(4,"未知")
    ;
    private Integer code;
    private String message;

    FileTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
