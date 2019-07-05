package com.corn.vworld.controller.user;


import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.vworld.common.util.AccountCacheUtil;
import com.corn.vworld.controller.user.ao.*;
import com.corn.vworld.facade.user.*;
import com.corn.vworld.facade.user.del.UserDelOrder;
import com.corn.vworld.facade.user.del.UserDelResult;
import com.corn.vworld.facade.user.infoquery.UserInfoQueryOrder;
import com.corn.vworld.facade.user.infoquery.UserInfoQueryResult;
import com.corn.vworld.facade.user.login.UserLoginOrder;
import com.corn.vworld.facade.user.login.UserLoginResult;
import com.corn.vworld.facade.user.logout.UserLogOutOrder;
import com.corn.vworld.facade.user.logout.UserLogOutResult;
import com.corn.vworld.facade.user.pagequery.UserListPageQueryOrder;
import com.corn.vworld.facade.user.pagequery.UserListPageQueryResult;
import com.corn.vworld.facade.user.reg.UserRegOrder;
import com.corn.vworld.facade.user.reg.UserRegResult;
import com.corn.vworld.facade.user.update.UserUpdateOrder;
import com.corn.vworld.facade.user.update.UserUpdateResult;
import com.corn.vworld.integration.user.UserFacadeClient;
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

    @PostMapping("/userLogin")
    @ApiOperation(value = "用户登录",notes = "用户登陆接口")
    public JsonResult userLogin(@RequestBody UserLoginAO userLoginAO){

        UserLoginOrder order = new UserLoginOrder();
        order.setSerialNo(AppUtils.appCode("userLogin"));
        BeanUtils.copyProperties(userLoginAO,order);

        UserLoginResult result = userFacadeClient.userLogin(order);

        AccountCacheUtil.setAccountCache(result);

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

    @GetMapping("/userListPageQuery")
    @ApiOperation(value = "用户列表分页查询",notes = "用户列表分页查询接口")
    public JsonResult userListPageQuery(UserListPageQueryAO ao){

        UserListPageQueryOrder order = new UserListPageQueryOrder();
        order.setSerialNo(AppUtils.appCode("userListPageQuery"));
        order.setKeyWord(ao.getKeyWord());
        order.setType(ao.getType());
        order.setPageNum(ao.getPageNum());
        order.setPageSize(ao.getPageSize());
        UserListPageQueryResult result = userFacadeClient.userListPageQuery(order);
        return new JsonResult(result);
    }

    @GetMapping("/userDel")
    @ApiOperation(value = "用户删除",notes = "用户删除接口")
    public JsonResult userDel(String userId){

        UserDelOrder order = new UserDelOrder();
        order.setSerialNo(AppUtils.appCode("userDel"));
        order.setUserId(userId);

        UserDelResult result = userFacadeClient.userDel(order);
        return new JsonResult(result);
    }

    @GetMapping("/userLogOut")
    @ApiOperation(value = "用户注销",notes = "用户注销接口")
    public JsonResult userLogOut(String userId){

        UserLogOutOrder outOrder = new UserLogOutOrder();
        outOrder.setUserId(userId);
        outOrder.setSerialNo(AppUtils.appCode("userLogOut"));

        UserLogOutResult result = userFacadeClient.userLogOut(outOrder);

        //清除缓存
        AccountCacheUtil.clear();
        return new JsonResult(result);
    }

    @PostMapping("/userUpdate")
    @ApiOperation(value = "用户更新",notes = "用户更新接口")
    public JsonResult userUpdate(@RequestBody UserUpdateAO ao){

        UserUpdateOrder order = new UserUpdateOrder();
        BeanUtils.copyProperties(ao,order);
        order.setSerialNo(AppUtils.appCode("userUpdate"));

        UserUpdateResult result = userFacadeClient.userUpdate(order);

        return new JsonResult(result);
    }

}
