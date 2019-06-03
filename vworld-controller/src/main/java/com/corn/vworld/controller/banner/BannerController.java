package com.corn.vworld.controller.banner;


import com.corn.boot.base.JsonResult;
import com.corn.boot.enums.SwitchEnum;
import com.corn.boot.util.AppUtils;
import com.corn.vworld.controller.banner.ao.MainBannerListPageQueryAO;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryOrder;
import com.corn.vworld.facade.banner.pagequery.MainBannerListPageQueryResult;
import com.corn.vworld.integration.banner.BannerFacadeClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        System.out.println(order);
        System.out.println(ao);
        BeanUtils.copyProperties(ao,order);
        order.setMainBannerStatus(SwitchEnum.getByCode(ao.getMainBannerStatus()));
        order.setSerialNo(AppUtils.appCode(""));

        MainBannerListPageQueryResult result = bannerFacadeClient.mainBannerListPageQuery(order);
        return new JsonResult(result);
    }
}
