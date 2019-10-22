package com.corn.vworld.integration.banner;

import com.corn.vworld.facade.banner.BannerFacade;
import com.corn.vworld.facade.banner.add.LoginBannerAddOrder;
import com.corn.vworld.facade.banner.add.LoginBannerAddResult;
import com.corn.vworld.facade.banner.add.MainBannerAddOrder;
import com.corn.vworld.facade.banner.add.MainBannerAddResult;
import com.corn.vworld.facade.banner.del.MainBannerDelOrder;
import com.corn.vworld.facade.banner.del.MainBannerDelResult;
import com.corn.vworld.facade.banner.listquery.MainBannerListQueryOrder;
import com.corn.vworld.facade.banner.listquery.MainBannerListQueryResult;
import com.corn.vworld.facade.banner.pagequery.LoginBannerListPageQueryOrder;
import com.corn.vworld.facade.banner.pagequery.LoginBannerListPageQueryResult;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryOrder;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryResult;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author yyc
 * @apiNote 广告业务客户端实现
 * */
@Service
public class BannerFacadeClientImpl implements BannerFacadeClient {

    private static final Logger log = LoggerFactory.getLogger(BannerFacadeClientImpl.class);

    @Reference(version = "1.0")
    private BannerFacade bannerFacade;

    @Override
    public MainBannerListPageQueryResult mainBannerListPageQuery(MainBannerListPageQueryOrder order) {
        log.info("业务[主页广告分页列表查询],入参:{}",order);
        MainBannerListPageQueryResult result = bannerFacade.mainBannerListPageQuery(order);
        log.info("业务[主页广告分页列表查询],出参:{}",result);
        return result;
    }

    @Override
    public MainBannerAddResult mainBannerAdd(MainBannerAddOrder order) {
        log.info("业务[主页广告新增],入参:{}",order);
        MainBannerAddResult result = bannerFacade.mainBannerAdd(order);
        log.info("业务[主页广告新增],出参:{}",result);
        return result;
    }

    @Override
    public MainBannerDelResult mainBannerDel(MainBannerDelOrder order) {
        log.info("业务[主页广告删除],入参:{}",order);
        MainBannerDelResult result = bannerFacade.mainBannerDel(order);
        log.info("业务[主页广告删除],出参:{}",result);
        return result;
    }

    @Override
    public MainBannerListQueryResult mainBannerListQuery(MainBannerListQueryOrder order) {
        log.info("业务[主页广告列表查询],入参:{}",order);
        MainBannerListQueryResult result = bannerFacade.mainBannerListQuery(order);
        log.info("业务[主页广告列表查询],出参:{}",result);
        return result;
    }

    @Override
    public LoginBannerListPageQueryResult loginBannerListPageQuery(LoginBannerListPageQueryOrder order) {
        log.info("业务[登陆广告分页查询],入参:{}",order);
        LoginBannerListPageQueryResult result = bannerFacade.loginBannerListPageQuery(order);
        log.info("业务[登陆广告分页查询],出参:{}",result);
        return result;
    }

    @Override
    public LoginBannerAddResult loginBannerAdd(LoginBannerAddOrder order) {
        log.info("业务[登录广告新增],入参:{}",order);
        LoginBannerAddResult result = bannerFacade.loginBannerAdd(order);
        log.info("业务[登录广告新增],出参:{}",result);
        return result;
    }
}
