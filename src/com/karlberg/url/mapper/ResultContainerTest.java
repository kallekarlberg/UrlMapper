package com.karlberg.url.mapper;

import org.junit.Assert;
import org.junit.Test;

public class ResultContainerTest {

    @Test
    public void testResultContainerAllOk() throws Exception {
        String url = "A=subString;B=true;C=123;D=0.123;TOP=topVal;";
        ResultContainer c = new ResultContainer(url);
        Assert.assertEquals("topVal",c.getTopLevelString());
        Assert.assertEquals("subString",c.getRes1().getSubString1());
        Assert.assertEquals(true,c.getRes1().isSubBool1() );
        Assert.assertTrue(0.123 == c.getRes2().getSubFloat1());
        Assert.assertEquals(123,c.getRes2().getSubNbr1());
    }

    public void testResultContainerNeedReq() throws Exception {
        String url = "A=subString;B=true;C=123;D=0.123;TOP=;";
        try {
            new ResultContainer(url);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().indexOf("required")!=-1);
        }
    }

    public void testResultContainerSymmetric() throws Exception {
        String url = "A=subString;B=true;C=123;D=0.123;TOP=topString;";
        ResultContainer start = new ResultContainer(url);
        String resUrl = start.toUrl();

        ResultContainer c = new ResultContainer(resUrl);
        Assert.assertEquals("topVal",c.getTopLevelString());
        Assert.assertEquals("subString",c.getRes1().getSubString1());
        Assert.assertEquals(true,c.getRes1().isSubBool1() );
        Assert.assertTrue(0.123 == c.getRes2().getSubFloat1());
        Assert.assertEquals(123,c.getRes2().getSubNbr1());
    }
}
