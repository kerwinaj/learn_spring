package com.yuk.tool;


import cn.hutool.core.io.file.FileReader;
import com.google.common.collect.Sets;
import com.yuk.util.SetUtil;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileDiff {
    public static void main(String[] args) {

        String file1= "D:\\workDoc\\01-sns\\统一马甲\\2020-9-18-所有马甲.txt";
        String file2= "D:\\workDoc\\01-sns\\统一马甲\\2020-9-18-所有车主身份白名单.txt";

        FileReader fileReader1 = new FileReader(file1);
        String result1 = fileReader1.readString();
//        System.out.println(result1);
        FileReader fileReader2 = new FileReader(file2);
        String result2 = fileReader2.readString();
//        System.out.println(result2);

//        String[] file1Arr = StringUtils.split(result1, System.lineSeparator());
//        String[] file2Arr = StringUtils.split(result2, System.lineSeparator());
        String[] file1Arr = result1.split(System.lineSeparator());
        String[] file2Arr = result2.split(System.lineSeparator());
        System.out.println(file1Arr.length);
        System.out.println(file2Arr.length);

        Set<String> set1 = new HashSet<>(Arrays.asList(file1Arr));
        Set<String> set2 = new HashSet<>(Arrays.asList(file2Arr));

        SetUtil.setCalc(set1, set2);
    }
}
