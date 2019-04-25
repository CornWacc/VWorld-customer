package com.corn.vworld.controller.role;

import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vworld.controller.role.ao.RoleAddAO;
import com.corn.vworld.facade.role.RoleAddOrder;
import com.corn.vworld.facade.role.RoleAddResult;
import com.corn.vworld.integration.role.RoleFacadeClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
