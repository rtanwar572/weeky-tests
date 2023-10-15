package com.Rohit.Service.HashingUtility;

import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static jakarta.xml.bind.DatatypeConverter.printHexBinary;

public class PassEncryptor {
    public static String encrypt(String unHashedPassword) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");

        md5.update(unHashedPassword.getBytes());
        byte[]digested=md5.digest();
        return DatatypeConverter.printHexBinary(digested);

    }
}
