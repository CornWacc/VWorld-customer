package com.corn.vworld.controller.banner;


import com.corn.boot.base.JsonResult;
import com.corn.boot.base.PageParamInfo;
import com.corn.boot.enums.SwitchEnum;
import com.corn.boot.util.AppUtils;
import com.corn.vworld.common.util.ConstantParamsGetUtil;
import com.corn.vworld.controller.banner.ao.LoginBannerAddAO;
import com.corn.vworld.controller.banner.ao.MainBannerAddAO;
import com.corn.vworld.controller.banner.ao.MainBannerDelAO;
import com.corn.vworld.controller.banner.ao.MainBannerListPageQueryAO;
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
import com.corn.vworld.facade.enums.UploadTypeEnums;
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
        order.setMainBannerStatus(SwitchEnum.getByCode(ao.getMainBannerStatus()));
        order.setSerialNo(AppUtils.appCode("mainBannerListPageQuery"));
        order.setPageParamInfo(ao.getPageParamInfo());
        MainBannerListPageQueryResult result = bannerFacadeClient.mainBannerListPageQuery(order);
        return new JsonResult(result);
    }

    @ApiOperation(value = "主页广告新增接口",notes = "主页广告新增")
    @PostMapping("/mainBannerAdd")
    public JsonResult mainBannerAdd(@RequestBody @Valid MainBannerAddAO ao){

        MainBannerAddOrder order = new MainBannerAddOrder();
        BeanUtils.copyProperties(ao,order);

        //如果是本地上传
        if(ao.getUploadType().equalsIgnoreCase(UploadTypeEnums.LOCAL.code())){
            order.setMainBannerUrl(ConstantParamsGetUtil.QINIU_IMAGE_URL_PREFIX+ao.getQiNiuUploadCallBack());
        }
        order.setSerialNo(AppUtils.appCode("mainBannerAdd"));
        order.setCreateTime(new Date());

        MainBannerAddResult result = bannerFacadeClient.mainBannerAdd(order);

        return new JsonResult(result);
    }

    @ApiOperation(value = "主页广告删除接口",notes = "主页广告删除")
    @PostMapping("/mainBannerDel")
    public JsonResult mainBannerDel(@RequestBody @Valid MainBannerDelAO ao){

        MainBannerDelOrder order = new MainBannerDelOrder();
        BeanUtils.copyProperties(ao,order);
        order.setSerialNo(AppUtils.appCode("mainBannerDel"));

        MainBannerDelResult result = bannerFacadeClient.mainBannerDel(order);

        return new JsonResult(result);
    }

    @ApiOperation(value = "主页广告列表查询接口",notes = "主页广告列表查询")
    @GetMapping("/mainBannerListQuery")
    public JsonResult mainBannerListQuery(){

        MainBannerListQueryOrder order = new MainBannerListQueryOrder();
        order.setSerialNo(AppUtils.appCode("mainBannerListQuery"));

        MainBannerListQueryResult result = bannerFacadeClient.mainBannerListQuery(order);

        return new JsonResult(result);
    }

    @ApiOperation(value = "登陆广告(分页)列表查询",notes = "登陆广告列表查询")
    @GetMapping("/loginBannerListPageQuery")
    public JsonResult loginBannerListPageQuery(MainBannerListPageQueryAO ao){

        LoginBannerListPageQueryOrder order = new LoginBannerListPageQueryOrder();
        order.setSerialNo(AppUtils.appCode("loginBannerListPageQuery"));
        order.setStatus(ao.getMainBannerStatus());
        order.setStartTime(ao.getStartTime());
        order.setEndTime(ao.getEndTime());
        order.setPageParamInfo(new PageParamInfo(1,5));
        LoginBannerListPageQueryResult result = bannerFacadeClient.loginBannerListPageQuery(order);

        return new JsonResult(result);
    }

    @ApiOperation(value = "登陆广告新增",notes = "登陆广告新增")
    @PostMapping("/loginBannerAdd")
    public JsonResult loginBannerAdd(@RequestBody LoginBannerAddAO ao){

        LoginBannerAddOrder order = new LoginBannerAddOrder();
        order.setSerialNo(AppUtils.appCode("loginBannerAdd"));
        BeanUtils.copyProperties(ao,order);
        if(ao.getUploadType().equalsIgnoreCase(UploadTypeEnums.LOCAL.code())){
            order.setLoginBannerUrl(ConstantParamsGetUtil.QINIU_IMAGE_URL_PREFIX+ao.getQiNiuUploadCallBack());
        }
        LoginBannerAddResult result = bannerFacadeClient.loginBannerAdd(order);
        return new JsonResult(result);
    }
}

