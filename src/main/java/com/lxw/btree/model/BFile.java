package com.lxw.btree.model;

import com.lxw.btree.enums.FileTypeEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class BFile extends BF {
    private Long space; // 大小
    private Integer type; // 类型

    public Integer judgeType (String name) {
        if (name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
            return FileTypeEnum.IMAGE.getCode();
        } else if (name.endsWith(".doc") || name.endsWith(".docx") || name.endsWith(".xls") ||
                name.endsWith(".xlsx") || name.endsWith(".ppt") || name.endsWith(".pptx") ||
                name.endsWith("txt") || name.endsWith(".html") || name.endsWith(".js") || name.endsWith(".css")) {
            return FileTypeEnum.DOC.getCode();
        } else if (name.endsWith(".mp3") || name.endsWith(".ncm")) {
            return FileTypeEnum.MUSIC.getCode();
        } else if (name.endsWith(".mp4") || name.endsWith(".avi") || name.endsWith(".rmvb") || name.endsWith(".wmv")) {
            return FileTypeEnum.VIDEO.getCode();
        } else {
            return FileTypeEnum.UNKNOWN.getCode();
        }
    }

    public BFile() {
    }
    public BFile(String absolutePath, Long space, Long lastModified) {
        super(absolutePath, lastModified);
        this.space = space;
        this.type = judgeType(this.name);
    }
    public BFile(java.io.File file) {
        this(file.getAbsolutePath(),file.getTotalSpace(),file.lastModified());
    }

    @Override
    public Boolean isFile() {
        return true;
    }

    @Override
    public Boolean isDirectory() {
        return false;
    }
}
