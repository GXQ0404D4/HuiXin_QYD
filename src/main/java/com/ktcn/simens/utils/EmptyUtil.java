package com.ktcn.simens.utils;

import java.util.List;

import org.springframework.stereotype.Component;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月18日 下午2:24:21
* 类说明
*/
@Component
public class EmptyUtil {

    /**
     * 判断对象为空
     * 
     * @param obj
     *            对象名
     * @return 是否为空
     */
    @SuppressWarnings("rawtypes")
	public  boolean isEmpty(Object obj)
    {
        if (obj == null)
        {
            return true;
        }
        if ((obj instanceof List))
        {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String))
        {
            return ((String) obj).trim().equals("");
        }
        return false;
    }
    
    /**
     * 判断对象不为空
     * 
     * @param obj
     *            对象名
     * @return 是否不为空
     */
    public  boolean isNotEmpty(Object obj)
    {
        return !isEmpty(obj);
    }

}
