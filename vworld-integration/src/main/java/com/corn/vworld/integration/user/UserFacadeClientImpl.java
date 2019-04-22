package com.corn.vworld.integration.user;

import com.corn.vworld.facade.user.*;
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

    @Autowired
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
        log.info("业务[用户基础信息查询],入参:{}",order);
        UserListPageQueryResult result = userFacade.userPageQuery(order);
        log.info("业务[用户基础信息查询],出参:{}",result);
        return result;    }

}
