package com.corn.vworld.integration.banner;


import com.corn.vworld.facade.banner.add.MainBannerAddOrder;
import com.corn.vworld.facade.banner.add.MainBannerAddResult;
import com.corn.vworld.facade.banner.del.MainBannerDelOrder;
import com.corn.vworld.facade.banner.del.MainBannerDelResult;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryOrder;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryResult;

/**
 * @author yyc
 * @apiNote 广告接口客户端
 * */
public interface BannerFacadeClient {

    /**
     * 主页广告分页查询
     * */
    MainBannerListPageQueryResult mainBannerListPageQuery(MainBannerListPageQueryOrder order);

    /**
     * 主页广告新增
     * */
    MainBannerAddResult mainBannerAdd(MainBannerAddOrder order);

    /**
     * 主页广告删除
     * */
    MainBannerDelResult mainBannerDel(MainBannerDelOrder order);
}
