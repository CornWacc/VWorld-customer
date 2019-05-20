package com.corn.vworld.controller.role.ao;

import com.corn.boot.base.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * @author yyc
 * @apiNote 权限删除接口实体
 * */
@ApiModel(description = "权限删除实体")
public class RoleDelAO extends Base {
    private static final long serialVersionUID = -5141851807836616053L;

    /**
     * 权限id
     * */
    @ApiModelProperty(value = "权限id",name = "roleId")
//    @NotNull(message = "权限id不能为空")
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
