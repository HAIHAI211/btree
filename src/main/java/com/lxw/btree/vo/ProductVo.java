package com.lxw.btree.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo {

    @JsonProperty("name") // 返回给前端的字段名
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;
}
