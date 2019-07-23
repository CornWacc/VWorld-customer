package com.corn.vworld.integration.banner;


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

    /**
     * 主页广告列表查询
     * */
    MainBannerListQueryResult mainBannerListQuery(MainBannerListQueryOrder order);

    /**
     * 登陆广告分页查询
     * */
    LoginBannerListPageQueryResult loginBannerListPageQuery(LoginBannerListPageQueryOrder order);

    /**
     * 登陆广告新增
     * */
    LoginBannerAddResult loginBannerAdd(LoginBannerAddOrder order);
}
