package com.lxw.btree.utils;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;

public class Common {

    private static final String[] filterName = new String[] {"txt","doc","docx","xls","xlsx","mp4","avi","rmvb","wmv","mp3","ncm"}; // 11

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
}
