package com.corn.vworld.integration.role;

import com.corn.vworld.facade.role.RoleAddOrder;
import com.corn.vworld.facade.role.RoleAddResult;
import com.corn.vworld.facade.role.RoleListQueryOrder;
import com.corn.vworld.facade.role.RoleListQueryResult;

public interface RoleFacadeClient {


    /**
     * 权限列表查询
     * */
    RoleListQueryResult roleListQuery(RoleListQueryOrder order);

    /**
     * 权限新增
     * */
    RoleAddResult roleAdd(RoleAddOrder order);
}
