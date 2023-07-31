package com.tomasjuan007.javalab.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {

    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5DigestAsHex(byte[] bytes) {
        return digestAsHexString("MD5", bytes);
    }

    private static String digestAsHexString(String algorithm, byte[] bytes) {
        char[] hexDigest = digestAsHexChars(algorithm, bytes);
        return new String(hexDigest);
    }

    private static char[] digestAsHexChars(String algorithm, byte[] bytes) {
        byte[] digest = digest(algorithm, bytes);
        return encodeHex(digest);
    }

    private static byte[] digest(String algorithm, byte[] bytes) {
        return getDigest(algorithm).digest(bytes);
    }

    private static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException var2) {
            throw new IllegalStateException("Could not find MessageDigest with algorithm \"" + algorithm + "\"", var2);
        }
    }

    private static char[] encodeHex(byte[] bytes) {
        char[] chars = new char[32];

        for(int i = 0; i < chars.length; i += 2) {
            byte b = bytes[i / 2];
            chars[i] = HEX_CHARS[b >>> 4 & 15];
            chars[i + 1] = HEX_CHARS[b & 15];
        }

        return chars;
    }

    public static void main(String[] args) {
        String md5 = DigestUtils.md5DigestAsHex("hello".getBytes());
        System.out.println(md5);

        String sha1 = DigestUtils.digestAsHexString("SHA-1", "hello".getBytes());
        System.out.println(sha1);

        byte a = (byte) Integer.MAX_VALUE; //-1, 1 bytes, overflow
        int i = a & 0xff; //255, 4 bytes
        String hex = Integer.toHexString(i);
        System.out.println(hex);

        System.out.println(Integer.toHexString(Integer.MAX_VALUE));
    }
}
