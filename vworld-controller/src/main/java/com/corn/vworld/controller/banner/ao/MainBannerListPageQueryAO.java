package com.corn.vworld.controller.banner.ao;

import com.corn.boot.base.PageOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author yyc
 * @apiNote 主页广告分页查询入参
 * */
@ApiModel(description = "主页广告分页查询入参")
public class MainBannerListPageQueryAO extends PageOrder {

    private static final long serialVersionUID = 1511016682867483294L;

    /**
     * 主页广告状态
     * */
    @ApiModelProperty(value = "主页广告状态",name = "mainBannerStatus")
    private String mainBannerStatus;

    public String getMainBannerStatus() {
        return mainBannerStatus;
    }

    public void setMainBannerStatus(String mainBannerStatus) {
        this.mainBannerStatus = mainBannerStatus;
    }
}
