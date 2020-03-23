package com.yuanjie.springboot.modules;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

/**
 * description
 * 消息相关业务测试类
 * @author yuanjie 2020/03/17 17:58
 */
@SpringBootTest
class MessageControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        saveMessages();
    }

    @RepeatedTest(5) // 重复执行5次
//    @Order(1) // 执行顺序, 数字越小优先级越高
    void saveMessages() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("text", "hello world, i'm coming!");
        params.add("summary", "hello");
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/message")
                .params(params)).andReturn().getResponse().getContentAsString();
        System.out.println("Result === " + mvcResult);
    }

    @Test
    void getMessages() throws Exception {
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/message"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result === " + mvcResult);
    }

    @Test
    void delMessage() throws Exception {
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/message/1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result === " + mvcResult);
    }

    @Test
    void getMessageById() throws Exception {
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/message/1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result === " + mvcResult);
    }

    @Test
    void modifyMessage() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "1");
        params.add("text", "hello world, i'm back!");
        params.add("summary", "back");
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/message")
                .params(params)).andReturn().getResponse().getContentAsString();
        System.out.println("Result === " + mvcResult);
    }

    @Test
    void modifyPartMessage() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "1");
        params.add("text", "hello world, i'm ready!");
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/message/text")
                .params(params)).andReturn().getResponse().getContentAsString();
        System.out.println("Result === " + mvcResult);
    }
}
