package com.corn.vworld.common.util;

import com.corn.boot.base.BaseRes;
import com.corn.boot.error.BizError;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote 用户线程缓存
 * */
public class AccountCacheUtil {

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
            throw new BizError("用户缓存设置失败");
        }
    }

    /**
     * 获取用户线程缓存信息
     * */
    public static Object getAccountCache(){
        return params.get();
    }
}
