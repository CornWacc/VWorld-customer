package com.corn.vworld.integration.banner;

import com.corn.vworld.facade.banner.BannerFacade;
import com.corn.vworld.facade.banner.add.MainBannerAddOrder;
import com.corn.vworld.facade.banner.add.MainBannerAddResult;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryOrder;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryResult;
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

    @Autowired
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
}
