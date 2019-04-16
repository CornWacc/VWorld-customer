package com.corn.vworld.controller.user.ao;

import com.corn.boot.base.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author yyc
 * @apiNote 用户注册入参
 * */
@ApiModel(description = "用户注册入参实体")
public class UserRegAO extends Base {
    private static final long serialVersionUID = -1267222895923043768L;


    @ApiModelProperty(value = "用户账号",name = "userAccount")
    private String userAccount;

    @ApiModelProperty(value = "用户密码",name = "userPassword")
    private String userPassword;

    @ApiModelProperty(value = "用户名称",name = "userName")
    private String userName;

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
