package com.corn.vworld.controller.banner.ao;

import com.corn.boot.base.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;


/**
 * @author yyc
 * @apiNote 主页banner删除入参实体
 * */
@ApiModel(description = "主页banner删除入参实体")
public class MainBannerDelAO extends Base {

    private static final long serialVersionUID = -1998054001416682954L;

    /**
     * 主页bannerId
     */
    @ApiModelProperty(name = "mainBannerId", value = "主页bannerId")
    @NotBlank(message = "主页bannerId不能为空")
    private String mainBannerId;

    public String getMainBannerId() {
        return mainBannerId;
    }

    public void setMainBannerId(String mainBannerId) {
        this.mainBannerId = mainBannerId;
    }
}
