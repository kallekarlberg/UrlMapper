package com.karlberg.url.mapper;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class ResultContainer {

    private final SubResult1 res1;
    private final SubResult2 res2;

    private final ApiParam iTopLevelString;

    public ResultContainer(String url) throws Exception {
        Map<String, String> m = Util.nvpMapFormUrl(url, ";");
        iTopLevelString = new ApiParam("topLevel", m.get(IncomingDataConstant.KEY_RES_TOP_STRING), true, 15);
        res1 = new SubResult1(m);
        res2 = new SubResult2(m);
    }

    public String toUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append( Util.mkUrlPart(IncomingDataConstant.KEY_RES_TOP_STRING, iTopLevelString.iValue ));
        sb.append( res1.toUrl() );
        sb.append( res2.toUrl() );
        return sb.toString();
    }

    public String getTopLevelString() {
        return StringUtils.isBlank(iTopLevelString.iValue) ? "":iTopLevelString.iValue;
    }

    public SubResult1 getRes1() {
        return res1;
    }
    public SubResult2 getRes2() {
        return res2;
    }
}
