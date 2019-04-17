package com.corn.vworld.integration.role;


import com.corn.vworld.facade.role.RoleFacade;
import com.corn.vworld.facade.role.RoleListQueryOrder;
import com.corn.vworld.facade.role.RoleListQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleFacadeClientImpl implements RoleFacadeClient {

    @Autowired
    private RoleFacade roleFacade;

    @Override
    public RoleListQueryResult roleListQuery(RoleListQueryOrder order) {
        RoleListQueryResult result = roleFacade.roleListQuery(order);
        return result;
    }
}
