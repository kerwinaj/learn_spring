package com.yuk.source.springboot;

import cn.hutool.core.util.ArrayUtil;
import com.yuk.source.springboot.dto.Dog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
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
                    System.out.println("[printAllBean]loaded beanDefinitionName:"+beanDefinitionName);
                }
            }
        }
        System.out.println("[printAllBean]after print");
    }

    public static void printBeanIgnoreException(ApplicationContext applicationContext, Class clazz){
        try {
            System.out.println("[printBeanIgnoreException]success:" + applicationContext.getBean(clazz));
        } catch (BeansException e) {
            System.out.println("[printBeanIgnoreException]exception:" + e.getMessage() + ",className:" +  clazz.getName());
//            e.printStackTrace();
        }
    }


    public static void printBeanIgnoreException(ApplicationContext applicationContext, String name, Class clazz){
        try {
            System.out.println("[printBeanIgnoreException]success:" + applicationContext.getBean(name, clazz));
        } catch (BeansException e) {
            System.out.println("[printBeanIgnoreException]exception:" + e.getMessage() + ",name:"+ name+ ",className:" + clazz.getName());
//            e.printStackTrace();
        }
    }
}
