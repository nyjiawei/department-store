package com.fjw.provide.utils;

import com.fjw.provide.enums.ResponseEnum;
import com.fjw.provide.exception.ApplicationException;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author：jiawei
 * @CreateTime：2025-03-07 15:51
 * @Description：TODO
 * @Version：1.0
 **/
public class DefinedExceptionUtils {

    private DefinedExceptionUtils(){}

    @SneakyThrows
    public static void isNull(Object object) {
        if(object == null){
            throw new ApplicationException(ResponseEnum.ERROR);
        }
    }

    @SneakyThrows
    public static void isEmpty(Collection<?> list) {
        if(CollectionUtils.isEmpty(list)){
            throw new ApplicationException(ResponseEnum.ERROR);
        }
    }

}
