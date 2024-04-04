package com.github.controller;

import com.ctrip.framework.apollo.mockserver.EmbeddedApollo;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class UserControllerITTest {

    @ClassRule
    public final static EmbeddedApollo embeddedApollo = new EmbeddedApollo();

    @Resource
    private MockMvc mockMvc;

    @Test
    public void test_getUser_ok_WHITELIST() throws Exception {
        embeddedApollo.addOrModifyProperty("application", "keySwitch", "WHITELIST");
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/1"));
        String content = resultActions.andReturn().getResponse().getContentAsString();
        Assert.assertEquals(content, "user-WHITELIST-1");
    }

    @Test
    public void test_getUser_ok_ALL() throws Exception {
        embeddedApollo.addOrModifyProperty("application", "keySwitch", "ALL");
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/1"));
        String content = resultActions.andReturn().getResponse().getContentAsString();
        Assert.assertEquals(content, "user-ALL-1");
    }
}
