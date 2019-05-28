package com.corn.vworld.controller.role.ao;

import com.corn.boot.base.PageOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author yyc
 * @apiNote 用户权限列表查询接口入参
 * */
@ApiModel(description = "权限列表查询实体")
public class RoleListPageQueryAO extends PageOrder {
    private static final long serialVersionUID = 8286476257697506215L;

    @ApiModelProperty(value = "权限等级",name = "roleLevel")
    private Integer roleLevel;

    @ApiModelProperty(value = "创建用户",name = "byUserId")
    private String byUserId;


    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }

}
