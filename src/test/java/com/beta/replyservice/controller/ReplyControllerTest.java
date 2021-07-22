package com.beta.replyservice.controller;

import com.beta.replyservice.model.ReplyData;
import com.beta.replyservice.service.ReplyService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ReplyController.class)
class ReplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReplyService replyService;

    @Test
    void replyRule12() throws Exception{
        ReplyData data = new ReplyData("0fafeaae780954464c1b29f765861fad");
        Mockito.when(replyService.replyData("12-kbzw9ru")).thenReturn(data);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/reply/12-kbzw9ru").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
        String expectedResult = "{data:0fafeaae780954464c1b29f765861fad}";
        JSONAssert.assertEquals(expectedResult, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    void replyRule11() throws Exception{
        ReplyData data = new ReplyData("kbzw9ru");
        Mockito.when(replyService.replyData("11-kbzw9ru")).thenReturn(data);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/reply/11-kbzw9ru").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
        String expectedResult = "{data:kbzw9ru}";
        JSONAssert.assertEquals(expectedResult, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    void replyRule21() throws Exception{
        ReplyData data = new ReplyData("ur9wzbk");
        Mockito.when(replyService.replyData("21-kbzw9ru")).thenReturn(data);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/reply/21-kbzw9ru").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
        String expectedResult = "{data:ur9wzbk}";
        JSONAssert.assertEquals(expectedResult, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    void replyRule22() throws Exception{
        ReplyData data = new ReplyData("5a8973b3b1fafaeaadf10e195c6e1dd4");
        Mockito.when(replyService.replyData("22-kbzw9ru")).thenReturn(data);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/reply/22-kbzw9ru").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
        String expectedResult = "{data:5a8973b3b1fafaeaadf10e195c6e1dd4}";
        JSONAssert.assertEquals(expectedResult, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    void replyBadRequest() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/reply/QWAWQWQ").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals("", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void replyBadRequest2() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/reply/123123-adadsa21d1").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals("", mvcResult.getResponse().getContentAsString());
    }

}
