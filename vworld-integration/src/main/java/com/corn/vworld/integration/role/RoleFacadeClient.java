package com.corn.vworld.integration.role;

import com.corn.vworld.facade.role.*;

public interface RoleFacadeClient {


    /**
     * 权限树列表查询
     * */
    RoleTreeListQueryResult roleTreeListQuery(RoleTreeListQueryOrder order);

    /**
     * 权限新增
     * */
    RoleAddResult roleAdd(RoleAddOrder order);

    /**
     * 权限列表查询
     * */
    RoleListQueryResult roleListQuery(RoleListQueryOrder order);

    /**
     * 权限删除
     * */
    RoleDelResult roleDel(RoleDelOrder order);

    /**
     * 权限列表根据等级查询列表
     * */
    RoleListQueryByLevelResult roleListQueryByLevel(RoleListQueryByLevelOrder order);

    /**
     * 权限列表根据权限父级id查询
     * */
    RoleListQueryBySuperiorIdResult roleListQueryBySuperiosId(RoleListQueryBySuperiorIdOrder order);
}
