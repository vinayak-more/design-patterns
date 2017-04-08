package com.retro.web.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
@Component
public class PasswordUtils {

    public String getHash(String password) {
        return DigestUtils.sha1Hex(password);
    }

}
