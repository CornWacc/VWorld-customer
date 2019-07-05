package com.corn.vworld.controller.banner.ao;

import com.corn.boot.base.Base;
import com.corn.vworld.common.util.ConstantParamsGetUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author yyc
 * @apiNote 主页广告新增ctrl入参
 */
@ApiModel(description = "主页广告实体入参")
public class MainBannerAddAO extends Base {

    private static final long serialVersionUID = 1876074055613839736L;

    /**
     * 主页banner名称
     */
    @ApiModelProperty(name = "mainBannerName", value = "主页banner名称")
    @NotBlank(message = "主页banner名称不能为空")
    private String mainBannerName;

    /**
     * 主页bannerUrl
     */
    @ApiModelProperty(name = "mainBannerUrl",value = "主页bannerUrl")
    private String mainBannerUrl;

    /**
     * 上传类型
     */
    @ApiModelProperty(name = "uploadType",value = "上传类型")
    @NotBlank(message = "上传类型不能为空")
    private String uploadType;

    /**
     * 跳转路径
     */
    @ApiModelProperty(name = "skipUrl",value = "跳转路径")
    private String skipUrl;

    /**
     * 主页Banner状态
     */
    @ApiModelProperty(name = "mainBannerStatus",value = "主页Banner状态")
    @NotBlank(message = "主页Banner状态不能为空")
    private String mainBannerStatus;

    /**
     * 七牛上传后的回调
     * */
    @ApiModelProperty(name = "qiNiuUploadCallBack",value = "七牛上传后的回调s")
    private String qiNiuUploadCallBack;

    public String getQiNiuUploadCallBack() {
        return qiNiuUploadCallBack;
    }

    public void setQiNiuUploadCallBack(String qiNiuUploadCallBack) {
        this.qiNiuUploadCallBack = qiNiuUploadCallBack;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public String getMainBannerName() {
        return mainBannerName;
    }

    public void setMainBannerName(String mainBannerName) {
        this.mainBannerName = mainBannerName;
    }

    public String getMainBannerUrl() {
        return mainBannerUrl;
    }

    public void setMainBannerUrl(String mainBannerUrl) {
        this.mainBannerUrl = mainBannerUrl;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public String getMainBannerStatus() {
        return mainBannerStatus;
    }

    public void setMainBannerStatus(String mainBannerStatus) {
        this.mainBannerStatus = mainBannerStatus;
    }

}
