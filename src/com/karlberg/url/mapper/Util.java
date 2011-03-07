package com.karlberg.url.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


public class Util {

    public static String getValFromUrl(String url, String key) {
        return nvpMapFormUrl(url, ";").get(key);
    }

    public static String mkUrlPart(String urlKey, String val) {
        return urlKey+"="+val+";";
    }

    public static Map<String,String> nvpMapFormUrl(String url, String delim) {
        String[] split = StringUtils.split(url,delim);
        Map<String,String> res = new HashMap<String, String>();
        for (String tok : split) {
            String[] sub = StringUtils.split(tok,"=");
            res.put(sub[0], sub[1]);
        }
        return res;
    }
}
