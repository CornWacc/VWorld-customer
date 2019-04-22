package com.corn.vworld.integration.user;


import com.corn.vworld.facade.user.*;

/**
 * @author yyc
 * @apiNote 用户服务
 * */
public interface UserFacadeClient {

    UserLoginResult userLogin(UserLoginOrder order);

    UserRegResult userReg(UserRegOrder order);

    UserForgetPasswordResult userForget(UserForgetPasswordOrder order);

    UserInfoQueryResult userInfoQuery(UserInfoQueryOrder order);

    UserListPageQueryResult userListPageQuery(UserListPageQueryOrder order);
}
