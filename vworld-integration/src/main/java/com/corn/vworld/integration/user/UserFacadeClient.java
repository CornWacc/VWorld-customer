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
import com.corn.vworld.facade.user.update.UserUpdateOrder;
import com.corn.vworld.facade.user.update.UserUpdateResult;

/**
 * @author yyc
 * @apiNote 用户服务
 * */
public interface UserFacadeClient {

    /**
     * 用户登录
     * */
    UserLoginResult userLogin(UserLoginOrder order);

    /**
     * 用户注册
     * */
    UserRegResult userReg(UserRegOrder order);

    /**
     * 忘记密码
     * */
    UserForgetPasswordResult userForget(UserForgetPasswordOrder order);

    /**
     * 用户基础信息查询
     * */
    UserInfoQueryResult userInfoQuery(UserInfoQueryOrder order);

    /**
     * 用户列表分页查询
     * */
    UserListPageQueryResult userListPageQuery(UserListPageQueryOrder order);

    /**
     * 删除用户
     * */
    UserDelResult userDel(UserDelOrder order);

    /**
     * 用户注销
     * */
    UserLogOutResult userLogOut(UserLogOutOrder order);

    /**
     * 用户更新
     * */
    UserUpdateResult userUpdate(UserUpdateOrder order);
}
