package com.karlberg.url.mapper;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class SubResult1 {

    private final ApiParam subString1;
    private final ApiParam subBool1;

    SubResult1(Map<String, String> map) throws Exception {
        subString1 = new ApiParam("sub1String", 
                map.get(IncomingDataConstant.KEY_RES_SUB1_STRING), true, 15 );
        subBool1 = new ApiParam("sub1Bool", 
                map.get(IncomingDataConstant.KEY_RES_SUB1_BOOL), false, 500 );
    }

    public String getSubString1() {
        return subString1.iValue;
    }
    public boolean isSubBool1() {
        return StringUtils.isBlank( subBool1.iValue ) ? false : Boolean.parseBoolean(subBool1.iValue );
    }

    public String toUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append(Util.mkUrlPart(IncomingDataConstant.KEY_RES_SUB1_BOOL, subBool1.iValue));
        sb.append(Util.mkUrlPart(IncomingDataConstant.KEY_RES_SUB1_STRING,subString1.iValue));
        return sb.toString();
    }
}
