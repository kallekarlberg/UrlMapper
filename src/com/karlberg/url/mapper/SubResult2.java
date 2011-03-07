package com.karlberg.url.mapper;

import java.util.Map;

import org.apache.commons.lang.StringUtils;


public class SubResult2 {

    private final ApiParam subNbr1;
    private final ApiParam subFloat1;

    SubResult2(Map<String, String> map) throws Exception {
        subNbr1 = new ApiParam("sub1Nbr", 
                map.get(IncomingDataConstant.KEY_RES_SUB2_INT), true, 500 );
        subFloat1 = new ApiParam("sub1Float", 
                map.get(IncomingDataConstant.KEY_RES_SUB2_FLOAT), true, 500 );
    }

    public int getSubNbr1() {
        return StringUtils.isBlank( subNbr1.iValue ) ? 0 : Integer.parseInt(subNbr1.iValue);
    }
    public double getSubFloat1() {
        return StringUtils.isBlank( subFloat1.iValue ) ? 0.0 : Double.parseDouble(subFloat1.iValue);
    }

    public String toUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append( Util.mkUrlPart(IncomingDataConstant.KEY_RES_SUB2_INT, subNbr1.iValue));
        sb.append( Util.mkUrlPart(IncomingDataConstant.KEY_RES_SUB2_FLOAT, subFloat1.iValue));
        return sb.toString();
    }
}
