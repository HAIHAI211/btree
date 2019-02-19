package com.lxw.btree.model;

import com.lxw.btree.enums.FileTypeEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class BFile implements BF {
    private String name; // 名称(不包括路径)
    private Long space; // 大小
    private Integer type; // 类型
    private String path; // 路径(不包含名称)
    private String allPath; // 全部路径(包含名称)
    private Long lastModified; // 修改时间

    public Integer judgeType (String name) {
        if (name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
            return FileTypeEnum.IMAGE.getCode();
        } else if (name.endsWith(".doc") || name.endsWith(".docx") || name.endsWith(".xls") ||
                name.endsWith(".xlsx") || name.endsWith(".ppt") || name.endsWith(".pptx") || name.endsWith("txt")) {
            return FileTypeEnum.DOC.getCode();
        } else if (name.endsWith(".mp3") || name.endsWith("ncm")) {
            return FileTypeEnum.MUSIC.getCode();
        } else if (name.endsWith(".mp4") || name.endsWith(".avi") || name.endsWith(".rmvb") || name.endsWith("wmv")) {
            return FileTypeEnum.VIDEO.getCode();
        } else {
            return FileTypeEnum.UNKNOWN.getCode();
        }
    }

    public BFile() {
    }
    public BFile(String absolutePath, Long space, Long lastModified) {
        String path = StringUtils.substringBeforeLast(absolutePath,"\\");
        String name = StringUtils.substringAfterLast(absolutePath, "\\");
        Integer type = judgeType(name);
        this.name = name;
        this.space = space;
        this.type = type;
        this.path = path;
        this.allPath = absolutePath;
        this.lastModified = lastModified;
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
