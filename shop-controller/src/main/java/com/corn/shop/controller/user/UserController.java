package com.corn.shop.controller.user;


import com.corn.boot.base.JsonResult;
import com.corn.boot.util.AppUtils;
import com.corn.shop.controller.user.ao.UserLoginAO;
import com.corn.shop.controller.user.ao.UserRegAO;
import com.corn.shop.facade.user.UserLoginOrder;
import com.corn.shop.facade.user.UserLoginResult;
import com.corn.shop.facade.user.UserRegOrder;
import com.corn.shop.facade.user.UserRegResult;
import com.corn.shop.integration.user.UserFacadeClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;


@RequestMapping(value = "/user")
@RestController
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
        UserRegResult regResult = userFacadeClient.userReg(order);
        return new JsonResult(regResult);

    }

}
