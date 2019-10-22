package com.corn.vworld.controller.qiniu;


import com.corn.boot.base.JsonResult;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yyc
 * @apiNote 七牛接口
 * */
@RestController
public class QiNiuController {

    private static final Logger log = LoggerFactory.getLogger(QiNiuController.class);

    private static final String ACCESS_KEY = "6TQ8uNsVezZcP5esrO5YuJ3VAaUqxULRBFh6FfTR";

    private static final String SECRET_KEY = "t4yfdnzUNYhaRCBRt-rgE8n6HaxzSPgQrcQZLsXe";

    private static final String BUCKET_NAME = "vworld";

    @GetMapping("/getQiNiuToken")
    public JsonResult getQiNiuToken(){
        log.info("------------- 请求七牛地址 -----------");
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String token  = auth.uploadToken(BUCKET_NAME);
        log.info("七牛地址回调token:{}",token);
        return new JsonResult(token);
    }

}
