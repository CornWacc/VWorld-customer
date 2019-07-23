package com.corn.vworld.controller.user.ao;

import com.corn.boot.base.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author yyc
 * @apiNote 用户登陆接口入参
 * */
@ApiModel(description = "用户登陆入参")
public class UserLoginAO extends Base {
    private static final long serialVersionUID = -5068528599515690357L;

    @ApiModelProperty(name = "userAccount",required = true,value = "用户账号")
    private String userAccount;

    @ApiModelProperty(name = "userPassword",required = true,value = "用户密码")
    private String userPassword;

    @ApiModelProperty(name = "imageCode",required = true,value = "验证码")
    private String imageCode;

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
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
}
