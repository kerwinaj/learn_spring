package com.yuk.util;

import com.xiaopeng.common_component.enums.CharsetEnum;
import com.xiaopeng.common_component.enums.ErrorCode;
import com.xiaopeng.common_component.exception.DataAccessException;
import com.xiaopeng.common_component.io.ResourceUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class HttpUtil {

    public static void main(String[] args) throws DataAccessException {
        String host = "http://logan-gateway.test.logan.xiaopeng.local/xp-sns-boot";
        System.out.println(loganThreadFeed(host));
    }

    public static String loganThreadFeed(String host) throws DataAccessException {
        String uri = "/logan/thread/feed";
        String content = "{\n" +
                "    \"loginUid\":0,\n" +
                "    \"pageSize\": 1,\n" +
                "    \"uid\": 107183711,\n" +
                "    \"page\": 1\n" +
                "}";
        String contentType = "application/json";
        String responseStr = post(host + uri, content, contentType, CharsetEnum.UTF_8.getValue(), CharsetEnum.UTF_8.getValue());
        return responseStr;
    }

    public static String post(String url, String content, String contentType, String sendCharset, String receiveCharset)
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
            connection.setRequestProperty("Content-type", contentType);
            if (url.contains("logan-gateway.test.logan.xiaopeng.local")) {
                connection.setRequestProperty("logan", "test");
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

}
