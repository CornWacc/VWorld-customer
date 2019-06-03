package com.corn.vworld.integration.user;


import com.corn.vworld.facade.user.del.UserDelOrder;
import com.corn.vworld.facade.user.del.UserDelResult;
import com.corn.vworld.facade.user.forgetpassword.UserForgetPasswordOrder;
import com.corn.vworld.facade.user.forgetpassword.UserForgetPasswordResult;
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

    UserDelResult userDel(UserDelOrder order);

    UserLogOutResult userLogOut(UserLogOutOrder order);
}
