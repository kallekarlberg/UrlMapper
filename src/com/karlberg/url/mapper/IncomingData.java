package com.karlberg.url.mapper;

import java.util.Map;

public class IncomingData {

    private String stringVal;
    private boolean boolVal;
    private long numVal;

    public String getStringVal() {
        return stringVal;
    }
    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }
    public boolean isBoolVal() {
        return boolVal;
    }
    public void setBoolVal(boolean boolVal) {
        this.boolVal = boolVal;
    }
    public long getNumVal() {
        return numVal;
    }
    public void setNumVal(long numVal) {
        this.numVal = numVal;
    }
    public double getFloatVal() {
        return floatVal;
    }
    public void setFloatVal(double floatVal) {
        this.floatVal = floatVal;
    }
    public Map<String, String> getMapVal() {
        return mapVal;
    }
    public void setMapVal(Map<String, String> mapVal) {
        this.mapVal = mapVal;
    }
    private double floatVal;
    private Map<String,String> mapVal;
}
