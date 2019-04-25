package com.corn.vworld.integration.role;


import com.corn.vworld.facade.role.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyc
 * @apiNote 权限操作消费端实现
 * */
@Service
public class RoleFacadeClientImpl implements RoleFacadeClient {

    private static final Logger log = LoggerFactory.getLogger(RoleFacadeClientImpl.class);

    @Autowired
    private RoleFacade roleFacade;

    @Override
    public RoleListQueryResult roleListQuery(RoleListQueryOrder order) {
        log.info("业务[权限列表查询],入参:{}",order);
        RoleListQueryResult result = roleFacade.roleListQuery(order);
        log.info("业务[权限列表查询],出参:{}",order);
        return result;
    }

    @Override
    public RoleAddResult roleAdd(RoleAddOrder order) {
        log.info("业务[权限新增],入参:{}",order);
        RoleAddResult result = roleFacade.roleAdd(order);
        log.info("业务[权限新增],出参:{}",order);
        return result;
    }
}
