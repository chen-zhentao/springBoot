package com.czt.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class EnctypeUtil {
    //加密算法的名字
    private static String algorithmName = "MD5";
    //迭代次数
    private static int hashIterations = 1024;


    public static String encPassword(String oldPassword , Object salt){
        SimpleHash simpleHash = new SimpleHash(algorithmName, oldPassword, salt, hashIterations);
        String str = simpleHash.toBase64();
        return str;
    }

    public static void main(String[] args) {
        String admin = encPassword("123456", "admin");
        System.out.println(admin);
    }

}
