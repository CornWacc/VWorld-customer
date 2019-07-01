package com.corn.vworld.controller.user.ao;

import com.corn.boot.base.Base;
import com.corn.vworld.common.util.ConstantParamsGetUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;


/**
 * @author yyc
 * @apiNote 用户注册入参
 * */
@ApiModel(description = "用户注册入参实体")
public class UserRegAO extends Base {
    private static final long serialVersionUID = -1267222895923043768L;


    @ApiModelProperty(value = "用户账号",name = "userAccount")
    @NotBlank(message = "用户账号不能为空")
    private String userAccount;

    @ApiModelProperty(value = "用户密码",name = "userPassword")
    @NotBlank(message = "用户密码不能为空")
    private String userPassword;

    @ApiModelProperty(value = "用户名称",name = "userName")
    @NotBlank(message = "用户名称不能为空")
    private String userName;

    @ApiModelProperty(value = "用户邮箱",name = "userEmail")
    @NotBlank(message = "用户邮箱不能为空")
    private String userEmail;

    @ApiModelProperty(value = "用户手机号",name = "userPhone")
    @NotBlank(message = "用户手机号不能为空")
    private String userPhone;

    @ApiModelProperty(value = "用户头像",name = "userAvatar")
    @NotBlank(message = "用户头像不能为空")
    private String userAvatar;

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = ConstantParamsGetUtil.QINIU_IMAGE_URL_PREFIX+"/"+userAvatar;
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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
