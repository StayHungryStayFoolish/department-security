package io.github.stayhungrystayfoolish.web.rest.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by bonismo@hotmail.com on 2018/7/21 下午11:11
 *
 * @Version: V1.0.0
 * <p>
 * Description: Base64 use to decode / encode
 */
public class SunBase64Util {

    /**
     * Encode plain string
     *
     * @param plain plain string
     * @return decode string
     */
    public static String encode(String plain){
        return encodeByte(plain.getBytes());
    }

    /**
     * Decode String
     *
     * @param encoder encode string
     * @return plain string
     */
    public static String decode(String encoder){
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(encoder);
            return new String(bytes);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Encode bytes
     *
     * @param bytes string converted bytes
     * @return encode bytes
     */
    private static String encodeByte(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }

    public static void main(String[] args) {
        System.out.println(encode("admin"));
        System.out.println(encode("admin.admin"));

        System.out.println(decode("cTExMTExMTExMTExMTExMQ=="));
        System.out.println(decode("cTExMTExMTExMTExMTExMQ==").length());
    }
}


