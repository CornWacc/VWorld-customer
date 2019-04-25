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
        log.info("业务[权限列表查询],出参:{}",result);
        return result;
    }

    @Override
    public RoleDelResult roleDel(RoleDelOrder order) {
        log.info("业务[权限删除],入参:{}",order);
        RoleDelResult result = roleFacade.roleDel(order);
        log.info("业务[权限删除],出参:{}",result);
        return result;
    }

    @Override
    public RoleListQueryByLevelResult roleListQueryByLevel(RoleListQueryByLevelOrder order) {
        log.info("业务[权限根据等级查询列表],入参:{}",order);
        RoleListQueryByLevelResult result = roleFacade.roleListQueryByLevel(order);
        log.info("业务[权限根据等级查询列表],出参:{}",result);
        return result;    }

    @Override
    public RoleListQueryBySuperiorIdResult roleListQueryBySuperiosId(RoleListQueryBySuperiorIdOrder order) {
        log.info("业务[权限列表查询根据权限父级id],入参:{}",order);
        RoleListQueryBySuperiorIdResult result = roleFacade.roleListQueryBySuperiorId(order);
        log.info("业务[权限列表查询根据权限父级id],出参:{}",order);
        return result;
    }

    @Override
    public RoleTreeListQueryResult roleTreeListQuery(RoleTreeListQueryOrder order) {
        log.info("业务[权限树列表查询],入参:{}",order);
        RoleTreeListQueryResult result = roleFacade.roleTreeListQuery(order);
        log.info("业务[权限树列表查询],出参:{}",order);
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
