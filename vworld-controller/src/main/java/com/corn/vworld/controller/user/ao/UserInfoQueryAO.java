package com.corn.vworld.controller.user.ao;

import com.corn.boot.base.Base;


/**
 * @author yyc
 * @apiNote 用户基础信息查询入参
 * */
public class UserInfoQueryAO extends Base {
    private static final long serialVersionUID = -4348108160890539947L;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
