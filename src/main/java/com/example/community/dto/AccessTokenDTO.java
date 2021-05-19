package com.example.community.dto;

import lombok.Data;

//参数超过两个以上，封装成对象来做
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;

}
