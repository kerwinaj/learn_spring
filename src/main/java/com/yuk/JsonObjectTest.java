package com.yuk;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonObjectTest {
    public static void main(String[] args) {
        String test = "{\n" +
                "            \"album\":{\n" +
                "\n" +
                "            },\n" +
                "            \"artist\":{\n" +
                "\n" +
                "            },\n" +
                "            \"canPlay\":true,\n" +
                "            \"favourite\":true,\n" +
                "            \"fileList\":[\n" +
                "                {\n" +
                "                    \"fileSize\":2284711,\n" +
                "                    \"hash\":\"BCC5D6F7F66CF02BFEB4F48E1D1B9460\",\n" +
                "                    \"needVip\":false,\n" +
                "                    \"privilege\":0,\n" +
                "                    \"quality\":1\n" +
                "                }\n" +
                "            ],\n" +
                "            \"hash\":\"BCC5D6F7F66CF02BFEB4F48E1D1B9460\",\n" +
                "            \"needVip\":false,\n" +
                "            \"privilegeInfo\":{\n" +
                "                \"canPlay\":true,\n" +
                "                \"failProcess\":0,\n" +
                "                \"hash\":\"BCC5D6F7F66CF02BFEB4F48E1D1B9460\",\n" +
                "                \"privilege\":0,\n" +
                "                \"status\":1\n" +
                "            },\n" +
                "            \"singers\":\"陈乐一\",\n" +
                "            \"songName\":\"青鸟 (2018中国梦之声·下一站传奇第3期现场)\"\n" +
                "        }";
        JSONObject jobj = JSONObject.parseObject(test);

        JSONObject album = jobj.getJSONObject("album");
        Long albumId =album.getLong("id");
        System.out.println("album:"+album);
        System.out.println("albumId:"+albumId);
        Map<Long, Object> xpIndexSongMap = new HashMap<>();
        Object obj = xpIndexSongMap.get(albumId);
        System.out.println("obj:"+obj);

        System.out.println(jobj.getString("songName"));
        System.out.println(jobj.getString("singers"));


        /**
         * http://caibaojian.com/jsonobject.html
         */

        String arrayStr = "[{'name1':{'name2':{'name3':'value3','name4':'valhhue4'}}}]";

        JSONArray getJsonArray=JSONArray.parseArray(arrayStr);//将结果转换成JSONArray对象的形式
        JSONObject getJsonObj = getJsonArray.getJSONObject(0);//获取json数组中的第一项
        JSONObject name1 = getJsonObj.getJSONObject("name1");
        JSONObject name2 = name1.getJSONObject("name2");
//        JSONObject name4 = name2.getJSONObject("name4"); 报错
//        System.out.println(name4.getString("name4"));
        System.out.println(name2.getString("name4"));

        /*
        https://blog.csdn.net/weixin_34356555/article/details/86024006
        */
        String str = "{\"baid\":null,\"32d2\":\"test111\", \"32d3\":\"null\",433:\"0x32\",032:\"ju9fw\"}";
        com.alibaba.fastjson.JSONObject jm = com.alibaba.fastjson.JSON.parseObject(str);
        System.out.println(jm.get(32)+"," + jm.getString("32"));
        System.out.println(jm.get(433));
        System.out.println(jm.get("baid"));
        System.out.println(jm.get("32d2")+"," + jm.getString("32d2"));

        String jsonMessage = "[{'num':'成绩', '外语':88, '历史':65, '地理':99, 'object':{'aaa':'1111','bbb':'2222','cccc':'3333'}}," +
                "{'num':'兴趣', '外语':28, '历史':45, '地理':19, 'object':{'aaa':'11a11','bbb':'2222','cccc':'3333'}}," +
                "{'num':'爱好', '外语':48, '历史':62, '地理':39, 'object':{'aaa':'11c11','bbb':'2222','cccc':'3333'}}]";
        jsonMessage = "[{'object':{'aaa':{'bbb':'2222','cccc':'3333'}}}]";
        jsonMessage = "[{'name1':{'name2':{'name3':'value3','name4':'valhhue4'}}}]";
        jsonMessage = "[{'name1':{'name2':{'name3':'value3','name4':'valhhue4'}}}]";

        JSONArray myJsonArray = JSONArray.parseArray(jsonMessage);
        System.out.println(myJsonArray);

        // https://www.cnblogs.com/JP6907/p/8732787.html
    }
}
