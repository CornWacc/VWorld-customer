package com.corn.vworld.controller.banner.ao;

import com.corn.boot.base.Base;


/**
 * @author yyc
 * @apiNote 登录页面新增入参
 * */
public class LoginBannerAddAO extends Base {
    private static final long serialVersionUID = -1338585812971842195L;

    /**
     * 登录banner名称
     */
    private String loginBannerName;

    /**
     * 登录bannerUrl
     */
    private String loginBannerUrl;

    /**
     * 上传类型
     * */
    private String uploadType;

    /**
     * 跳转路径
     */
    private String skipUrl;

    /**
     * 登录Banner状态
     */
    private String loginBannerStatus;

    /**
     * 七牛回调
     * */
    private String qiNiuUploadCallBack;

    public String getQiNiuUploadCallBack() {
        return qiNiuUploadCallBack;
    }

    public void setQiNiuUploadCallBack(String qiNiuUploadCallBack) {
        this.qiNiuUploadCallBack = qiNiuUploadCallBack;
    }

    public String getLoginBannerName() {
        return loginBannerName;
    }

    public void setLoginBannerName(String loginBannerName) {
        this.loginBannerName = loginBannerName;
    }

    public String getLoginBannerUrl() {
        return loginBannerUrl;
    }

    public void setLoginBannerUrl(String loginBannerUrl) {
        this.loginBannerUrl = loginBannerUrl;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public String getLoginBannerStatus() {
        return loginBannerStatus;
    }

    public void setLoginBannerStatus(String loginBannerStatus) {
        this.loginBannerStatus = loginBannerStatus;
    }
}
