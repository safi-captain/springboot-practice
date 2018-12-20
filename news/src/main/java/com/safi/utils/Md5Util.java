package com.safi.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * Created by xiefeng
 * Time 2018/9/27
 */
public class Md5Util {
    private final static String BASE_STR = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final static Integer SALT_LENGTH = 12;

    public static String getSalt() {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SALT_LENGTH; i++) {
            result.append(BASE_STR.charAt(random.nextInt(BASE_STR.length())));
        }
        return DigestUtils.md5DigestAsHex(result.toString().getBytes());
    }

    public static String makeMd5Password(String password, String salt, int times) {
        return new SimpleHash("MD5", password, salt, times).toString();
    }

    public static void main(String[] args) {
        String loginAccount = "safi";
        String salt = loginAccount + getSalt();
        String password = "123456";

        System.out.println("---------------" + salt);

        String result = makeMd5Password(password, salt, 2);
        System.out.println("---------------" + result);
    }
}
