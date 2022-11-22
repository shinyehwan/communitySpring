package com.ll.exam;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleDto {
    private long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String title;
    private String body;
    private boolean isBlind;
}
