package com.english.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * TODO
 *
 * @author Mwg
 * @version 1.0
 * @date 2019/4/28 18:04
 */
@Slf4j
public class TranslateService {

    private static final String YOUDAO_URL = "https://openapi.youdao.com/api";

    private static final String APP_KEY = "0a503bbd6348e6f5";

    private static final String APP_SECRET = "rTxJ8Sp6CnryqwFkmoEq1EPFq936JOm6";

    public static String getTranslateResult(String q) throws IOException {
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        String salt = String.valueOf(System.currentTimeMillis());
        params.add("from", "EN");
        params.add("to", "zh-CHS");
        params.add("signType", "v3");
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        params.add("curtime", curtime);
        String signStr = APP_KEY + truncate(q) + salt + curtime + APP_SECRET;
        String sign = getDigest(signStr);
        params.add("appKey", APP_KEY);
        params.add("q", q);
        params.add("salt", salt);
        params.add("sign", sign);
        /** 处理结果 */
        log.info(params.toString());
        String result = CommonService.sendPostRequest(YOUDAO_URL,params);
        log.info(result);
        return result;
    }


    /**
     * 生成加密字段
     */
    public static String getDigest(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes();
        try {
            MessageDigest mdInst = MessageDigest.getInstance("SHA-256");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     *
     * @param result 音频字节流
     * @param file 存储路径
     */
    private static void byte2File(byte[] result, String file) {
        File audioFile = new File(file);
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(audioFile);
            fos.write(result);

        }catch (Exception e){
            log.info(e.toString());
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }
}
