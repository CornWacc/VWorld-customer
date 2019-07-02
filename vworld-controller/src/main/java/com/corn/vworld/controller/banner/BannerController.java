package com.corn.vworld.controller.banner;


import com.corn.boot.base.JsonResult;
import com.corn.boot.enums.SwitchEnum;
import com.corn.boot.util.AppUtils;
import com.corn.vworld.controller.banner.ao.MainBannerAddAO;
import com.corn.vworld.controller.banner.ao.MainBannerDelAO;
import com.corn.vworld.controller.banner.ao.MainBannerListPageQueryAO;
import com.corn.vworld.facade.banner.add.MainBannerAddOrder;
import com.corn.vworld.facade.banner.add.MainBannerAddResult;
import com.corn.vworld.facade.banner.del.MainBannerDelOrder;
import com.corn.vworld.facade.banner.del.MainBannerDelResult;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryOrder;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryResult;
import com.corn.vworld.integration.banner.BannerFacadeClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


/**
 * @author yyc
 * @apiNote 广告业务controller
 * */
@RestController
@RequestMapping("/banner")
@Api(description = "广告业务controller")
public class BannerController {

    @Autowired
    private BannerFacadeClient bannerFacadeClient;

    @ApiOperation(value = "主页广告分页查询接口",notes = "主页广告分页查询")
    @GetMapping("/mainBannerListPageQuery")
    public JsonResult mainBannerListPageQuery(MainBannerListPageQueryAO ao){

        MainBannerListPageQueryOrder order = new MainBannerListPageQueryOrder();
        BeanUtils.copyProperties(ao,order);
        order.setMainBannerStatus(SwitchEnum.getByCode(ao.getMainBannerStatus()));
        order.setSerialNo(AppUtils.appCode("mainBannerListPageQuery"));

        MainBannerListPageQueryResult result = bannerFacadeClient.mainBannerListPageQuery(order);
        return new JsonResult(result);
    }

    @ApiOperation(value = "主页广告新增接口",notes = "主页广告新增")
    @PostMapping("/mainBannerAdd")
    public JsonResult mainBannerAdd(@RequestBody @Valid MainBannerAddAO ao){

        MainBannerAddOrder order = new MainBannerAddOrder();
        BeanUtils.copyProperties(ao,order);
        order.setSerialNo(AppUtils.appCode("mainBannerAdd"));
        order.setCreateTime(new Date());

        MainBannerAddResult result = bannerFacadeClient.mainBannerAdd(order);

        return new JsonResult(result);
    }

    @ApiOperation(value = "主页广告新增接口",notes = "主页广告新增")
    @PostMapping("/mainBannerDel")
    public JsonResult mainBannerDel(@RequestBody @Valid MainBannerDelAO ao){

        MainBannerDelOrder order = new MainBannerDelOrder();
        BeanUtils.copyProperties(ao,order);
        order.setSerialNo(AppUtils.appCode("mainBannerDel"));

        MainBannerDelResult result = bannerFacadeClient.mainBannerDel(order);

        return new JsonResult(result);
    }
}

