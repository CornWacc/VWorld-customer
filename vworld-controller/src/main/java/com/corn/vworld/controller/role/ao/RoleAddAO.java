package com.corn.vworld.controller.role.ao;

import com.corn.boot.base.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yyc
 * @apiNote 用户权限新增入参
 * */
@ApiModel(description = "权限新增实体")
public class RoleAddAO extends Base {
    private static final long serialVersionUID = 337961947150245004L;

    /**
     * 权限名称
     * */
    @ApiModelProperty(name = "roleName",value = "权限名称")
    @NotBlank(message = "权限名称不能为空")
    private String roleName;

    /**
     * 权限等级
     * */
    @ApiModelProperty(name = "roleLevel",value = "权限等级")
    @NotNull(message = "权限等级不能为空")
    private Integer roleLevel;

    /**
     * 权限父级id
     * */
    @ApiModelProperty(name = "roleParentId",value = "权限名称")
    @NotBlank(message = "权限名称不能为空")
    private String roleParentId;

    /**
     * 创建用户
     * */
    @ApiModelProperty(name = "byUserId",value = "创建用户")
    @NotBlank(message = "创建用户Id不能为空")
    private String byUserId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getRoleParentId() {
        return roleParentId;
    }

    public void setRoleParentId(String roleParentId) {
        this.roleParentId = roleParentId;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }
}
