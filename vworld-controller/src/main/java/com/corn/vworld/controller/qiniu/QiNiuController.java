package com.corn.vworld.controller.qiniu;


import com.corn.boot.base.JsonResult;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yyc
 * @apiNote 七牛接口
 * */
@RestController
public class QiNiuController {

    private static final String ACCESS_KEY = "6TQ8uNsVezZcP5esrO5YuJ3VAaUqxULRBFh6FfTR";

    private static final String SECRET_KEY = "t4yfdnzUNYhaRCBRt-rgE8n6HaxzSPgQrcQZLsXe";

    private static final String BUCKET_NAME = "vworld";

    @GetMapping("/getQiNiuToken")
    public JsonResult getQiNiuToken(){

        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String token  = auth.uploadToken(BUCKET_NAME);
        return new JsonResult(token);
    }

}
