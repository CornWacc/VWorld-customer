package com.corn.vworld.integration.role;

import com.corn.vworld.facade.role.RoleListQueryOrder;
import com.corn.vworld.facade.role.RoleListQueryResult;

public interface RoleFacadeClient {


    RoleListQueryResult roleListQuery(RoleListQueryOrder order);
}
