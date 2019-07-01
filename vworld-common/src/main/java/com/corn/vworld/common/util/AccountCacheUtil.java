package com.corn.vworld.common.util;

import com.corn.boot.base.BaseRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote 用户线程缓存
 * */
public class AccountCacheUtil {

    private static final Logger log = LoggerFactory.getLogger(AccountCacheUtil.class);

    private static final ThreadLocal<Object> params = new ThreadLocal<>();

    /**
     * 线程缓存清空
     * */
    public static void clear(){
        params.remove();
    }

    /**
     * 设置用户登陆后的后台缓存
     * */
    public static <T extends BaseRes> void  setAccountCache(T res){

        if(!ObjectUtils.isEmpty(res) && res.isSuccess()){
            params.set(res);
        }else{
            log.info("用户缓存失败, 原因:{}",res.getMessage());
        }
    }

    /**
     * 获取用户线程缓存信息
     * */
    public static Object getAccountCache(){
        return params.get();
    }
}
