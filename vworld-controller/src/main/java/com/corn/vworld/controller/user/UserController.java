package com.corn.vworld.controller.user;


import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vworld.controller.user.ao.UserInfoQueryAO;
import com.corn.vworld.controller.user.ao.UserLoginAO;
import com.corn.vworld.controller.user.ao.UserRegAO;
import com.corn.vworld.facade.user.*;
import com.corn.vworld.integration.user.UserFacadeClient;
import com.corn.vworld.integration.user.UserFacadeClientImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/user")
@RestController
@Api(description = "用户操作")
public class UserController {

    @Autowired
    private UserFacadeClient userFacadeClient;

    @Autowired
    private UserFacadeClientImpl userFacadeClientI;

    @PostMapping("/userLogin")
    @ApiOperation(value = "用户登录",notes = "用户登陆接口")
    public JsonResult userLogin(@RequestBody UserLoginAO userLoginAO){

        UserLoginOrder order = new UserLoginOrder();
        order.setSerialNo(AppUtils.appCode("userLogin"));
        BeanUtils.copyProperties(userLoginAO,order);

        UserLoginResult result = userFacadeClient.userLogin(order);
        return new JsonResult(result);

    }

    @PostMapping("/userReg")
    @ApiOperation(value = "用户注册",notes = "用户注册接口")
    public JsonResult userReg(@RequestBody UserRegAO userRegAO){

        UserRegOrder order = new UserRegOrder();
        order.setSerialNo(AppUtils.appCode("userReg"));
        order.setUserAccount(userRegAO.getUserAccount());
        order.setUserName(userRegAO.getUserName());
        order.setUserPassword(userRegAO.getUserPassword());
        order.setUserEmail(userRegAO.getUserEmail());
        order.setUserPhone(userRegAO.getUserPhone());
        order.setUserAvatar(userRegAO.getUserAvatar());
        UserRegResult regResult = userFacadeClient.userReg(order);
        return new JsonResult(regResult);

    }

    @GetMapping("/userInfoQuery")
    @ApiOperation(value = "用户基础信息查询",notes = "用户基础信息查询接口")
    public JsonResult userInfoQuery(UserInfoQueryAO ao){

        UserInfoQueryOrder order = new UserInfoQueryOrder();
        order.setUserId(ao.getUserId());
        order.setSerialNo(AppUtils.appCode("userInfoQuery"));

        UserInfoQueryResult result = userFacadeClient.userInfoQuery(order);
        return new JsonResult(result);
    }

    @GetMapping("/test")
    @ApiOperation(value = "test",notes = "test")
    public void userInfoQuery(){

        userFacadeClientI.userListQuery();
    }
}
