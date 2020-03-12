package com.yuanjie.springboot;

import com.yuanjie.springboot.controller.LoginController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * description:
 * 登录请求测试
 * @author yuanjie 2020/03/12 16:29
 */
@SpringBootTest
public class LoginTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
    }

    @Test
    public void login() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("username", "1")
                .param("password", "2")
                .param("age", "3")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public void hello() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }
}
