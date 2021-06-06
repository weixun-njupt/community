package com.example.community.dto;

import com.example.community.model.User;
import lombok.Data;

//data自动get set 重写tostring
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewcount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
