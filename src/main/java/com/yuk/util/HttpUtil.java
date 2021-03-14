package com.yuk.util;

import com.xiaopeng.common_component.enums.CharsetEnum;
import com.xiaopeng.common_component.enums.ErrorCode;
import com.xiaopeng.common_component.exception.DataAccessException;
import com.xiaopeng.common_component.io.ResourceUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpUtil {

    public static void main(String[] args) throws DataAccessException {
        String sendData = "{\n" +
                "    \"loginUid\":0,\n" +
                "    \"pageSize\": 1,\n" +
                "    \"uid\": 107183711,\n" +
                "    \"page\": 1\n" +
                "}";
        String contentType = "application/json";
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-type", contentType);
        // 不加这个header, 会返回401的http状态码
        headerMap.put("logan", "test");
        String url = "http://logan-gateway.test.logan.xiaopeng.local/xp-sns-boot/logan/thread/feed";
        String responseStr = post(url, sendData, headerMap, CharsetEnum.UTF_8.getValue(), CharsetEnum.UTF_8.getValue());
        System.out.println("=============" + responseStr);

        url = "http://logan-gateway.test.logan.xiaopeng.local/xp-content-admin-boot/admin/enums/getEnums";
        responseStr = get(url, CharsetEnum.UTF_8.getValue());
        System.out.println("=============" + responseStr);

        url = "http://logan-gateway.test.logan.xiaopeng.local/xp-content-admin-boot/info";
        responseStr = get(url, CharsetEnum.UTF_8.getValue());
        System.out.println("=============" + responseStr);

        String host = "http://logan-gateway.test.logan.xiaopeng.local/";
        responseStr = postRequest(host, "xp-sns-boot", "/logan/thread/feed", contentType, sendData, CharsetEnum.UTF_8.getValue(), CharsetEnum.UTF_8.getValue());
        System.out.println("=============" + responseStr);
        responseStr = getRequest(host, "xp-content-admin-boot", "/admin/enums/getEnums", CharsetEnum.UTF_8.getValue());
        System.out.println("=============" + responseStr);
    }

    public static String getUrl(String host, String serviceName, String uri) {
        String url = "";
        url += host;
        if (host.contains("logan-gateway.test.logan.xiaopeng.local")) {
            url += serviceName;
        }
        url += uri;
        return url;
    }

    public static String postRequest(String host, String serviceName, String uri, String contentType, String data, String sendCharset, String receiveCharset) throws DataAccessException {
        String url = getUrl(host, serviceName, uri);
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-type", contentType);
        if (host.contains("logan-gateway.test.logan.xiaopeng.local")) {
            headerMap.put("logan", "test");
        }
        return post(url, data, headerMap, sendCharset, receiveCharset);
    }

    public static String getRequest(String host, String serviceName, String uri, String receiveCharset) throws DataAccessException {
        String url = getUrl(host, serviceName, uri);
        return get(url, receiveCharset);
    }

    public static String post(String url, String content, Map<String, String> headerMap, String sendCharset, String receiveCharset)
            throws DataAccessException {
        OutputStream os = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;

        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-type", contentType);
//            if (url.contains("logan-gateway.test.logan.xiaopeng.local")) {
//                connection.setRequestProperty("logan", "test");
//            }
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            os = connection.getOutputStream();
            os.write(content.getBytes(sendCharset));
            os.flush();

            int code = connection.getResponseCode();
            if (code != 200) {
                throw new DataAccessException(ErrorCode.ER_ResponseStateError,
                        "Http Response Code is not 200, code:" + code);
            }

            StringBuffer response = new StringBuffer(1024);

            is = connection.getInputStream();
            isr = new InputStreamReader(is, receiveCharset);
            bf = new BufferedReader(isr);

            String line = null;
            while ((line = bf.readLine()) != null) {
                response.append(line);
            }

            connection.disconnect();

            return response.toString();
        } catch (DataAccessException e) {
            throw e;
        } catch (UnsupportedEncodingException e) {
            throw new DataAccessException(ErrorCode.ER_EncodeError, e);
        } catch (ProtocolException e) {
            throw new DataAccessException(ErrorCode.ER_ProtocolError, e);
        } catch (IOException e) {
            throw new DataAccessException(ErrorCode.ER_IO, e);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new DataAccessException(ErrorCode.ER_Unknown, e);
        } finally {
            ResourceUtil.closeGracefully(os);
            ResourceUtil.closeGracefully(bf);
            ResourceUtil.closeGracefully(isr);
            ResourceUtil.closeGracefully(is);
        }
    }

    public static String get(String url, String receiveCharset) {
        InputStream is = null;
        BufferedReader bf = null;
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code != 200) {
                return null;
            }

            is = connection.getInputStream();

            StringBuffer response = new StringBuffer(1024);
            bf = new BufferedReader(new InputStreamReader(is, receiveCharset));
            String line = null;
            while ((line = bf.readLine()) != null) {
                response.append(line);
            }
            is.close();
            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ResourceUtil.closeGracefully(bf);
            ResourceUtil.closeGracefully(is);
        }
    }
}
