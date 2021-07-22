package com.beta.replyservice.service;

import com.beta.replyservice.model.ReplyData;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Override
    public ReplyData replyData(String request) {
        String rules = request.split("-")[0];
        String msg = request.split("-")[1];

        for (int i=0;i<rules.length();i++){
            msg = processRule(i,Integer.parseInt(String.valueOf(rules.charAt(i))),msg);
        }

        return new ReplyData(msg);
    }

    private static String processRule(int ruleSet, int rule, String data){
        if(ruleSet ==0 ) {
            switch (rule) {
                case 1:
                    return data;
                case 2:
                    return new StringBuffer(data).reverse().toString();
                default: return null;
            }
        }
        else if (ruleSet==1){
            switch (rule){
                case 1:
                    return data;
                case 2:
                    return DigestUtils.md5DigestAsHex(data.getBytes(StandardCharsets.UTF_8));
                default: return null;
            }
        }
        return null;
    }

}
