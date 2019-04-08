package com.corn.shop.integration.user;


import com.corn.shop.facade.user.*;

/**
 * @author yyc
 * @apiNote 用户服务
 * */
public interface UserFacadeClient {

    UserLoginResult userLogin(UserLoginOrder order);

    UserRegResult userReg(UserRegOrder order);

    UserForgetPasswordResult userForget(UserForgetPasswordOrder order);
}
