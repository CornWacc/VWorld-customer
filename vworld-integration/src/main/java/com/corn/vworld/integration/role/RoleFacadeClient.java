package com.corn.vworld.integration.role;

import com.corn.vworld.facade.role.del.RoleDelOrder;
import com.corn.vworld.facade.role.del.RoleDelResult;
import com.corn.vworld.facade.role.listquery.*;
import com.corn.vworld.facade.role.pagequery.RoleListPageQueryOrder;
import com.corn.vworld.facade.role.pagequery.RoleListPageQueryResult;
import com.corn.vworld.facade.role.roleadd.RoleAddOrder;
import com.corn.vworld.facade.role.roleadd.RoleAddResult;

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
     * 权限列表分页查询
     * */
    RoleListPageQueryResult roleListPageQuery(RoleListPageQueryOrder order);

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
