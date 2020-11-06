package com.yuk.source.springboot;

import cn.hutool.core.util.ArrayUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class SpringUtils {

    public static void printAllBean(ApplicationContext applicationContext, Class[] includeFilterArray) {
        if (null == applicationContext) {
            return;
        }
        Set<String> filterSet = new HashSet<>();
        if (ArrayUtil.isNotEmpty(includeFilterArray)) {
            for (Class aClass : includeFilterArray) {
                filterSet.add(aClass.getSimpleName());
            }
        }
        System.out.println("[printAllBean]before print, filterSet:" + filterSet);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            for (String filter : filterSet) {
                if (StringUtils.contains(beanDefinitionName, filter)) {
                    System.out.println("loaded beanDefinitionName:"+beanDefinitionName);
                }
            }
        }
        System.out.println("[printAllBean]after print");
    }
}
