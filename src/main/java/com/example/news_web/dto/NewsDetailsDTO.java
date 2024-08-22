package com.example.news_web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDetailsDTO {
    private String id;

    private NewsItemDTO newsItem;

    private NewsCategoryDTO newsCategory;
}
