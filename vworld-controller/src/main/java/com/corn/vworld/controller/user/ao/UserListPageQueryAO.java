package com.corn.vworld.controller.user.ao;

import com.corn.boot.base.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author yyc
 * @apiNote 用户分页列表查询
 * */
@ApiModel(description = "用户分页查询列表")
public class UserListPageQueryAO extends Base {
    private static final long serialVersionUID = 1750614758720450780L;

    /**
     * 关键字类型
     * */
    @ApiModelProperty(name = "type",value = "关键字类型")
    private String type;

    /**
     * 关键字
     * */
    @ApiModelProperty(name = "keyWord",value = "关键字")
    private String keyWord;

    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getKeyWord() {
        return keyWord;
    }

    @Override
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
