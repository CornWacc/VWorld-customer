package com.corn.vworld.integration.user;

import com.corn.vworld.facade.user.UserFacade;
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
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author yyc
 * @apiNote 用户业务客户端
 * */
@Service
public class UserFacadeClientImpl implements UserFacadeClient {

    private static final Logger log = LoggerFactory.getLogger(UserFacadeClient.class);

    @Reference(version = "1.0")
    private UserFacade userFacade;


    @Override
    public UserLoginResult userLogin(UserLoginOrder order) {
        log.info("业务[用户登录],入参:{}",order);
        UserLoginResult result = userFacade.userLogin(order);
        log.info("业务[用户登录],出参:{}",result);
        return result;
    }

    @Override
    public UserRegResult userReg(UserRegOrder order) {
        log.info("业务[用户注册],入参:{}",order);
        UserRegResult result = userFacade.userReg(order);
        log.info("业务[用户注册],出参:{}",result);
        return result;
    }

    @Override
    public UserForgetPasswordResult userForget(UserForgetPasswordOrder order) {
        log.info("业务[用户忘记密码],入参:{}",order);
        UserForgetPasswordResult result = userFacade.passwordForget(order);
        log.info("业务[用户忘记密码],出参:{}",result);
        return result;
    }

    @Override
    public UserInfoQueryResult userInfoQuery(UserInfoQueryOrder order) {
        log.info("业务[用户基础信息查询],入参:{}",order);
        UserInfoQueryResult result = userFacade.userInfoQuery(order);
        log.info("业务[用户基础信息查询],出参:{}",result);
        return result;
    }

    @Override
    public UserListPageQueryResult userListPageQuery(UserListPageQueryOrder order) {
        log.info("业务[用户列表分页查询],入参:{}",order);
        UserListPageQueryResult result = userFacade.userPageQuery(order);
        log.info("业务[用户列表分页查询],出参:{}",result);
        return result;
    }

    @Override
    public UserDelResult userDel(UserDelOrder order) {
        log.info("业务[用户删除],入参:{}",order);
        UserDelResult result = userFacade.userDel(order);
        log.info("业务[用户删除],出参:{}",result);
        return result;
    }

    @Override
    public UserLogOutResult userLogOut(UserLogOutOrder order) {
        log.info("业务[用户注销],入参:{}",order);
        UserLogOutResult result = userFacade.userLogOut(order);
        log.info("业务[用户注销],出参:{}",result);
        return result;
    }

    @Override
    public UserUpdateResult userUpdate(UserUpdateOrder order) {
        log.info("业务[用户更新],入参:{}",order);
        UserUpdateResult result = userFacade.userUpdate(order);
        log.info("业务[用户更新],出参:{}",result);
        return result;
    }
}
