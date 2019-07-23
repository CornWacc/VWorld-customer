package com.corn.vworld.controller.common;


import com.corn.boot.base.ImageCode;
import com.corn.boot.base.JsonResult;
import com.corn.boot.util.CaptchaUtil;
import com.corn.vworld.common.util.RedisOperator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ImageCodeController{

    @Autowired
    private RedisOperator redisOperator;

    @GetMapping("/imageCode")
    public JsonResult getImageCode(@Param("oldImageCode")String oldImageCode){
        ImageCode code = CaptchaUtil.outputImage();
        //移除之前的缓存
        redisOperator.del(ImageCode.IMAGE_CODE_REDIS+oldImageCode);
        redisOperator.set(ImageCode.IMAGE_CODE_REDIS+code.getCode(),code.getBase64Image(),60);
        return new JsonResult(code);
    }
}
