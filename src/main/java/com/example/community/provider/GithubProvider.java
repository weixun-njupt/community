package com.example.community.provider;

import com.alibaba.fastjson.JSON;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//对第三方支持的能力
@Component
public class GithubProvider {
    //调取url地址 返回参数
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
       MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();
            String[] split = string.split("&");
            String tokenstr=split[0];
            String token=tokenstr.split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GitHubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String strig=response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(strig, GitHubUser.class);   //String的json对象自动转化为类对象
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
