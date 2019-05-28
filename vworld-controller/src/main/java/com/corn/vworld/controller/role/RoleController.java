package com.corn.vworld.controller.role;

import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vworld.controller.role.ao.RoleAddAO;
import com.corn.vworld.controller.role.ao.RoleDelAO;
import com.corn.vworld.controller.role.ao.RoleListPageQueryAO;
import com.corn.vworld.facade.role.*;
import com.corn.vworld.integration.role.RoleFacadeClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/role")
@Api(description = "用户权限操作")
public class RoleController {

    @Autowired
    private RoleFacadeClient roleFacadeClient;

    @ApiOperation(notes = "用户权限新增接口",value = "用户权限新增")
    @PostMapping("/roleAdd")
    public JsonResult roleAdd(@RequestBody @Valid RoleAddAO ao){

        RoleAddOrder order = new RoleAddOrder();
        order.setSerialNo(AppUtils.appCode("roleAdd"));
        BeanUtils.copyProperties(ao,order);

        RoleAddResult result = roleFacadeClient.roleAdd(order);
        return new JsonResult(result);
    }

    @ApiOperation(notes = "用户权限列表分页查询接口",value = "权限列表分页查询")
    @GetMapping("/roleListPageQuery")
    public JsonResult roleListPageQuery(RoleListPageQueryAO ao){

        RoleListPageQueryOrder order = new RoleListPageQueryOrder();
        BeanUtils.copyProperties(ao,order);
        order.setSerialNo(AppUtils.appCode("roleListQuery"));

        RoleListPageQueryResult result = roleFacadeClient.roleListPageQuery(order);
        return new JsonResult(result);
    }

    @ApiOperation(notes = "用户权限列表根据权限等级查询接口",value = "用户权限列表根据权限等级查询")
    @GetMapping("/roleListQueryByLevel")
    public JsonResult roleListQueryByLevel(@RequestParam(name = "roleLevel")Integer roleLevel){

        RoleListQueryByLevelOrder order = new RoleListQueryByLevelOrder();
        order.setLevel(roleLevel);
        order.setSerialNo(AppUtils.appCode("roleListQueryByLevel"));

        RoleListQueryByLevelResult result = roleFacadeClient.roleListQueryByLevel(order);
        return new JsonResult(result);
    }

    @ApiOperation(notes = "用户权限列表根据权限父级id查询接口",value = "用户权限列表根据权限父级id查询")
    @GetMapping("/roleListQueryBySuperiorId")
    public JsonResult roleListQueryBySuperiorId(@RequestParam(name = "roleParentId")String roleParentId){

        RoleListQueryBySuperiorIdOrder order = new RoleListQueryBySuperiorIdOrder();
        order.setParentId(roleParentId);
        order.setSerialNo(AppUtils.appCode("roleListQueryBySuperiorId"));

        RoleListQueryBySuperiorIdResult result = roleFacadeClient.roleListQueryBySuperiosId(order);

        return new JsonResult(result);
    }

    @ApiOperation(notes = "用户权限删除根据用户Id接口",value = "用户权限删除根据用户id")
    @PostMapping("/roleDel")
    public JsonResult roleDel(@RequestBody  RoleDelAO ao){

        RoleDelOrder order = new RoleDelOrder();
        order.setSerialNo(AppUtils.appCode("roleDel"));
        order.setRoleId(ao.getRoleId());

        RoleDelResult roleDelResult = roleFacadeClient.roleDel(order);
        return new JsonResult(roleDelResult);

    }

    @ApiOperation(notes = "用户权限树查询",value = "用户权限树列表查询")
    @GetMapping("/roleListTreeQuery")
    public JsonResult roleListTreeQuery(){

        RoleTreeListQueryOrder order = new RoleTreeListQueryOrder();
        order.setSerialNo(AppUtils.appCode("roleListTreeQuery"));

        RoleTreeListQueryResult result = roleFacadeClient.roleTreeListQuery(order);
        return new JsonResult(result);
    }

}
