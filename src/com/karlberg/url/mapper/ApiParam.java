package com.karlberg.url.mapper;

import org.apache.commons.lang.StringUtils;

public class ApiParam {

    final String iValue;
    final String iName;
    private final boolean isRequired;
    private final int iMaxLen;

    public ApiParam( String name, String value, boolean required, int maxLen ) throws Exception {
        iValue = StringUtils.isBlank( value ) ? "" : value;
        iName = name;
        isRequired = required;
        iMaxLen = maxLen;
        validate();
    }

    public void validate() throws Exception {
        if (isRequired && StringUtils.isBlank(iValue))
            throw new Exception("param: "+iName+" is required!");
        if ( StringUtils.isNotBlank(iValue) && iValue.length() > iMaxLen )
            throw new Exception("param "+iName+ " is too long, was: "+ iValue.length() + " cant be larger than: "+iMaxLen);
    }
}
