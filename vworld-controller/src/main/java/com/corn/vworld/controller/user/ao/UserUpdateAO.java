package com.corn.vworld.controller.user.ao;

import com.corn.boot.base.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;


/**
 * @author yyc
 * @apiNote 用户更新ctrl入参实体
 * */

@ApiModel(description = "用户更新入参实体")
public class UserUpdateAO extends Base {

    private static final long serialVersionUID = 8278679981300012493L;

    /**
     * 用户id
     * */
    @ApiModelProperty(value = "用户id",name = "userId")
    private String userId;

    /**
     * 用户名称
     * */
    @ApiModelProperty(value = "用户名称",name = "userName")
    private String userName;

    /**
     * 更新人id
     * */
    @ApiModelProperty(value = "更新人id",name = "updateUserId")
    private String updateUserId;

    /**
     * 更新人权限id
     * */
    @ApiModelProperty(value = "更新人权限id",name = "updateUserRoleId")
    private String updateUserRoleId;

    /**
     * 用户邮箱
     * */
    @ApiModelProperty(value = "用户邮箱",name = "userEmail")
    private String userEmail;

    /**
     * 用户手机号
     * */
    @ApiModelProperty(value = "用户手机号",name = "userPhone")
    private String userPhone;

    /**
     * 用户更改的权限
     * */
    @ApiModelProperty(value = "用户更改的权限",name = "userRoleId")
    private String userRoleId;

    /**
     * 用户状态
     * */
    @ApiModelProperty(value = "用户状态",name = "userStatus")
    private String userStatus;

    /**
     * 用户头像
     * */
    @ApiModelProperty(value = "用户头像",name = "userAvatar")
    private String userAvatar;


    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserRoleId() {
        return updateUserRoleId;
    }

    public void setUpdateUserRoleId(String updateUserRoleId) {
        this.updateUserRoleId = updateUserRoleId;
    }
}
