package com.retro.web.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
public class PasswordUtils {

    public static String getHash(String password) {
        return DigestUtils.sha1Hex(password);
    }

}
