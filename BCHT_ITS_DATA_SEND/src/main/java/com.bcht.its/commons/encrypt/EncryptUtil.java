package com.bcht.its.commons.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密明文工具类，其它包含 MD2,MD5,SHA1,SHA256,SHA384,SHA512
 *
 */
public class EncryptUtil {
	public static String MD2 = "MD2";
	public static String MD5 = "MD5";
	public static String SHA1 = "SHA-1";
	public static String SHA256 = "SHA-256";
	public static String SHA384 = "SHA-384";
	public static String SHA512 = "SHA-512";
	
	/**
     * @param str 加密明文
     * @param algorithm 加密算法
     * @return 加密结果字符串
     */
    public static String encrypt(String str, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] res = messageDigest.digest();
            return byte2hex(res);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str;
        }
    }
	
    /**
     * 将byte数组转换为16进制表示
     * 
     * @param byteArray
     * @return
     */
    private static String byte2hex(byte[] byteArray) {
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
 
        }
        return md5StrBuff.toString();
    }

    public static void main(String[] args){
        System.out.println(EncryptUtil.encrypt("admin",EncryptUtil.MD5));
    }
}